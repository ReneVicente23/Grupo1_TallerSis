package bo.ucb.edu.TallerSis.API;

import bo.ucb.edu.TallerSis.BL.DishBL;
import bo.ucb.edu.TallerSis.BL.OrderBL;
import bo.ucb.edu.TallerSis.BL.UserBL;
import bo.ucb.edu.TallerSis.BL.User_addressBL;
import bo.ucb.edu.TallerSis.DTO.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class UsuarioAPI {
    private UserBL UserBL;
    private DishBL DishBL;
    private OrderBL OrderBL;
    private User_addressBL User_addressBL;

    public UsuarioAPI(UserBL userBL,DishBL dishBL,OrderBL orderBL,User_addressBL user_addressBL) {
        this.UserBL = userBL;
        this.DishBL = dishBL;
        this.OrderBL = orderBL;
        this.User_addressBL= user_addressBL;
    }

    @PostMapping(path="/user/new", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public User create_user(@RequestBody User user) {
        System.out.println("llega a API");
        UserBL.newUsuario(user.getName(), user.getLast_name(), user.getPhone(),user.getMail());
        return user;
    }// NO SE ES DE SERGIO

    @PostMapping(path="/users/login", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public User2 authtry(@RequestBody Pass pass) {
        System.out.println("llega a API");
        User2 user2=UserBL.autht(pass.getEmail(), pass.getPassword());
        if(user2 == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Usuario o contraseña incorrecta (CODE 400)\n");
        }else{
            return user2;
        }
    }//intento de auth

    @GetMapping(path="/foods", produces = APPLICATION_JSON_VALUE)
    public List<Food> findFOODs() {
        return DishBL.findFood();
    }//OBTIENE TODOS LOS PLATAOS DE LA BD
    @GetMapping(path="/foods/{foodid}", produces = APPLICATION_JSON_VALUE)
    public Food findFOODId(@PathVariable("foodid") Integer id) {
        return DishBL.findFoodId(id);
    }//OBTIENE UN PLATO DE LA BD
    @GetMapping(path="/foods/tags", produces = APPLICATION_JSON_VALUE)
    public List<String> tags() {
        List<String> result = new ArrayList<String>();
        result.add("comida");
        result.add("rapida");
        return result;
    }//OBTIENE TODOS LOS PLATAOS DE LA BD

    @PostMapping(path="/orders/create", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public Orders inseruseraddress(@RequestHeader("access_token") String token, @RequestBody Orders orders) {
        CartItem[] cart = orders.getItems();
        //System.out.println(token);
        System.out.println(orders.getStatus()+" ** "+ orders.getPaymentId());
        //System.out.println(orders.getAddress()+"  "+orders.getName()+" "+orders.getItems().length+" - "+orders.getPaymentId());
        //System.out.println(cart[0].toString());
        OrderBL.savedelivery(User_addressBL.findiddres(Integer.parseInt(token)),1,Integer.parseInt(token));
        Delivery del=OrderBL.getdeliveryid(User_addressBL.findiddres(Integer.parseInt(token)),1,Integer.parseInt(token));
        Date dt= new Date(2022,12,10);//no importa
        Order or= new Order(0, orders.getTotalPrice(), 2,1,del.getId_delivery(),dt);
        OrderBL.saveOrder(or);
        or=OrderBL.findorderid(or);
        OrderBL.savedetail(cart,or.getId_order());
        return orders;
    }//Crea un delivery, luego crea un order y por ultimo un orderdetails
    @GetMapping(path="/orders/newOrderForCurrentUser", produces = APPLICATION_JSON_VALUE)
    public Orders getlastorder(@RequestHeader("access_token") String token) {
        //lat: -16.5139586, lng: -68.1307689
        System.out.println(token);
        Order order = OrderBL.findlastorder(Integer.parseInt(token));
        LatLng latLng= new LatLng("-16.5139586","-68.1307689");
        List<Dish> dishes= DishBL.findOrderDetails(order.getId_order());
        List<CartItem> cart1= new ArrayList<CartItem>();
        Double aux=0.0;
        for (Dish s: dishes){
            String[] tag={"comida", "rapida"};
            String[] origins={"Bolivia", "Test origin"};
            Food fd=new Food(s.getId_dish(),s.getName(),s.getCost(),tag,false,3.0,"assets/food-1.jpg",origins,"1 test");
            CartItem cri=new CartItem(fd,1,(s.getCost()*1));
            cart1.add(cri);
            aux=s.getCost()+aux;
        }
        CartItem[] cart=new CartItem[cart1.size()];
        for(int i=0; i< cart1.size();i++){
            cart[i]=cart1.get(i);
        }

        Orders orders=new Orders(order.getId_order(),cart,aux,"test","addresstest",latLng,null,order.getOrderdate()+"","in progress");

        return orders;
    }//OBTIENE TODOS LOS PLATAOS DE LA BD

}

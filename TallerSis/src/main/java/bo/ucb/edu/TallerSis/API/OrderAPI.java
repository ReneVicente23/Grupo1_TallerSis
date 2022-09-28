package bo.ucb.edu.TallerSis.API;

import bo.ucb.edu.TallerSis.BL.OrderBL;
import bo.ucb.edu.TallerSis.DTO.Address;
import bo.ucb.edu.TallerSis.DTO.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/order")
public class OrderAPI {
    private OrderBL orderBL;

    public OrderAPI(OrderBL orderBL) {
        this.orderBL = orderBL;
    }

    @GetMapping(path="/bussines/{bussinesid}/", produces = APPLICATION_JSON_VALUE)
    public List<Order> findbybussines(@PathVariable("bussinesid") Integer id) {
        return orderBL.findOrdersbyBussines(id);
    }//tested

    @PostMapping(path="/", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public Order insertorder(@RequestBody Order order) {
        orderBL.saveOrder(order);
        return order;
    }//tested

    @PutMapping(path="/cash", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public Order updatestatuspay(@RequestBody Order order) {
        orderBL.updateOrderStatus(order,2);
        orderBL.updateOrderPayStatus(order,1);
        return order;
    }//tested

    @PutMapping(path="/cash/pay", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public Order updatestatus(@RequestBody Order order) {
        orderBL.updateOrderStatus(order,3);
        return order;
    }//tested

    @GetMapping(path="/bussines/day/{bussinesid}", produces = APPLICATION_JSON_VALUE)
    public List<Order> findbybussinesday(@PathVariable("bussinesid") Integer id) {
        return orderBL.findOrdersbyBussinesday(id);
    }//tested

    @GetMapping(path="/bussines/day/pay/{bussinesid}", produces = APPLICATION_JSON_VALUE)
    public Double findbybussinespayday(@PathVariable("bussinesid") Integer id) {
        return orderBL.findpayday(id);
    }

    @GetMapping(path="/bussines/count/{state}/{bussinesid}", produces = APPLICATION_JSON_VALUE)
    public Integer findbycountday(@PathVariable("state") Integer st,@PathVariable("bussinesid") Integer id) {
        return orderBL.findcountday(id,st);
    }

    @GetMapping(path="/delivery/cash/pending/{bussinesid}", produces = APPLICATION_JSON_VALUE)
    public List<Order> findforpay(@PathVariable("bussinesid") Integer id) {
        return orderBL.findOrdersforpay(id);
    }

}

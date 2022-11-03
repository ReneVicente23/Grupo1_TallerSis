package bo.ucb.edu.TallerSis.API;

import bo.ucb.edu.TallerSis.BL.User_addressBL;
import bo.ucb.edu.TallerSis.DTO.Address;
import bo.ucb.edu.TallerSis.DTO.Order;
import bo.ucb.edu.TallerSis.DTO.User_address;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user")
public class User_addressAPI {
    private User_addressBL user_addressBL;

    public User_addressAPI(User_addressBL user_addressBL) {
        this.user_addressBL = user_addressBL;
    }

    @PostMapping(path="/address/new", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public User_address inseruseraddress(@RequestBody User_address user_address) {
       user_addressBL.saveuseraddress(user_address);
        return user_address;
    }//tested: GENERA UN NUEVO USER_ADDRESS REQUIER ID DE COORDENAS Y ADDRESS

    @PutMapping(path="/address/nick", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public User_address updatenick(@RequestBody User_address user_address) {
        user_addressBL.updatenick(user_address.getId_user_address(),user_address.getNickname());
        return user_address;
    }//tested MODIFICA EL NICK DE UNA DIRECCION

    @PutMapping(path="/address/status", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public User_address updatestatus(@RequestBody User_address user_address) {
        user_addressBL.updatestatus(user_address.getId_user_address(),user_address.getStatus());
        return user_address;
    }//tested CAMBI EL ESTATUS DE UNA DIRECCION SE DEBE MANDAR EL NUEVO ESTATUS DENTRO DEL BODY (EL BODY ES EL OBJETO SI O SI)

    @PutMapping(path="/address/fav", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public User_address updatefav(@RequestBody User_address user_address) {
        user_addressBL.updatefav(user_address.getId_user_address());
        return user_address;
    }//MARCA UNA DIRECCION COMO FAVORITA MODIFICANDO EL STATUS

    @GetMapping(path="/address/fav/{userid}", produces = APPLICATION_JSON_VALUE)
    public Integer findbybussinesday(@PathVariable("userid") Integer id) {
        return user_addressBL.findidfav(id);
    }//RETORNA LA DIRECCION FAVORITA DE UN USUARIO

    @PutMapping(path="/address/del", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public Address deleteaddress(@RequestBody Address address, @RequestHeader("access_token") String token) {
        user_addressBL.borrardir(Integer.parseInt(token),address.getId_address());
        //user_addressBL.updatestatus(user_address.getId_user_address(),user_address.getStatus());
        return address;
    }//Eliminacion logica de 1 direccion del usuario
}

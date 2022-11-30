package bo.ucb.edu.TallerSis.API;


import bo.ucb.edu.TallerSis.BL.AddressBL;
import bo.ucb.edu.TallerSis.BL.User_addressBL;
import bo.ucb.edu.TallerSis.DTO.Address;
import bo.ucb.edu.TallerSis.DTO.Nick;
import bo.ucb.edu.TallerSis.DTO.User_address;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user")
public class AddressAPI {
    private AddressBL addressBL;
    private User_addressBL user_addressBL;

    public AddressAPI(AddressBL addressBL, User_addressBL user_addressBL) {
        this.addressBL = addressBL;
        this.user_addressBL= user_addressBL;
    }

    @GetMapping(path="/address", produces = APPLICATION_JSON_VALUE)
    public List<Address> findaddressapi(@RequestHeader("access_token") String token) {
        return addressBL.findAddress(Integer.parseInt(token));
    }//tested: OBTIENE TODAS LAS DIRECCIONES DE UN USUARIO

    @GetMapping(path="/address/{addressid}", produces = APPLICATION_JSON_VALUE)
    public Address findaddressapiid(@PathVariable("addressid") Integer addressid) {
        return addressBL.findAddressid(addressid);
    }//tested: OBTIENE UNA DIRECCION POR ID

    @GetMapping(path="/address/nick/{addressid}", produces = APPLICATION_JSON_VALUE)
    public Nick fintnick(@PathVariable("addressid") Integer addressid) {
        return user_addressBL.obtieneNick(addressid);
    }//tested: OBTIENE UNA DIRECCION POR ID


    @PostMapping(path="/addresss", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public Address insertaddress(@RequestBody Address address) {
        addressBL.saveAddress(address);
        address.setId_address(addressBL.findidaddress(address));
        return address;
    }//tested: INGRESA UNA NUEVA DIRECCION (NO SE CONECTA CON NINGUN USUARIO, REQUIERE USER_ADDRESS)

    @PostMapping(path="/address", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public Address insertaddress2(@RequestBody Address address, @RequestHeader("access_token") String token) {
        addressBL.saveAddress(address);
        address.setId_address(addressBL.findidaddress(address));
        User_address us= new User_address(0,Integer.parseInt(token),address.getId_address(),1,"",1);
        user_addressBL.saveuseraddress(us);
        return address;
    }//tested: INGRESA UNA NUEVA DIRECCION

    @PutMapping(path="/address/nick/{nick}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public Address updatenick(@RequestBody Address address,@PathVariable("nick") String nick) {
        user_addressBL.updatenick(addressBL.findidaddress(address), nick);
        return address;
    }//tested MODIFICA EL NICK DE UNA DIRECCION

    @PostMapping(path="/address/up", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public Address updateaddress( @RequestBody Address address ) {
        addressBL.updateAddress(address);
        System.out.print(address.toString());
        return address;
    }//tested: MODIFICA UNA DIRECCION REQUIERE EL ID DE LA DIRECCION EN EL BODY Y EL RESTO DE DATOS SON LOS QUE SE SOBREESCRIBEN

}

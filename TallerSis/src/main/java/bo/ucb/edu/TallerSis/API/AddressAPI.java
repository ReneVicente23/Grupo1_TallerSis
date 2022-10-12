package bo.ucb.edu.TallerSis.API;


import bo.ucb.edu.TallerSis.BL.AddressBL;
import bo.ucb.edu.TallerSis.DTO.Address;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user")
public class AddressAPI {
    private AddressBL addressBL;

    public AddressAPI(AddressBL addressBL) {
        this.addressBL = addressBL;
    }

    @GetMapping(path="/address", produces = APPLICATION_JSON_VALUE)
    public List<Address> findaddressapi(@RequestHeader("access_token") String token) {
        return addressBL.findAddress(Integer.parseInt(token));
    }//tested: OBTIENE TODAS LAS DIRECCIONES DE UN USUARIO

    @GetMapping(path="/address/{addressid}", produces = APPLICATION_JSON_VALUE)
    public Address findaddressapiid(@PathVariable("addressid") Integer addressid) {
        return addressBL.findAddressid(addressid);
    }//tested: OBTIENE UNA DIRECCION POR ID

    @PostMapping(path="/address", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public Address insertaddress(@RequestBody Address address) {
        addressBL.saveAddress(address);
        address.setId_address(addressBL.findidaddress(address));
        return address;
    }//tested: INGRESA UNA NUEVA DIRECCION (NO SE CONECTA CON NINGUN USUARIO, REQUIERE USER_ADDRESS)

    @PutMapping(path="/address", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public Address updateaddress(@RequestBody Address address) {
        addressBL.updateAddress(address);
        return address;
    }//tested: MODIFICA UNA DIRECCION REQUIERE EL ID DE LA DIRECCION EN EL BODY Y EL RESTO DE DATOS SON LOS QUE SE SOBREESCRIBEN

}

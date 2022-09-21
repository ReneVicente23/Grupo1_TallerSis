package bo.ucb.edu.TallerSis.API;


import bo.ucb.edu.TallerSis.BL.AddressBL;
import bo.ucb.edu.TallerSis.DTO.Address;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/user")
public class AddressAPI {
    private AddressBL addressBL;

    public AddressAPI(AddressBL addressBL) {
        this.addressBL = addressBL;
    }

    @GetMapping(path="/{userid}/address/", produces = APPLICATION_JSON_VALUE)
    public List<Address> findaddressapi(@PathVariable("userid") Integer userid) {
        return addressBL.findAddress(userid);
    }//tested

    @GetMapping(path="/address/{addressid}", produces = APPLICATION_JSON_VALUE)
    public Address findaddressapiid(@PathVariable("addressid") Integer addressid) {
        return addressBL.findAddressid(addressid);
    }//tested
    @PostMapping(path="/address", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public Address insertaddress(@RequestBody Address address) {
        addressBL.saveAddress(address);
        return address;
    }//tested

    @PutMapping(path="/address", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public Address updateaddress(@RequestBody Address address) {
        addressBL.updateAddress(address);
        return address;
    }//tested

}

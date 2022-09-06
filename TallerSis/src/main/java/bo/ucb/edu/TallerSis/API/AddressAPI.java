package bo.ucb.edu.TallerSis.API;


import bo.ucb.edu.TallerSis.BL.AddressBL;
import bo.ucb.edu.TallerSis.DAO.AddressDAO;
import bo.ucb.edu.TallerSis.DTO.Address;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Address> findPetsbyUserid(@PathVariable("userid") Integer userid) {
        return addressBL.findAddress(userid);
    }
}

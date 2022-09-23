package bo.ucb.edu.TallerSis.API;

import bo.ucb.edu.TallerSis.BL.User_addressBL;
import bo.ucb.edu.TallerSis.DTO.Order;
import bo.ucb.edu.TallerSis.DTO.User_address;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
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
    }//tested

    @PutMapping(path="/address/nick", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public User_address updatenick(@RequestBody User_address user_address) {
        user_addressBL.updatenick(user_address.getId_user_address(),user_address.getNickname());
        return user_address;
    }//tested

    @PutMapping(path="/address/status", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public User_address updatestatus(@RequestBody User_address user_address) {
        user_addressBL.updatestatus(user_address.getId_user_address(),user_address.getStatus());
        return user_address;
    }//tested
}

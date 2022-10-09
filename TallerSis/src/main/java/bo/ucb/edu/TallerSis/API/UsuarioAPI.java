package bo.ucb.edu.TallerSis.API;

import bo.ucb.edu.TallerSis.BL.UserBL;
import bo.ucb.edu.TallerSis.BL.User_addressBL;
import bo.ucb.edu.TallerSis.DTO.Pass;
import bo.ucb.edu.TallerSis.DTO.User;
import bo.ucb.edu.TallerSis.DTO.User2;
import bo.ucb.edu.TallerSis.DTO.User_address;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class UsuarioAPI {
    private UserBL UserBL;

    public UsuarioAPI(UserBL userBL) {
        this.UserBL = userBL;
    }

    @PostMapping(path="/user/new", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public User create_user(@RequestBody User user) {
        System.out.println("llega a API");
        UserBL.newUsuario(user.getName(), user.getLast_name(), user.getPhone(),user.getMail());
        return user;
    }// NO SE ES DE SERGIO

    @PostMapping(path="/login", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public User2 authtry(@RequestBody Pass pass) {
        System.out.println("llega a API");
        User2 user2=UserBL.autht(pass.getEmail(), pass.getPassword());
        return user2;
    }//intento de auth
}

package bo.ucb.edu.TallerSis.API;

import bo.ucb.edu.TallerSis.BL.TarjetaBL;
import bo.ucb.edu.TallerSis.DTO.Order;
import bo.ucb.edu.TallerSis.DTO.Tarjeta;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user")
public class TarjetaAPI {
    private TarjetaBL tarjetaBL;

    public TarjetaAPI(TarjetaBL tarjetaBL) {
        this.tarjetaBL = tarjetaBL;
    }

    @GetMapping(path="/cards", produces = APPLICATION_JSON_VALUE)
    public List<Tarjeta> findbybussinesday(@RequestHeader("access_token") String token) {
        return tarjetaBL.findtar(Integer.parseInt(token));
    }//tested: OBTIENE TODAS LAS ORDERS DE UN NEGOCIO EN EL DIA
}

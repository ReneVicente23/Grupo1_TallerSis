package bo.ucb.edu.TallerSis.API;

import bo.ucb.edu.TallerSis.BL.TarjetaBL;
import bo.ucb.edu.TallerSis.DTO.Order;
import bo.ucb.edu.TallerSis.DTO.Tarjeta;
import bo.ucb.edu.TallerSis.DTO.User_address;
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

    @PostMapping(path="/cards/new", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public Tarjeta insertarjeta(@RequestBody Tarjeta tarjeta,@RequestHeader("access_token") String token) {
        tarjetaBL.guaradartar(tarjeta.getN_tarjeta(),tarjeta.getCaducidad(),tarjeta.getCvv(),tarjeta.getTitular(),Integer.parseInt(token));
        return tarjeta;
    }//tested: GENERA UNA NUEVA Tarjeta REQUIER Todos los datos de Tarjeta, si no falla
}

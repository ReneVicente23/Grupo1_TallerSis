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

    @PutMapping(path="/cards", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public Tarjeta borratarjeta(@RequestBody Tarjeta tarjeta,@RequestHeader("access_token") String token) {
        tarjetaBL.borratar(Integer.parseInt(token),tarjeta.getT_id());
        return tarjeta;
    }//tested: ELIMINA UNA TARJETA me olvide el status asi que cvv se hace 0

    @PostMapping(path="/cards", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public Tarjeta editarjeta(@RequestBody Tarjeta tarjeta,@RequestHeader("access_token") String token) {
        tarjetaBL.editar(Integer.parseInt(token),tarjeta.getT_id(), tarjeta.getN_tarjeta(), tarjeta.getCaducidad(), tarjeta.getCvv(), tarjeta.getTitular());
        return tarjeta;
    }//tested: EDITA UNA  Tarjeta REQUIER Todos los datos de Tarjeta, si no falla
}

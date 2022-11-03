package bo.ucb.edu.TallerSis.API;

import bo.ucb.edu.TallerSis.BL.SaldoappBL;
import bo.ucb.edu.TallerSis.DTO.Orders;
import bo.ucb.edu.TallerSis.DTO.Saldoapp;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user")
public class SaldoappAPI {
    private SaldoappBL saldoappBL;

    public SaldoappAPI(SaldoappBL saldoappBL) {
        this.saldoappBL = saldoappBL;
    }

    @GetMapping(path="/saldoapp", produces = APPLICATION_JSON_VALUE)
    public Saldoapp findsaldoapp(@RequestHeader("access_token") String token) {
        return saldoappBL.obtienesaldo(Integer.parseInt(token));
    }//RETORNA EL SALDO DEL USUARIO

    @PostMapping(path="/saldoapp", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public Saldoapp modsaldo(@RequestHeader("access_token") String token, @RequestBody Saldoapp saldoapp) {
        saldoappBL.updatesaldo(Integer.parseInt(token),saldoapp.getSaldo());
        return saldoapp;
    }// MODIFICA EL SALDO

    @PutMapping(path="/saldoapp/rest/{resta}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public Saldoapp minusaldo(@RequestHeader("access_token") String token, @RequestBody Saldoapp saldoapp, @PathVariable("resta") Double rest) {
        saldoappBL.minussaldo(Integer.parseInt(token),saldoapp.getSaldo(),rest);
        return saldoapp;
    }// MODIFICA EL SALDO Resta monto

    @PutMapping(path="/saldoapp/sum/{resta}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public Saldoapp sumsaldo(@RequestHeader("access_token") String token, @RequestBody Saldoapp saldoapp, @PathVariable("resta") Double rest) {
        saldoappBL.plussaldo(Integer.parseInt(token),saldoapp.getSaldo(),rest);
        return saldoapp;
    }// MODIFICA EL SALDO Resta monto
}

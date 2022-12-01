package bo.ucb.edu.TallerSis.API;

import bo.ucb.edu.TallerSis.BL.PagofavBL;
import bo.ucb.edu.TallerSis.DTO.Pagofav;
import bo.ucb.edu.TallerSis.DTO.Pagofav2;
import bo.ucb.edu.TallerSis.DTO.Saldoapp;
import bo.ucb.edu.TallerSis.DTO.Type_payment;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user")
public class PagofavAPI {
    private PagofavBL pagofavBL;

    public PagofavAPI(PagofavBL pagofavBL) {
        this.pagofavBL = pagofavBL;
    }

    @GetMapping(path="/pagofav", produces = APPLICATION_JSON_VALUE)
    public Pagofav findfav(@RequestHeader("access_token") String token) {
        return pagofavBL.obtienefav(Integer.parseInt(token));
    }//RETORNA EL PAGO FAV

    @PostMapping(path="/pagofav/{type}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public void modfav(@RequestHeader("access_token") String token,@PathVariable("type") Integer id) {
        pagofavBL.updatefav(Integer.parseInt(token),id);

    }// MODIFICA PAGO FAV


    @GetMapping(path="/pagofav/type/{type}", produces = APPLICATION_JSON_VALUE)
    public Type_payment findtype(@PathVariable("type") Integer id) {
        return pagofavBL.obtienetipo(id);
    }//RETORNA typo de pago

}

package bo.ucb.edu.TallerSis.API;

import bo.ucb.edu.TallerSis.BL.DashboardBL;
import bo.ucb.edu.TallerSis.DTO.Coordinate;
import bo.ucb.edu.TallerSis.DTO.DataSet;
import bo.ucb.edu.TallerSis.DTO.DataSetD;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/dash")
public class DashboardAPI {
    private DashboardBL dashboardBL;

    public DashboardAPI(DashboardBL dashboardBL) {
        this.dashboardBL = dashboardBL;
    }

    //admin
    @GetMapping(path="/metod/pay", produces = APPLICATION_JSON_VALUE)
    public List<DataSet> findpaymentmetod() {
        return dashboardBL.paymentMetods();
    }//tested: OBTIENE metodos de pago mas usados

    @GetMapping(path="/sales/month", produces = APPLICATION_JSON_VALUE)
    public List<DataSet> findsalemonth() {
        return dashboardBL.salesmonth();
    }//tested: obtiene los metodso de pago mas usados

    @GetMapping(path="/sales/day", produces = APPLICATION_JSON_VALUE)
    public List<DataSet> findsaleday() {
        return dashboardBL.salesday();
    }//tested: obtiene los metodso de pago mas usados

    @GetMapping(path="/sales/buss", produces = APPLICATION_JSON_VALUE)
    public List<DataSet> bussSales() {
        return dashboardBL.bussSales();
    }//tested: bussines

    //bussines
    @GetMapping(path="/buss/dish", produces = APPLICATION_JSON_VALUE)
    public List<DataSet> dishsales(@RequestHeader("access_token") String token) {
        //return dashboardBL.dishsales(Integer.parseInt(token));
        return dashboardBL.dishsales(135);
    }//tested: OBTIENE metodos de pago mas usados

    @GetMapping(path="/buss/month", produces = APPLICATION_JSON_VALUE)
    public List<DataSet> monthbusssales(@RequestHeader("access_token") String token) {
        //return dashboardBL.bussSalesmonth(Integer.parseInt(token));
        return dashboardBL.bussSalesmonth(135);
    }//tested: OBTIENE metodos de pago mas usados

    @GetMapping(path="/buss/day", produces = APPLICATION_JSON_VALUE)
    public List<DataSet> daybusssales(@RequestHeader("access_token") String token) {
        //return dashboardBL.bussSalesday(Integer.parseInt(token));
        return dashboardBL.bussSalesday(135);
    }//tested: OBTIENE metodos de pago mas usados

    @GetMapping(path="/buss/proft", produces = APPLICATION_JSON_VALUE)
    public List<DataSetD> daybusssalescost(@RequestHeader("access_token") String token) {
        //return dashboardBL.profitmonth(Integer.parseInt(token));
        return dashboardBL.profitmonth(135);
    }//tested: OBTIENE metodos de pago mas usados

    //delivery
    @GetMapping(path="/deli/month", produces = APPLICATION_JSON_VALUE)
    public List<DataSet> monthdeli(@RequestHeader("access_token") String token) {
        //return dashboardBL.bussSalesmonth(Integer.parseInt(token));
        return dashboardBL.delimonth(6);
    }//tested: OBTIENE metodos de pago mas usados

    @GetMapping(path="/deli/type", produces = APPLICATION_JSON_VALUE)
    public List<DataSet> typehdeli(@RequestHeader("access_token") String token) {
        //return dashboardBL.bussSalesmonth(Integer.parseInt(token));
        return dashboardBL.delitype(6);
    }//tested: OBTIENE metodos de pago mas usados

    @GetMapping(path="/deli/day", produces = APPLICATION_JSON_VALUE)
    public List<DataSet> daydeli(@RequestHeader("access_token") String token) {
        //return dashboardBL.deliday(Integer.parseInt(token));
        return dashboardBL.deliday(6);
    }//tested: OBTIENE metodos de pago mas usados
}

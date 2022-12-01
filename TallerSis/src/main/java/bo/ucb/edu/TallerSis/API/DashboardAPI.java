package bo.ucb.edu.TallerSis.API;

import bo.ucb.edu.TallerSis.BL.DashboardBL;
import bo.ucb.edu.TallerSis.DTO.Coordinate;
import bo.ucb.edu.TallerSis.DTO.DataSet;
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

    @GetMapping(path="/metod/pay", produces = APPLICATION_JSON_VALUE)
    public List<DataSet> findpaymentmetod() {
        return dashboardBL.paymentMetods();
    }//tested: OBTIENE metodos de pago mas usados

    @GetMapping(path="/sales/month", produces = APPLICATION_JSON_VALUE)
    public List<DataSet> findsalemonth() {
        return dashboardBL.salesmonth();
    }//tested: obtiene los metodso de pago mas usados

    @GetMapping(path="/sales/buss", produces = APPLICATION_JSON_VALUE)
    public List<DataSet> bussSales() {
        return dashboardBL.bussSales();
    }//tested: bussines


}

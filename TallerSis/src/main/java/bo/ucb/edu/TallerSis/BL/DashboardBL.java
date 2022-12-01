package bo.ucb.edu.TallerSis.BL;

import bo.ucb.edu.TallerSis.DAO.DashboardDAO;
import bo.ucb.edu.TallerSis.DTO.Bussines;
import bo.ucb.edu.TallerSis.DTO.Count;
import bo.ucb.edu.TallerSis.DTO.DataSet;
import bo.ucb.edu.TallerSis.DTO.Type_payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardBL {
    private DashboardDAO dashboardDAO;

    @Autowired
    public DashboardBL(DashboardDAO dashboardDAO) {
        this.dashboardDAO = dashboardDAO;
    }

    public List<DataSet> paymentMetods(){
        List<Type_payment> tp= dashboardDAO.paymentmetods();
        List<DataSet> dt = new ArrayList<DataSet>();
       for (Type_payment ts: tp){
           DataSet ds=new DataSet(ts.getType(),dashboardDAO.countmetods(ts.getId_typepay()).getCount());
           dt.add(ds);
       }
       return dt;
    }

    public List<DataSet> salesmonth(){
        List<DataSet> dt = new ArrayList<DataSet>();

        for(int i=0;i<6;i++){

            DataSet ds=new DataSet(LocalDate.now().minusMonths(i).getMonth()+"",dashboardDAO.countventasmes(LocalDate.now().minusMonths(i),LocalDate.now().minusMonths(i+1)).getCount());
            dt.add(ds);
        }
        return dt;
    }

    public List<DataSet> bussSales(){
        List<Bussines> tp= dashboardDAO.getbussines();
        List<DataSet> dt = new ArrayList<DataSet>();
        for (Bussines ts: tp){
            DataSet ds=new DataSet(ts.getId_business()+"",dashboardDAO.countbuss(ts.getId_business()).getCount());
            dt.add(ds);
        }
        return dt;
    }

    public List<DataSet> salesday(){
        List<DataSet> dt = new ArrayList<DataSet>();

        for(int i=0;i<7;i++){

            DataSet ds=new DataSet(LocalDate.now().minusDays(i).getDayOfWeek()+"",dashboardDAO.countventasmes(LocalDate.now().minusDays(i-1),LocalDate.now().minusDays(i+1)).getCount());
            dt.add(ds);
        }
        return dt;
    }
}

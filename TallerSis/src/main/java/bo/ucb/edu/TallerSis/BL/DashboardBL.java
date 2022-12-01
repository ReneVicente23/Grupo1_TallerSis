package bo.ucb.edu.TallerSis.BL;

import bo.ucb.edu.TallerSis.DAO.DashboardDAO;
import bo.ucb.edu.TallerSis.DTO.*;
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

    //admin
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

    // bussines
    public List<DataSet> dishsales(Integer id){
        List<Dish> tp= dashboardDAO.products(id);
        List<DataSet> dt = new ArrayList<DataSet>();
        for (Dish ts: tp){
            DataSet ds=new DataSet(ts.getName(),dashboardDAO.productscount(ts.getId_dish()).getCount());
            dt.add(ds);
        }
        return dt;
    }

    public List<DataSet> bussSalesmonth(Integer id){
        //List<Bussines> tp= dashboardDAO.getbussines();
        List<DataSet> dt = new ArrayList<DataSet>();
        for (int i=0;i<=7;i++){
            DataSet ds=new DataSet(LocalDate.now().plusDays(1).minusMonths(i).getMonth()+"",dashboardDAO.countventasmesbss(id,LocalDate.now().minusMonths(i),LocalDate.now().minusMonths(i+1)).getCount());
            dt.add(ds);
        }
        return dt;
    }

    public List<DataSet> bussSalesday(Integer id){
        //List<Bussines> tp= dashboardDAO.getbussines();
        List<DataSet> dt = new ArrayList<DataSet>();
        for (int i=0;i<=7;i++){
            DataSet ds=new DataSet(LocalDate.now().minusDays(i).getDayOfWeek()+"",dashboardDAO.countventasmesbss(id,LocalDate.now().minusDays(i-1),LocalDate.now().minusDays(i+1)).getCount());
            dt.add(ds);
        }
        return dt;
    }

    public List<DataSetD> profitmonth(Integer id){
        //List<Bussines> tp= dashboardDAO.getbussines();
        List<DataSetD> dt = new ArrayList<DataSetD>();
        for (int i=0;i<=7;i++){
            DataSetD ds;
            try{
                ds=new DataSetD(LocalDate.now().minusDays(i).getDayOfWeek()+"",dashboardDAO.sumpricesales(id,LocalDate.now().minusDays(i-1),LocalDate.now().minusDays(i+1)).getCost());
            }catch (NullPointerException e){
                ds=new DataSetD(LocalDate.now().minusDays(i).getDayOfWeek()+"",0.0);
            }
            //DataSetD ds=new DataSetD(LocalDate.now().minusMonths(i).getMonth()+"",dashboardDAO.sumpricesales(id,LocalDate.now().minusMonths(i),LocalDate.now().minusMonths(i+1)).getCost());
            dt.add(ds);
        }
        return dt;
    }
    //delivery

    public List<DataSet> delimonth(Integer id){
        //List<Bussines> tp= dashboardDAO.getbussines();
        List<DataSet> dt = new ArrayList<DataSet>();
        for (int i=0;i<=7;i++){
            DataSet ds=new DataSet(LocalDate.now().plusDays(1).minusMonths(i).getMonth()+"",dashboardDAO.countdeli(id,LocalDate.now().minusMonths(i),LocalDate.now().minusMonths(i+1)).getCount());
            dt.add(ds);
        }
        return dt;
    }

    public List<DataSet> delitype(Integer id){
        //List<Bussines> tp= dashboardDAO.getbussines();
        List<DataSet> dt = new ArrayList<DataSet>();
        String[] t={"Cancelado", "Pendiente", "Compeltado"};
        for (int i=1;i<4;i++){
            DataSet ds=new DataSet(t[i-1],dashboardDAO.orderstatus(id,i).getCount());
            dt.add(ds);
        }
        return dt;
    }

    public List<DataSet> deliday(Integer id){
        //List<Bussines> tp= dashboardDAO.getbussines();
        List<DataSet> dt = new ArrayList<DataSet>();
        for (int i=0;i<=7;i++){
            DataSet ds=new DataSet(LocalDate.now().minusDays(i).getDayOfWeek()+"",dashboardDAO.countdeli(id,LocalDate.now().minusDays(i-1),LocalDate.now().minusDays(i+1)).getCount());
            dt.add(ds);
        }
        return dt;
    }
}

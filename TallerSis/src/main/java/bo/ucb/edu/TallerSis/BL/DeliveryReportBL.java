package bo.ucb.edu.TallerSis.BL;

import bo.ucb.edu.TallerSis.DAO.OrderDAO;
import bo.ucb.edu.TallerSis.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryReportBL {
    private OrderDAO orderDAO;

    @Autowired
    public DeliveryReportBL(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public List<DeliveryRep> delireport(Integer id, String row, String ord, Integer limit, Integer pag){
        Integer page=limit*pag;
        List<Order> result = orderDAO.getdeliveryrep(id, Integer.parseInt(row),ord,limit,page);
        List<DeliveryRep> rep = new ArrayList<DeliveryRep>();
        for(Order or: result){
            Delivery dev=orderDAO.getdeliverybyid(or.getDelivery_id_delivery());

            DeliveryRep dt = new DeliveryRep(dev.getId_delivery(),dev.getBusiness_id_business()+"", dev.getUser_address_id_user_address()+"", or.getTotal_payment(),or.getOrder_status_id_order_status()+"",(((or.getTotal_payment()*100)*0.1)/100),or.getOrderdate());
            rep.add(dt);
        }
        return rep;
    }

    public List<DeliveryAdminRep> deadminrep(){
        List<User> result = orderDAO.listdelivery();
        List<DeliveryAdminRep> lt=new ArrayList<DeliveryAdminRep>();
        for(User us: result){
            int id=us.getId_user();
            Count ct1=orderDAO.countpedidos(id);
            Count ct2=orderDAO.countpedidoscompletados(id);
            Count ct3=orderDAO.countpedidoscancelados(id);
            Cost ct4=orderDAO.sumpagos(id);
            DeliveryAdminRep dl=new DeliveryAdminRep(id, us.getName(), ct1.getCount()+"",ct2.getCount()+"",ct3.getCount()+"",  Math.round(ct4.getCost()*0.2)+0.0);
            lt.add(dl);
        }
        return lt;
    }

    public List<AdminBussinesRep> deadminbuss(Integer limit, Integer pag){
        List<Bussines> result = orderDAO.listbussiness(limit,pag);
        List<AdminBussinesRep> lt=new ArrayList<AdminBussinesRep>();
        for(Bussines us: result){
            int id=us.getId_business();
            Count ct1=orderDAO.countpedidosb(id);
            Count ct2=orderDAO.countpedidoscompletadosb(id);
            Count ct3=orderDAO.countpedidoscanceladosb(id);
            Cost  ct4=orderDAO.sumpagosb(id);
            AdminBussinesRep dl;
            try {
                dl =new AdminBussinesRep(id, us.getName_business(), ct1.getCount()+"",ct2.getCount()+"",ct3.getCount()+"", ct4.getCost(), Math.rint(ct4.getCost()*0.1));
            }catch (NullPointerException e){
                dl =new AdminBussinesRep(id, us.getName_business(), ct1.getCount()+"",ct2.getCount()+"",ct3.getCount()+"", 0.0, 0.0);
            }
            //AdminBussinesRep dl=new AdminBussinesRep(id, us.getName_business(), ct1.getCount()+"",ct2.getCount()+"",ct3.getCount()+"", ct4.getCost(), Math.rint(ct4.getCost()*0.1));
            lt.add(dl);
        }
        return lt;
    }
}

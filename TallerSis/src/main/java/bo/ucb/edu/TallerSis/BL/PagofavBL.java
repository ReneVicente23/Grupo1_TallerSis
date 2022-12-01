package bo.ucb.edu.TallerSis.BL;

import bo.ucb.edu.TallerSis.DAO.PagofavDAO;
import bo.ucb.edu.TallerSis.DTO.Pagofav;
import bo.ucb.edu.TallerSis.DTO.Pagofav2;
import bo.ucb.edu.TallerSis.DTO.Saldoapp;
import bo.ucb.edu.TallerSis.DTO.Type_payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagofavBL {
    private PagofavDAO pagofavDAO;

    @Autowired
    public PagofavBL(PagofavDAO pagofavDAO) {
        this.pagofavDAO = pagofavDAO;
    }

    public void savenpagofav(Integer userid){
        pagofavDAO.savePagofav(0,userid);
    }

    public Pagofav obtienefav(Integer userid){
        Pagofav pag=pagofavDAO.getPagofav(userid);
        //Type_payment yp=pagofavDAO.getPagotype(pag.getType_payment_id_typepay());
        //String type_payment_id_typepay=yp.getType();
        //Pagofav2 pag2=new Pagofav2(pag.getIdpagofav(), type_payment_id_typepay, pag.getUserapp_id_userapp());
        return  pag;
    }

    public Type_payment obtienetipo(Integer id){
        Type_payment yp=pagofavDAO.getPagotype(id);
        return yp;
    }

    public void updatefav(Integer userid,Integer type){
        pagofavDAO.updatePagofav(userid, type);
    }

}

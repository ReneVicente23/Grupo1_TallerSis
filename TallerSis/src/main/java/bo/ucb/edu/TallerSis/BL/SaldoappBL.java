package bo.ucb.edu.TallerSis.BL;

import bo.ucb.edu.TallerSis.DAO.SaldoappDAO;
import bo.ucb.edu.TallerSis.DTO.Saldoapp;
import bo.ucb.edu.TallerSis.DTO.User_address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaldoappBL {
    private SaldoappDAO saldoappDAO;

    @Autowired
    public SaldoappBL(SaldoappDAO saldoappDAO) {
        this.saldoappDAO = saldoappDAO;
    }

    public void savenewsaldoapp(Integer userid){
        saldoappDAO.saveSaldoapp(0.0,userid);
    }

    public Saldoapp obtienesaldo(Integer userid){
        return  saldoappDAO.getsaldoapp(userid);
    }

    public void updatesaldo(Integer userid,Double saldo){
        saldoappDAO.updatesaldo(userid,saldo);
    }

    public void plussaldo(Integer userid,Double saldo, Double aumento){
        saldoappDAO.updatesaldo(userid,saldo + aumento);
    }

    public void minussaldo(Integer userid,Double saldo, Double decremento){
        saldoappDAO.updatesaldo(userid,saldo - decremento);
    }

}

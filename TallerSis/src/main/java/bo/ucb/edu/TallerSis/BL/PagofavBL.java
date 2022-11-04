package bo.ucb.edu.TallerSis.BL;

import bo.ucb.edu.TallerSis.DAO.PagofavDAO;
import bo.ucb.edu.TallerSis.DTO.Pagofav;
import bo.ucb.edu.TallerSis.DTO.Saldoapp;
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
        return  pagofavDAO.getPagofav(userid);
    }

    public void updatefav(Integer userid,Integer type){
        pagofavDAO.updatePagofav(userid, type);
    }

}

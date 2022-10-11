package bo.ucb.edu.TallerSis.BL;

import bo.ucb.edu.TallerSis.DAO.User_addressDAO;
import bo.ucb.edu.TallerSis.DTO.Order;
import bo.ucb.edu.TallerSis.DTO.User_address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class User_addressBL {
    private User_addressDAO user_addressDAO;

    @Autowired
    public User_addressBL(User_addressDAO user_addressDAO) {
        this.user_addressDAO = user_addressDAO;
    }

    public void saveuseraddress(User_address user_address){
        Integer addressid=user_address.getAddress_id_address();
        Integer coordinateid=user_address.getCoordinate_id_coordinate();
        Integer userid=user_address.getUser_id_user();
        String nick=user_address.getNickname();
        Integer status=user_address.getStatus();
        user_addressDAO.saveuseraddress(addressid,coordinateid,userid,nick,status);
    }

    public void updatenick(Integer id, String nick){
        user_addressDAO.updatenick(id,nick);
    }

    public void updatestatus(Integer id, Integer status){
        user_addressDAO.borraraddress(id,status);
    }

    public void updatefav(Integer id){
        user_addressDAO.nofav(id);
        user_addressDAO.borraraddress(id,2);
    }

    public Integer findidfav(Integer id) {
        Integer result = user_addressDAO.getidfav(id);
        return result;
    }

    public Integer findiddres(Integer id) {
        Integer result = user_addressDAO.getidaddres(id);
        return result;
    }
}

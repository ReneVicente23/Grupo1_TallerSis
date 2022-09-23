package bo.ucb.edu.TallerSis.BL;

import bo.ucb.edu.TallerSis.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBL {
    private UserDAO userDAO;
    @Autowired
    public UserBL(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    public void newUsuario(String name,String lastname, String phone, String mail){

        userDAO.nuevousuario(name, lastname, phone, mail,1);
    }


}

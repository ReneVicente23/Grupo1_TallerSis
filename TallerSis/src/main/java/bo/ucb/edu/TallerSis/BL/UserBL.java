package bo.ucb.edu.TallerSis.BL;

import bo.ucb.edu.TallerSis.DAO.UserDAO;
import bo.ucb.edu.TallerSis.DTO.User;
import bo.ucb.edu.TallerSis.DTO.User2;
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

    public User2 autht(String name, String pass){
        User us= userDAO.auth(name,pass);
        User2 user2=new User2(us.getId_user(), us.getMail(), us.getName(),"test","token");
        return user2;
    }


}

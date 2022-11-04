package bo.ucb.edu.TallerSis.DAO;

import bo.ucb.edu.TallerSis.DTO.Tarjeta;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TarjetaDAO {

    @Insert("INSERT INTO tarjeta (n_tarjeta, caducidad, cvv,titular,userapp_id_userapp) " +
            " VALUES ( #{ntar}, #{cad}, #{cvv}, #{titu}, #{id}) ")
    void savetarjeta(@Param("ntar") String numerotar, @Param("cad") String caducidad, @Param("cvv") Integer cvv, @Param("titu") String titular, @Param("id")Integer id);

    @Select("SELECT t_id,n_tarjeta, caducidad, cvv,titular,userapp_id_userapp " +
            "FROM tarjeta WHERE userapp_id_userapp= #{id}")
    public List<Tarjeta> getTarjeta(@Param("id") Integer id);

}

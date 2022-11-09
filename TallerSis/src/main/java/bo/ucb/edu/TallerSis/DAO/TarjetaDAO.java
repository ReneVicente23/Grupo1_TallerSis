package bo.ucb.edu.TallerSis.DAO;

import bo.ucb.edu.TallerSis.DTO.Tarjeta;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TarjetaDAO {

    @Insert("INSERT INTO tarjeta (n_tarjeta, caducidad, cvv,titular,userapp_id_userapp) " +
            " VALUES ( #{ntar}, #{cad}, #{cvv}, #{titu}, #{id}) ")
    void savetarjeta(@Param("ntar") String numerotar, @Param("cad") String caducidad, @Param("cvv") Integer cvv, @Param("titu") String titular, @Param("id")Integer id);

    @Select("SELECT t_id,n_tarjeta, caducidad, cvv,titular,userapp_id_userapp " +
            "FROM tarjeta WHERE userapp_id_userapp= #{id} AND cvv <> 0")
    public List<Tarjeta> getTarjeta(@Param("id") Integer id);

    @Update("UPDATE tarjeta SET cvv= 0 " +
            " WHERE userapp_id_userapp = #{id} AND t_id = #{tid}")
    void borratar(@Param("id") Integer id,@Param("tid") Integer tid);

    @Update("UPDATE tarjeta SET n_tarjeta = #{ntar} , caducidad= #{cad},cvv =#{cvv},  titular = #{tit} " +
            " WHERE userapp_id_userapp = #{id} AND t_id = #{tid}")
    void editar(@Param("id") Integer id,@Param("tid") Integer tid,@Param("ntar") String ntar,@Param("cad") String cad,@Param("cvv") Integer cvv,@Param("tit") String tit);

}

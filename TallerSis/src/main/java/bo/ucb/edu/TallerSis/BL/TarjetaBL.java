package bo.ucb.edu.TallerSis.BL;

import bo.ucb.edu.TallerSis.DAO.TarjetaDAO;
import bo.ucb.edu.TallerSis.DTO.Tarjeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarjetaBL {
    private TarjetaDAO tarjetaDAO;

    @Autowired
    public TarjetaBL(TarjetaDAO tarjetaDAO) {
        this.tarjetaDAO = tarjetaDAO;
    }

    public List<Tarjeta> findtar(Integer id) {
        List<Tarjeta> result = tarjetaDAO.getTarjeta(id);
        return result;
    }

    public void guaradartar(String ntar,String cad, Integer cvv, String tit, Integer id) {
        tarjetaDAO.savetarjeta(ntar,cad,cvv,tit,id);
    }
}

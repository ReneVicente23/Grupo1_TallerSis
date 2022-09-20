package bo.ucb.edu.TallerSis.BL;

import bo.ucb.edu.TallerSis.DAO.AddressDAO;
import bo.ucb.edu.TallerSis.DTO.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBL {
    private AddressDAO addressDAO;

    @Autowired
    public AddressBL(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    public List<Address> findAddress(Integer Id) {
        Integer id= Math.toIntExact(Id);
        List<Address> result =addressDAO.findAddress(id);
        return result;
    }

    public Address findAddressid(Integer Id) {
        Integer id= Math.toIntExact(Id);
        Address result =addressDAO.findAddressid(id);
        return result;
    }

    public void saveAddress(Address address){
        String street=address.getStreet();
        String zone=address.getZone();
        String h_number=address.getH_number();
        String city=address.getCity();
        addressDAO.saveAddress(street,zone,h_number,city);
    }

    public void updateAddress(Address address){
        Integer id=address.getId_address();
        String street=address.getStreet();
        String zone=address.getZone();
        String h_number=address.getH_number();
        String city=address.getCity();
        addressDAO.updateAddress(id, street,zone,h_number,city);
    }
}

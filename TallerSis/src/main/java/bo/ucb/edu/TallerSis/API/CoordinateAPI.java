package bo.ucb.edu.TallerSis.API;

import bo.ucb.edu.TallerSis.BL.AddressBL;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class CoordinateAPI
{
    @RestController
    @RequestMapping("/api/coordinate")
    public class AddressAPI {
        private AddressBL addressBL;
    }
}

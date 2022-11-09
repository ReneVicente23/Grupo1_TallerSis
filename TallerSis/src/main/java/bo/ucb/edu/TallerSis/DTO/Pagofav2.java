package bo.ucb.edu.TallerSis.DTO;

public class Pagofav2 {
    private Integer idpagofav;
    private String type_payment_id_typepay;
    private Integer userapp_id_userapp;

    public Pagofav2(Integer idpagofav, String type_payment_id_typepay, Integer userapp_id_userapp) {
        this.idpagofav = idpagofav;
        this.type_payment_id_typepay = type_payment_id_typepay;
        this.userapp_id_userapp = userapp_id_userapp;
    }

    public Integer getIdpagofav() {
        return idpagofav;
    }

    public void setIdpagofav(Integer idpagofav) {
        this.idpagofav = idpagofav;
    }

    public String getType_payment_id_typepay() {
        return type_payment_id_typepay;
    }

    public void setType_payment_id_typepay(String type_payment_id_typepay) {
        this.type_payment_id_typepay = type_payment_id_typepay;
    }

    public Integer getUserapp_id_userapp() {
        return userapp_id_userapp;
    }

    public void setUserapp_id_userapp(Integer userapp_id_userapp) {
        this.userapp_id_userapp = userapp_id_userapp;
    }
}

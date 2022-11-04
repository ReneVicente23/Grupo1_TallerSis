package bo.ucb.edu.TallerSis.DTO;

public class Pagofav2 {
    private Integer idpagofav;
    private String type;
    private Integer userapp_id_userapp;

    public Pagofav2(Integer idpagofav, String type, Integer userapp_id_userapp) {
        this.idpagofav = idpagofav;
        this.type = type;
        this.userapp_id_userapp = userapp_id_userapp;
    }

    public Integer getIdpagofav() {
        return idpagofav;
    }

    public void setIdpagofav(Integer idpagofav) {
        this.idpagofav = idpagofav;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getUserapp_id_userapp() {
        return userapp_id_userapp;
    }

    public void setUserapp_id_userapp(Integer userapp_id_userapp) {
        this.userapp_id_userapp = userapp_id_userapp;
    }
}

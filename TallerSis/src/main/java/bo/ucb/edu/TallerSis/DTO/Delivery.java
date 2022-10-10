package bo.ucb.edu.TallerSis.DTO;

public class Delivery {
    private Integer id_delivery;
    private Integer user_address_id_user_address;
    private Integer business_id_business;
    private Integer userapp_id_userapp;

    public Delivery(Integer id_delivery, Integer user_address_id_user_address, Integer business_id_business, Integer userapp_id_userapp) {
        this.id_delivery = id_delivery;
        this.user_address_id_user_address = user_address_id_user_address;
        this.business_id_business = business_id_business;
        this.userapp_id_userapp = userapp_id_userapp;
    }

    public Integer getId_delivery() {
        return id_delivery;
    }

    public void setId_delivery(Integer id_delivery) {
        this.id_delivery = id_delivery;
    }

    public Integer getUser_address_id_user_address() {
        return user_address_id_user_address;
    }

    public void setUser_address_id_user_address(Integer user_address_id_user_address) {
        this.user_address_id_user_address = user_address_id_user_address;
    }

    public Integer getBusiness_id_business() {
        return business_id_business;
    }

    public void setBusiness_id_business(Integer business_id_business) {
        this.business_id_business = business_id_business;
    }

    public Integer getUserapp_id_userapp() {
        return userapp_id_userapp;
    }

    public void setUserapp_id_userapp(Integer userapp_id_userapp) {
        this.userapp_id_userapp = userapp_id_userapp;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id_delivery=" + id_delivery +
                ", user_address_id_user_address=" + user_address_id_user_address +
                ", business_id_business=" + business_id_business +
                ", userapp_id_userapp=" + userapp_id_userapp +
                '}';
    }
}

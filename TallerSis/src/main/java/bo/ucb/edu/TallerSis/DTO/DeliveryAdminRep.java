package bo.ucb.edu.TallerSis.DTO;

import java.sql.Date;

public class DeliveryAdminRep {
    private Integer id;
    private String delivery;
    private String orders;
    private String completed;
    private String canceled;
    private Double totalpay;

    public DeliveryAdminRep(Integer id, String delivery, String orders, String completed, String canceled, Double totalpay) {
        this.id = id;
        this.delivery = delivery;
        this.orders = orders;
        this.completed = completed;
        this.canceled = canceled;
        this.totalpay = totalpay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getOrders() {
        return orders;
    }

    public void setOrders(String orders) {
        this.orders = orders;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public String getCanceled() {
        return canceled;
    }

    public void setCanceled(String canceled) {
        this.canceled = canceled;
    }

    public Double getTotalpay() {
        return totalpay;
    }

    public void setTotalpay(Double totalpay) {
        this.totalpay = totalpay;
    }
}

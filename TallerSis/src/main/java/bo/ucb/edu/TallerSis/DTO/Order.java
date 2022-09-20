package bo.ucb.edu.TallerSis.DTO;

public class Order {
    private Integer id_order;
    private Double total_payment;
    private Integer order_status_id_order_status; //status: 0 borrada, 1 en curso, 2 pagada
    private Integer type_payment_id_typepay; //tipe payment 0 efectivo
    private Integer delivery_id_delivery;

    public Order(Integer id_order, Double total_payment, Integer order_status_id_order_status, Integer type_payment_id_typepay, Integer delivery_id_delivery) {
        this.id_order = id_order;
        this.total_payment = total_payment;
        this.order_status_id_order_status = order_status_id_order_status;
        this.type_payment_id_typepay = type_payment_id_typepay;
        this.delivery_id_delivery = delivery_id_delivery;
    }

    public Integer getId_order() {
        return id_order;
    }

    public void setId_order(Integer id_order) {
        this.id_order = id_order;
    }

    public Double getTotal_payment() {
        return total_payment;
    }

    public void setTotal_payment(Double total_payment) {
        this.total_payment = total_payment;
    }

    public Integer getOrder_status_id_order_status() {
        return order_status_id_order_status;
    }

    public void setOrder_status_id_order_status(Integer order_status_id_order_status) {
        this.order_status_id_order_status = order_status_id_order_status;
    }

    public Integer getType_payment_id_typepay() {
        return type_payment_id_typepay;
    }

    public void setType_payment_id_typepay(Integer type_payment_id_typepay) {
        this.type_payment_id_typepay = type_payment_id_typepay;
    }

    public Integer getDelivery_id_delivery() {
        return delivery_id_delivery;
    }

    public void setDelivery_id_delivery(Integer delivery_id_delivery) {
        this.delivery_id_delivery = delivery_id_delivery;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id_order=" + id_order +
                ", total_payment=" + total_payment +
                ", order_status_id_order_status=" + order_status_id_order_status +
                ", type_payment_id_typepay=" + type_payment_id_typepay +
                ", delivery_id_delivery=" + delivery_id_delivery +
                '}';
    }
}

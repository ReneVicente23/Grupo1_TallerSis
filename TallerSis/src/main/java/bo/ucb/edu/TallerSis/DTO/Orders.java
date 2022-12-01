package bo.ucb.edu.TallerSis.DTO;

import java.util.Arrays;

public class Orders {
    private Integer id;
    private CartItem[] items;
    private Double totalPrice;
    private String name;
    private String address;
    private LatLng addressLatLng;
    private String paymentId;
    private String createdAt;
    private String status;

    public Orders(Integer id, CartItem[] items, Double totalPrice, String name, String address, LatLng addressLatLng, String paymentId, String createdAt, String status) {
        this.id = id;
        this.items = items;
        this.totalPrice = totalPrice;
        this.name = name;
        this.address = address;
        this.addressLatLng = addressLatLng;
        this.paymentId = paymentId;
        this.createdAt = createdAt;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CartItem[] getItems() {
        return items;
    }

    public void setItems(CartItem[] items) {
        this.items = items;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LatLng getAddressLatLng() {
        return addressLatLng;
    }

    public void setAddressLatLng(LatLng addressLatLng) {
        this.addressLatLng = addressLatLng;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", items=" + Arrays.toString(items) +
                ", totalPrice=" + totalPrice +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", addressLatLng=" + addressLatLng +
                ", paymentId='" + paymentId + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

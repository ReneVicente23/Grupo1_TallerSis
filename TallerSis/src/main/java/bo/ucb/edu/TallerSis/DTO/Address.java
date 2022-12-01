package bo.ucb.edu.TallerSis.DTO;

public class Address {
    private Integer id_address;
    private String street;
    private String zone;
    private String h_number;
    private String city;
    private String ref;

    public Address(Integer id_address, String street, String zone, String h_number, String city, String ref) {
        this.id_address = id_address;
        this.street = street;
        this.zone = zone;
        this.h_number = h_number;
        this.city = city;
        this.ref = ref;
    }

    public Integer getId_address() {
        return id_address;
    }

    public void setId_address(Integer id_address) {
        this.id_address = id_address;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getH_number() {
        return h_number;
    }

    public void setH_number(String h_number) {
        this.h_number = h_number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id_address=" + id_address +
                ", street='" + street + '\'' +
                ", zone='" + zone + '\'' +
                ", h_number='" + h_number + '\'' +
                ", city='" + city + '\'' +
                ", ref='" + ref + '\'' +
                '}';
    }
}

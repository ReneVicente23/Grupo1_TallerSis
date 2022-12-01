package bo.ucb.edu.TallerSis.DTO;

public class Bussines {
    private Integer id_business;
    private String name_business;
    private Integer address_id_address;

    public Bussines(Integer id_business, String name_business, Integer address_id_address) {
        this.id_business = id_business;
        this.name_business = name_business;
        this.address_id_address = address_id_address;
    }

    public Integer getId_business() {
        return id_business;
    }

    public void setId_business(Integer id_business) {
        this.id_business = id_business;
    }

    public String getName_business() {
        return name_business;
    }

    public void setName_business(String name_business) {
        this.name_business = name_business;
    }

    public Integer getAddress_id_address() {
        return address_id_address;
    }

    public void setAddress_id_address(Integer address_id_address) {
        this.address_id_address = address_id_address;
    }
}

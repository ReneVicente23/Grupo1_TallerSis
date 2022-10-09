package bo.ucb.edu.TallerSis.DTO;

public class User2 {
    private Integer id_user;
    private String email;
    private String name;
    private String address;
    private String token;
    //private Boolean isAdmin;


    public User2(Integer id_user, String email, String name, String address, String token) {
        this.id_user = id_user;
        this.email = email;
        this.name = name;
        this.address = address;
        this.token = token;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "User2{" +
                "id_user2=" + id_user +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}

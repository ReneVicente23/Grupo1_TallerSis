package bo.ucb.edu.TallerSis.DTO;

public class User {
    private Integer id_user;
    private String name;
    private String last_name;
    private String phone;
    private String mail;
    private Integer type_user_typeid;

    public User(Integer id_user, String name, String last_name, String phone, String mail, Integer type_user_typeid) {
        this.id_user = id_user;
        this.name = name;
        this.last_name = last_name;
        this.phone = phone;
        this.mail = mail;
        this.type_user_typeid = type_user_typeid;
    }

    public User() {
        this.id_user = 0;
        this.name = "";
        this.last_name = "";
        this.phone = "";
        this.mail = "";
        this.type_user_typeid = 0;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getType_user_typeid() {
        return type_user_typeid;
    }

    public void setType_user_typeid(Integer type_user_typeid) {
        this.type_user_typeid = type_user_typeid;
    }
}

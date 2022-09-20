package bo.ucb.edu.TallerSis.DTO;

public class User_address {
    private Integer id_user_address;
    private Integer user_id_user;
    private Integer address_id_address;
    private Integer coordinate_id_coordinate;
    private String nickname;
    private Integer status;

    public User_address(Integer id_user_address, Integer user_id_user, Integer address_id_address, Integer coordinate_id_coordinate, String nickname, Integer status) {
        this.id_user_address = id_user_address;
        this.user_id_user = user_id_user;
        this.address_id_address = address_id_address;
        this.coordinate_id_coordinate = coordinate_id_coordinate;
        this.nickname = nickname;
        this.status = status;
    }

    public Integer getId_user_address() {
        return id_user_address;
    }

    public void setId_user_address(Integer id_user_address) {
        this.id_user_address = id_user_address;
    }

    public Integer getUser_id_user() {
        return user_id_user;
    }

    public void setUser_id_user(Integer user_id_user) {
        this.user_id_user = user_id_user;
    }

    public Integer getAddress_id_address() {
        return address_id_address;
    }

    public void setAddress_id_address(Integer address_id_address) {
        this.address_id_address = address_id_address;
    }

    public Integer getCoordinate_id_coordinate() {
        return coordinate_id_coordinate;
    }

    public void setCoordinate_id_coordinate(Integer coordinate_id_coordinate) {
        this.coordinate_id_coordinate = coordinate_id_coordinate;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User_address{" +
                "id_user_address=" + id_user_address +
                ", user_id_user=" + user_id_user +
                ", address_id_address=" + address_id_address +
                ", coordinate_id_coordinate=" + coordinate_id_coordinate +
                ", nickname='" + nickname + '\'' +
                ", status=" + status +
                '}';
    }
}

package cn.chafan.dimit;

/**
 * @Auther: 茶凡
 * @ClassName Address
 * @date 2023/11/13 20:14
 * @Description TODO
 */
public class Address {
    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getAddress() {
        return "Street: " + street + ", City: " + city;
    }
}

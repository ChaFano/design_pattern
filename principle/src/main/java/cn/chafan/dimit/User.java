package cn.chafan.dimit;

/**
 * @Auther: 茶凡
 * @ClassName User
 * @date 2023/11/13 20:14
 * @Description  迪米特法则
 */

// 一个软件实体应当尽可能少地与其他实体发生相互作用。优先使用对象组合，而不是继承来实现代码的复用
public class User {
    private String username;
    private Address address;

    public User(String username) {
        this.username = username;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // 迪米特法则告诉我们只应该通过User对象来访问Address对象
    public String getAddress() {
        return address.getAddress();
    }

}

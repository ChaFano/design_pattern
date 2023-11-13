package cn.chafan.dependency;

/**
 * @Auther: 茶凡
 * @ClassName BetUser
 * @date 2023/11/13 19:59
 * @Description TODO
 */
public class BetUser {
    private String name;
    private int number; // 权重

    public BetUser(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public BetUser() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "BetUser{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}

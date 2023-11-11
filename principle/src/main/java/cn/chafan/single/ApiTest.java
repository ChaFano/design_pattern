package cn.chafan.single;

/**
 * @Auther: 茶凡
 * @ClassName ApiTest
 * @date 2023/11/11 21:42
 * @Description TODO
 */
public class ApiTest {
    public static void main(String[] args) {

        IVideoUserService guest = new GuestVideoUserService();
        IVideoUserService ordinary = new OrdinaryVideoUserService();
        IVideoUserService vip = new VipVideoUserService();
        guest.advertisement();
        guest.definition();
        ordinary.definition();
        ordinary.advertisement();
        vip.definition();
        vip.advertisement();
    }
}

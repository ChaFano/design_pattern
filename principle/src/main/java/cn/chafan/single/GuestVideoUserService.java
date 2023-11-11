package cn.chafan.single;

/**
 * @Auther: 茶凡
 * @ClassName GuestVideoUserService
 * @date 2023/11/11 21:39
 * @Description 访客用户
 */
public class GuestVideoUserService implements IVideoUserService{
    @Override
    public void definition() {
        System.out.println("访客用户，视频480P高清");
    }

    @Override
    public void advertisement() {
        System.out.println("访客用户，视频有广告");
    }
}

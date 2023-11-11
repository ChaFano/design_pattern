package cn.chafan.single;

/**
 * @Auther: 茶凡
 * @ClassName OrdinaryVideoUserService
 * @date 2023/11/11 21:40
 * @Description 普通用户
 */
public class OrdinaryVideoUserService implements IVideoUserService{
    @Override
    public void definition() {
        System.out.println("普通用户，视频 720 P高清");
    }

    @Override
    public void advertisement() {
        System.out.println("普通用户，视频有广告");
    }
}

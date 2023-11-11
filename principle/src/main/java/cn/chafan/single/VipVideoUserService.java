package cn.chafan.single;

/**
 * @Auther: 茶凡
 * @ClassName VipVideoUserService
 * @date 2023/11/11 21:41
 * @Description vip 用户
 */
public class VipVideoUserService implements IVideoUserService{
    @Override
    public void definition() {
        System.out.println("VIP用户，视频1080P蓝光");
    }

    @Override
    public void advertisement() {
        System.out.println("VIP会员，视频无广告");
    }
}

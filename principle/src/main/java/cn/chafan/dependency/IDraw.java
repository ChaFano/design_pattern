package cn.chafan.dependency;

import java.util.List;

/**
 * @Auther: 茶凡
 * @ClassName IDraw
 * @date 2023/11/13 19:57
 * @Description 抽奖接口
 */
public interface IDraw {

    List<BetUser> prize(List<BetUser> list ,int count);


}

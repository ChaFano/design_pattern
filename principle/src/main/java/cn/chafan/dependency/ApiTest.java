package cn.chafan.dependency;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 茶凡
 * @ClassName ApiTest
 * @date 2023/11/13 19:50
 * @Description 依赖倒置原则测试
 */

// 高层模块不应该依赖于底层模块，二者都应该依赖于抽象。抽象不应该依赖于细节，细节应该依赖于抽象 面向接口编程
public class ApiTest {


    private Logger logger = LoggerFactory.getLogger(ApiTest.class);


    @Test
    public void test_DrawControl() {
        List<BetUser> betUserList = new ArrayList<>();
        betUserList.add(new BetUser("花花", 65));
        betUserList.add(new BetUser("豆豆", 43));
        betUserList.add(new BetUser("小白", 72));
        betUserList.add(new BetUser("笨笨", 89));
        betUserList.add(new BetUser("丑蛋", 10));

        DrawControl drawControl = new DrawControl();
        List<BetUser> prizeRandomUserList = drawControl.doDraw(new DrawRandom(), betUserList, 3);
        logger.info("随机抽奖，中奖用户名单：{}", JSON.toJSON(prizeRandomUserList));

        List<BetUser> prizeWeightUserList = drawControl.doDraw(new DrawWeightRank(), betUserList, 3);
        logger.info("权重抽奖，中奖用户名单：{}", JSON.toJSON(prizeWeightUserList));
    }

}

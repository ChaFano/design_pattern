package cn.chafan.isolate;

import org.junit.jupiter.api.Test;

/**
 * @Auther: 茶凡
 * @ClassName ApiTest
 * @date 2023/11/13 0:35
 * @Description TODO
 */
public class ApiTest {


    @Test
    public void test_ISkill(){
        // 后裔
        HeroHouYi heroHouYi = new HeroHouYi();
        heroHouYi.doArchery();
        heroHouYi.doInvisible();
        heroHouYi.doSilent();

        System.out.println();
        // 廉颇
        HeroLianPo heroLianPo = new HeroLianPo();
        heroLianPo.doInvisible();
        heroLianPo.doSilent();
        heroLianPo.doVertigo();
    }
}

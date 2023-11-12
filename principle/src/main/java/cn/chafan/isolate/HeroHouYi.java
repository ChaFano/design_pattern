package cn.chafan.isolate;

/**
 * @Auther: 茶凡
 * @ClassName HeroHouYi
 * @date 2023/11/13 0:42
 * @Description TODO
 */
public class HeroHouYi implements ISkillArchery, ISkillInvisible, ISkillSilent{

    @Override
    public void doArchery() {
        System.out.println("后裔的灼日之矢");
    }

    @Override
    public void doInvisible() {
        System.out.println("后裔的隐身技能");
    }

    @Override
    public void doSilent() {
        System.out.println("后裔的沉默技能");
    }
}

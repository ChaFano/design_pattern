package cn.chafan.isolate;

/**
 * @Auther: 茶凡
 * @ClassName HeroLianPo
 * @date 2023/11/13 0:43
 * @Description TODO
 */
public class HeroLianPo implements ISkillInvisible, ISkillSilent, ISkillVertigo {

    @Override
    public void doInvisible() {
        System.out.println("廉颇的隐身技能");
    }

    @Override
    public void doSilent() {
        System.out.println("廉颇的沉默技能");
    }

    @Override
    public void doVertigo() {
        System.out.println("廉颇的眩晕技能");
    }

}
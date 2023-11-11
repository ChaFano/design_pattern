package cn.chafan.on_off;

/**
 * @Auther: 茶凡
 * @ClassName CalculationAreaExt
 * @date 2023/11/11 21:53
 * @Description 扩展继承，实现自己的需求
 */
public class CalculationAreaExt extends CalculationArea{

    private final static double π = 3.141592653D; // 使用高精度的 Π 不修改源码


    @Override
    public double circular(double r) {
        return π * r * r;
    }


}

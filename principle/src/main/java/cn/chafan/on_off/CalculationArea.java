package cn.chafan.on_off;

/**
 * @Auther: 茶凡
 * @ClassName CalculationArea
 * @date 2023/11/11 21:51
 * @Description 面积计算实现
 */
public class CalculationArea implements ICalculationArea{
    private final static double π = 3.14D;

    @Override
    public double rectangle(double x, double y) {
        return x * y;
    }

    @Override
    public double triangle(double x, double y, double z) {
        double p = (x + y + z) / 2;
        return Math.sqrt(p * (p - x) * (p - y) * (p - z));
    }

    @Override
    public double circular(double r) {
        return π * r * r;
    }

}

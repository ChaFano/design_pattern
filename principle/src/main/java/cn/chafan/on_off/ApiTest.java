package cn.chafan.on_off;

/**
 * @Auther: 茶凡
 * @ClassName ApiTest
 * @date 2023/11/11 21:54
 * @Description 测试
 */

public class ApiTest {


    public static void test_CalculationAreaExt(){
        ICalculationArea area = new CalculationAreaExt();
        double circular = area.circular(10);
        System.out.println(circular);
    }

    public static void test_CalculationArea(){
        ICalculationArea area = new CalculationArea();
        double circular = area.circular(10);
        System.out.println(circular);
    }

    public static void main(String[] args) {

        test_CalculationArea();
        test_CalculationAreaExt();
    }
}

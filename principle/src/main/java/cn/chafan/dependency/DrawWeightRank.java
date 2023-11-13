package cn.chafan.dependency;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 茶凡
 * @ClassName DrawWeightRank
 * @date 2023/11/13 20:01
 * @Description TODO
 */
public class DrawWeightRank implements IDraw{

    @Override
    public List<BetUser> prize(List<BetUser> list, int count) {
        // 按照权重排序
        list.sort((o1, o2) -> {
            int e = o2.getNumber() - o1.getNumber();
            if (0 == e) return 0;
            return e > 0 ? 1 : -1;
        });
        // 取出指定数量的中奖用户
        List<BetUser> prizeList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            prizeList.add(list.get(i));
        }
        return prizeList;
    }

}

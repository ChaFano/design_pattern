package cn.chafan.dependency;

import java.util.List;

/**
 * @Auther: 茶凡
 * @ClassName DrawControl
 * @date 2023/11/13 20:04
 * @Description TODO
 */
public class DrawControl {
    private IDraw draw;

    public List<BetUser> doDraw(IDraw draw, List<BetUser> betUserList, int count) {
        return draw.prize(betUserList, count);
    }
}

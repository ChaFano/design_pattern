package cn.chafan.richter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 茶凡
 * @ClassName CashCard
 * @date 2023/11/12 23:13
 * @Description 模拟储蓄卡功能
 */
public class CashCard extends BankCard{

    private Logger log = LoggerFactory.getLogger(CashCard.class);

    public CashCard(String cardNo, String cardDate) {
        super(cardNo, cardDate);
    }

    /**
     * 模拟提现
     * @param orderId
     * @param amount
     * @return
     */
    public String withdrawal(String orderId, BigDecimal amount){
        // 模拟支付成功
        log.info("提现成功，单号：{} 金额：{}", orderId, amount);
        return "0000";
    }


    /**
     * 储蓄
     *
     * @param orderId 单号
     * @param amount  金额
     */
    public String recharge(String orderId, BigDecimal amount) {
        // 模拟充值成功
        log.info("储蓄成功，单号：{} 金额：{}", orderId, amount);
        return "0000";
    }


    @Override
    boolean rule(BigDecimal amount) {
        return true;
    }

    /**
     * 交易流水查询
     * @return 交易流水
     */
    public List<String> tradeFlow() {
        log.info("交易流水查询成功");
        List<String> tradeList = new ArrayList<String>();
        tradeList.add("100001,100.00");
        tradeList.add("100001,80.00");
        tradeList.add("100001,76.50");
        tradeList.add("100001,126.00");
        return tradeList;
    }


}

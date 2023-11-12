package cn.chafan.richter;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: 茶凡
 * @ClassName ApiTest
 * @date 2023/11/12 23:32
 * @Description TODO
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    
    @Test
    public void test_CashCard() {
        CashCard cashCard = new CashCard();
        // 提现
        cashCard.withdrawal("100001", new BigDecimal(100));
        // 储蓄
        cashCard.recharge("100001", new BigDecimal(100));
        // 交易流水
        List<String> tradeFlow = cashCard.tradeFlow();
        logger.info("查询交易流水，{}", JSON.toJSONString(tradeFlow));
    }

    @Test
    public void test_CreditCard() {
        CreditCard creditCard = new CreditCard();
        // 支付
        creditCard.withdrawal("100001", new BigDecimal(100));
        // 还款
        creditCard.recharge("100001", new BigDecimal(100));
        // 交易流水
        List<String> tradeFlow = creditCard.tradeFlow();
        logger.info("查询交易流水，{}", JSON.toJSONString(tradeFlow));
    }
}

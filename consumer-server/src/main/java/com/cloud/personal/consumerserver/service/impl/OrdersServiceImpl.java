package com.cloud.personal.consumerserver.service.impl;

import com.cloud.personal.consumerserver.cache.impl.OrdersCacheImpl;
import com.cloud.personal.consumerserver.entity.Orders;
import com.cloud.personal.consumerserver.service.IOrdersService;
import com.cloud.personal.providerserverclient.client.ProviderFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * IOrdersService service实现类
 * @author lijun
 */
@Slf4j
@Service("ordersService")
public class OrdersServiceImpl extends OrdersCacheImpl implements IOrdersService {

    @Autowired
    ProviderFeignClient providerFeignClient;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addOrder() {
        //创建一个订单
        Orders orders = Orders.builder()
                .orderSeq(UUID.randomUUID().toString())
                .pId(100001L)
                .orderNum(2)
                .orderPrice(BigDecimal.valueOf(100L))
                .createTime(new Date())
                .remark("seata测试")
                .build();
        //下单操作
        this.add(orders);

        //扣减库存
        providerFeignClient.reduceStock(2);

        //模拟异常操作
        int i = 1 / 0;

        //打印日志
        log.info("完成下订单操作");

    }
}
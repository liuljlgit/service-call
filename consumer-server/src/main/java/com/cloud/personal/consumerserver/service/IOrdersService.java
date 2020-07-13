package com.cloud.personal.consumerserver.service;

import com.cloud.ftl.ftlbasic.service.IBaseCache;
import com.cloud.personal.consumerserver.entity.Orders;

/**
 * IOrdersService service接口类
 * @author lijun
 */
public interface IOrdersService extends IBaseCache<Orders>{

    void addOrder();

}

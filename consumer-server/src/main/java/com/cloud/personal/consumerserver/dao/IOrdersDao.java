package com.cloud.personal.consumerserver.dao;

import org.springframework.stereotype.Repository;
import java.util.List;
import com.cloud.ftl.ftlbasic.mapper.IBaseMapper;
import org.apache.ibatis.annotations.Param;
import com.cloud.personal.consumerserver.entity.Orders;

/**
  * 接口类 IOrdersDao
  * @author lijun
  */
@Repository
public interface IOrdersDao extends IBaseMapper<Orders>{

    //------------------------ custom code begin ------------------------//
    
    //======================== custom code end ========================//

}
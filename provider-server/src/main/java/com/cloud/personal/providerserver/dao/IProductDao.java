package com.cloud.personal.providerserver.dao;

import org.springframework.stereotype.Repository;
import java.util.List;
import com.cloud.ftl.ftlbasic.mapper.IBaseMapper;
import org.apache.ibatis.annotations.Param;
import com.cloud.personal.providerserver.entity.Product;

/**
  * 接口类 IProductDao
  * @author lijun
  */
@Repository
public interface IProductDao extends IBaseMapper<Product>{

    //------------------------ custom code begin ------------------------//
    
    //======================== custom code end ========================//

}
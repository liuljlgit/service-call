package com.cloud.personal.providerserver.service.impl;

import org.springframework.stereotype.Service;
import com.cloud.personal.providerserver.cache.impl.ProductCacheImpl;
import com.cloud.personal.providerserver.service.IProductService;

/**
 * IProductService service实现类
 * @author lijun
 */
@Service("productService")
public class ProductServiceImpl extends ProductCacheImpl implements IProductService {


}
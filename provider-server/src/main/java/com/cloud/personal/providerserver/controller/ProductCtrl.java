package com.cloud.personal.providerserver.controller;

import com.cloud.ftl.ftlbasic.webEntity.CommonResp;
import com.cloud.ftl.ftlbasic.webEntity.PageBean;
import com.cloud.ftl.ftlbasic.webEntity.RespEntity;
import com.cloud.personal.providerserver.entity.Product;
import com.cloud.personal.providerserver.service.IProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j
@RestController
@Validated
@RequestMapping("/product")
@Api(tags = "全局接口信息")
public class ProductCtrl{

    @Autowired
    private IProductService productService;

    @GetMapping(value = "/obj")
    @ApiOperation(value = "根据主键查询" , tags = "xxx",hidden = true, notes = "author: llj")
    @ApiImplicitParam(name="pId", value="主键",required = true)
    public CommonResp<Product> selectById(@RequestParam("pId") @NotNull Long pId) {
        return RespEntity.ok(productService.selectById(pId,"没有符合条件的记录！"));
    }

    @PostMapping(value = "/list")
    @ApiOperation(value = "查询所有列表" , tags = "xxx",hidden = true, notes = "author: llj")
    public CommonResp<List<Product>> selectList(@RequestBody Product product){
        return RespEntity.ok(productService.selectList(product));
    }

    @PostMapping(value = "/page")
    @ApiOperation(value = "分页查询" , tags = "xxx",hidden = true, notes = "author: llj")
    public CommonResp<PageBean<Product>> selectPage(@RequestBody Product product) {
        return RespEntity.ok(productService.selectPage(product));
    }


    @PostMapping(value = "/obj")
    @ApiOperation(value = "更新或者新增", tags = "xxx",hidden = true, notes = "author: llj")
    public CommonResp<Object> save(@RequestBody Product product) {
        productService.save(product);
        return RespEntity.ok();
    }

    @DeleteMapping(value = "/obj")
    @ApiOperation(value = "根据主键删除",tags = "xxx",hidden = true, notes = "author: llj")
    @ApiImplicitParam(name="pId", value="主键",required = true)
    public CommonResp<Object> deleteById(@RequestParam(value="pId") @NotNull Long pId) {
        productService.deleteById(pId);
        return RespEntity.ok();
    }

}

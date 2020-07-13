package com.cloud.personal.consumerserver.controller;

import com.cloud.ftl.ftlbasic.webEntity.PageBean;
import com.cloud.ftl.ftlbasic.webEntity.RespEntity;
import com.cloud.ftl.ftlbasic.webEntity.CommonResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.*;
import com.cloud.personal.consumerserver.service.IOrdersService;
import com.cloud.personal.consumerserver.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@Validated
@RequestMapping("/orders")
@Api(tags = "全局接口信息")
public class OrdersCtrl{

    @Autowired
    private IOrdersService ordersService;

    @GetMapping(value = "/obj")
    @ApiOperation(value = "根据主键查询" , tags = "xxx",hidden = true, notes = "author: llj")
    @ApiImplicitParam(name="orId", value="主键",required = true)
    public CommonResp<Orders> selectById(@RequestParam("orId") @NotNull Long orId) {
        return RespEntity.ok(ordersService.selectById(orId,"没有符合条件的记录！"));
    }

    @PostMapping(value = "/list")
    @ApiOperation(value = "查询所有列表" , tags = "xxx",hidden = true, notes = "author: llj")
    public CommonResp<List<Orders>> selectList(@RequestBody Orders orders){
        return RespEntity.ok(ordersService.selectList(orders));
    }

    @PostMapping(value = "/page")
    @ApiOperation(value = "分页查询" , tags = "xxx",hidden = true, notes = "author: llj")
    public CommonResp<PageBean<Orders>> selectPage(@RequestBody Orders orders) {
        return RespEntity.ok(ordersService.selectPage(orders));
    }


    @PostMapping(value = "/obj")
    @ApiOperation(value = "更新或者新增", tags = "xxx",hidden = true, notes = "author: llj")
    public CommonResp<Object> save(@RequestBody Orders orders) {
        ordersService.save(orders);
        return RespEntity.ok();
    }

    @DeleteMapping(value = "/obj")
    @ApiOperation(value = "根据主键删除",tags = "xxx",hidden = true, notes = "author: llj")
    @ApiImplicitParam(name="orId", value="主键",required = true)
    public CommonResp<Object> deleteById(@RequestParam(value="orId") @NotNull Long orId) {
        ordersService.deleteById(orId);
        return RespEntity.ok();
    }

}

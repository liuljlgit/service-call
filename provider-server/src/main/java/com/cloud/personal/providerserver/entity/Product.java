package com.cloud.personal.providerserver.entity;

import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.cloud.ftl.ftlbasic.constant.PatternConst;
import com.cloud.ftl.ftlbasic.webEntity.BaseQuery;
import com.cloud.ftl.ftlbasic.enums.Opt;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.cloud.ftl.ftlbasic.annotation.PrimaryKey;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel("Product")
public class Product extends BaseQuery {

	@ApiModelProperty("")
    @PrimaryKey
    private Long pId;

	@ApiModelProperty("产品名称")
    private String name;

	@ApiModelProperty("单价")
    private BigDecimal unitPrice;

	@ApiModelProperty("订单库存")
    private Integer stock;

	@ApiModelProperty("创建时间")
    @JsonFormat(pattern = PatternConst.NORM_DATETIME,timezone = PatternConst.TIMEZONE)
    private Date createTime;

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    public static final transient String P_ID = "p_id";

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    public static final transient String NAME = "name";

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    public static final transient String UNIT_PRICE = "unit_price";

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    public static final transient String STOCK = "stock";

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    public static final transient String CREATE_TIME = "create_time";


    public void andPId(Opt opt,Object... values) {
        if(values.length == 0){
            addConditGroup(P_ID,opt);
        } else if(values.length == 1){
            addConditGroup(P_ID,opt,values[0]);
        } else if(values.length == 2){
            addConditGroup(P_ID,opt,values[0],values[1]);
        } else {
            throw new RuntimeException("‘"+ P_ID + "’ 的SQL入参个数不正确 ");
        }
    }

    public void andName(Opt opt,Object... values) {
        if(values.length == 0){
            addConditGroup(NAME,opt);
        } else if(values.length == 1){
            addConditGroup(NAME,opt,values[0]);
        } else if(values.length == 2){
            addConditGroup(NAME,opt,values[0],values[1]);
        } else {
            throw new RuntimeException("‘"+ NAME + "’ 的SQL入参个数不正确 ");
        }
    }

    public void andUnitPrice(Opt opt,Object... values) {
        if(values.length == 0){
            addConditGroup(UNIT_PRICE,opt);
        } else if(values.length == 1){
            addConditGroup(UNIT_PRICE,opt,values[0]);
        } else if(values.length == 2){
            addConditGroup(UNIT_PRICE,opt,values[0],values[1]);
        } else {
            throw new RuntimeException("‘"+ UNIT_PRICE + "’ 的SQL入参个数不正确 ");
        }
    }

    public void andStock(Opt opt,Object... values) {
        if(values.length == 0){
            addConditGroup(STOCK,opt);
        } else if(values.length == 1){
            addConditGroup(STOCK,opt,values[0]);
        } else if(values.length == 2){
            addConditGroup(STOCK,opt,values[0],values[1]);
        } else {
            throw new RuntimeException("‘"+ STOCK + "’ 的SQL入参个数不正确 ");
        }
    }

    public void andCreateTime(Opt opt,Object... values) {
        if(values.length == 0){
            addConditGroup(CREATE_TIME,opt);
        } else if(values.length == 1){
            addConditGroup(CREATE_TIME,opt,values[0]);
        } else if(values.length == 2){
            addConditGroup(CREATE_TIME,opt,values[0],values[1]);
        } else {
            throw new RuntimeException("‘"+ CREATE_TIME + "’ 的SQL入参个数不正确 ");
        }
    }

}
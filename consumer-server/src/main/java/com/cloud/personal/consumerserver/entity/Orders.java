package com.cloud.personal.consumerserver.entity;

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
@ApiModel("Orders")
public class Orders extends BaseQuery {

	@ApiModelProperty("主键")
    @PrimaryKey
    private Long orId;

	@ApiModelProperty("订单流水号")
    private String orderSeq;

	@ApiModelProperty("产品id")
    private Long pId;

	@ApiModelProperty("订单数量")
    private Integer orderNum;

	@ApiModelProperty("订单总价格")
    private BigDecimal orderPrice;

	@ApiModelProperty("订单创建时间")
    @JsonFormat(pattern = PatternConst.NORM_DATETIME,timezone = PatternConst.TIMEZONE)
    private Date createTime;

	@ApiModelProperty("订单备注")
    private String remark;

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    public static final transient String OR_ID = "or_id";

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    public static final transient String ORDER_SEQ = "order_seq";

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    public static final transient String P_ID = "p_id";

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    public static final transient String ORDER_NUM = "order_num";

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    public static final transient String ORDER_PRICE = "order_price";

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    public static final transient String CREATE_TIME = "create_time";

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    public static final transient String REMARK = "remark";


    public void andOrId(Opt opt,Object... values) {
        if(values.length == 0){
            addConditGroup(OR_ID,opt);
        } else if(values.length == 1){
            addConditGroup(OR_ID,opt,values[0]);
        } else if(values.length == 2){
            addConditGroup(OR_ID,opt,values[0],values[1]);
        } else {
            throw new RuntimeException("‘"+ OR_ID + "’ 的SQL入参个数不正确 ");
        }
    }

    public void andOrderSeq(Opt opt,Object... values) {
        if(values.length == 0){
            addConditGroup(ORDER_SEQ,opt);
        } else if(values.length == 1){
            addConditGroup(ORDER_SEQ,opt,values[0]);
        } else if(values.length == 2){
            addConditGroup(ORDER_SEQ,opt,values[0],values[1]);
        } else {
            throw new RuntimeException("‘"+ ORDER_SEQ + "’ 的SQL入参个数不正确 ");
        }
    }

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

    public void andOrderNum(Opt opt,Object... values) {
        if(values.length == 0){
            addConditGroup(ORDER_NUM,opt);
        } else if(values.length == 1){
            addConditGroup(ORDER_NUM,opt,values[0]);
        } else if(values.length == 2){
            addConditGroup(ORDER_NUM,opt,values[0],values[1]);
        } else {
            throw new RuntimeException("‘"+ ORDER_NUM + "’ 的SQL入参个数不正确 ");
        }
    }

    public void andOrderPrice(Opt opt,Object... values) {
        if(values.length == 0){
            addConditGroup(ORDER_PRICE,opt);
        } else if(values.length == 1){
            addConditGroup(ORDER_PRICE,opt,values[0]);
        } else if(values.length == 2){
            addConditGroup(ORDER_PRICE,opt,values[0],values[1]);
        } else {
            throw new RuntimeException("‘"+ ORDER_PRICE + "’ 的SQL入参个数不正确 ");
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

    public void andRemark(Opt opt,Object... values) {
        if(values.length == 0){
            addConditGroup(REMARK,opt);
        } else if(values.length == 1){
            addConditGroup(REMARK,opt,values[0]);
        } else if(values.length == 2){
            addConditGroup(REMARK,opt,values[0],values[1]);
        } else {
            throw new RuntimeException("‘"+ REMARK + "’ 的SQL入参个数不正确 ");
        }
    }

}
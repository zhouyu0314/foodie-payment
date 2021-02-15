package com.zy.pojo;
import java.io.Serializable;
import java.util.Date;
/***
*   订单表;
*/
public class PayOrders implements Serializable {
    //订单主键
    private String id;
    //商户订单号
    private String merchantOrderId;
    //商户方的发起用户的用户主键id
    private String merchantUserId;
    //实际支付总金额（包含商户所支付的订单费邮费总额）
    private Integer amount;
    //支付方式
    private Integer payMethod;
    //支付状态 10：未支付 20：已支付 30：支付失败 40：已退款
    private Integer payStatus;
    //从哪一端来的，比如从天天吃货这门实战过来的
    private String comeFrom;
    //支付成功后的通知地址，这个是开发者那一段的，不是第三方支付通知的地址
    private String returnUrl;
    //逻辑删除状态;1: 删除 0:未删除
    private Integer isDelete;
    //创建时间（成交时间）
    private Date createdTime;
    //get set 方法
    public void setId (String  id){
        this.id=id;
    }
    public  String getId(){
        return this.id;
    }
    public void setMerchantOrderId (String  merchantOrderId){
        this.merchantOrderId=merchantOrderId;
    }
    public  String getMerchantOrderId(){
        return this.merchantOrderId;
    }
    public void setMerchantUserId (String  merchantUserId){
        this.merchantUserId=merchantUserId;
    }
    public  String getMerchantUserId(){
        return this.merchantUserId;
    }
    public void setAmount (Integer  amount){
        this.amount=amount;
    }
    public  Integer getAmount(){
        return this.amount;
    }
    public void setPayMethod (Integer  payMethod){
        this.payMethod=payMethod;
    }
    public  Integer getPayMethod(){
        return this.payMethod;
    }
    public void setPayStatus (Integer  payStatus){
        this.payStatus=payStatus;
    }
    public  Integer getPayStatus(){
        return this.payStatus;
    }
    public void setComeFrom (String  comeFrom){
        this.comeFrom=comeFrom;
    }
    public  String getComeFrom(){
        return this.comeFrom;
    }
    public void setReturnUrl (String  returnUrl){
        this.returnUrl=returnUrl;
    }
    public  String getReturnUrl(){
        return this.returnUrl;
    }
    public void setIsDelete (Integer  isDelete){
        this.isDelete=isDelete;
    }
    public  Integer getIsDelete(){
        return this.isDelete;
    }
    public void setCreatedTime (Date  createdTime){
        this.createdTime=createdTime;
    }
    public  Date getCreatedTime(){
        return this.createdTime;
    }
}

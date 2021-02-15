package com.zy.service;

import com.zy.pojo.PayOrders;
import com.zy.pojo.bo.MerchantOrdersBO;

public interface PaymentOrderService {

	/**
	 * @Description: 创建支付中心的订单
	 */
	boolean createPaymentOrder(MerchantOrdersBO merchantOrdersBO)throws Exception;

	/**
	 * @Description: 查询未支付订单
	 */
	PayOrders queryOrderByStatus(String merchantUserId, String merchantOrderId, Integer orderStatus)throws Exception;

	/**
	 * @Description: 修改订单状态为已支付
	 */
	String updateOrderPaid(String merchantOrderId, Integer paidAmount)throws Exception;

	/**
	 * @Description: 查询订单信息
	 */
	PayOrders queryOrderInfo(String merchantUserId, String merchantOrderId)throws Exception;
}


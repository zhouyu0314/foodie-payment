package com.zy.service.impl;

import com.zy.enums.PaymentStatus;
import com.zy.enums.YesOrNo;
import com.zy.idworker.Sid;
import com.zy.mapper.PayOrdersMapper;
import com.zy.pojo.PayOrders;
import com.zy.pojo.bo.MerchantOrdersBO;
import com.zy.service.PaymentOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentOrderServiceImpl implements PaymentOrderService {

    @Autowired
    private PayOrdersMapper payOrdersMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean createPaymentOrder(MerchantOrdersBO merchantOrdersBO) throws Exception {

        String id = Sid.nextShort();

        PayOrders paymentOrder = new PayOrders();
        BeanUtils.copyProperties(merchantOrdersBO, paymentOrder);

        paymentOrder.setId(id);
        paymentOrder.setPayStatus(PaymentStatus.WAIT_PAY.type);
        paymentOrder.setComeFrom("天天吃货");
        paymentOrder.setIsDelete(YesOrNo.NO.type);
        paymentOrder.setCreatedTime(new Date());

        int result = payOrdersMapper.insertPayOrders(paymentOrder);
        return result == 1 ? true : false;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PayOrders queryOrderByStatus(String merchantUserId, String merchantOrderId, Integer orderStatus) throws Exception {
        Map<String,Object> param = new HashMap<>();
        param.put("merchantOrderId",merchantOrderId);
        param.put("merchantUserId",merchantUserId);
        param.put("orderStatus",orderStatus);
        List<PayOrders> list = payOrdersMapper.getPayOrdersListByMap(param);
        if (list ==null || list.size() ==0) {
            return new PayOrders();
        }
        return list.get(0);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public String updateOrderPaid(String merchantOrderId, Integer paidAmount) throws Exception {
        PayOrders payOrders = new PayOrders();
        payOrders.setMerchantOrderId(merchantOrderId);
        payOrders.setPayStatus(PaymentStatus.PAID.type);
        payOrders.setAmount(paidAmount);
         payOrdersMapper.updatePayOrders(payOrders);

        return queryMerchantReturnUrl(merchantOrderId);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    String queryMerchantReturnUrl(String merchantOrderId)throws Exception {
        Map<String,Object> param = new HashMap<>();
        param.put("merchantOrderId",merchantOrderId);
        List<PayOrders> list = payOrdersMapper.getPayOrdersListByMap(param);
        if (list ==null || list.size() ==0) {
            return null;
        }
        return list.get(0).getReturnUrl();


    }

    @Override
    public PayOrders queryOrderInfo(String merchantUserId, String merchantOrderId) throws Exception {
        Map<String,Object> param = new HashMap<>();
        param.put("merchantOrderId",merchantOrderId);
        param.put("merchantUserId",merchantUserId);
        List<PayOrders> list = payOrdersMapper.getPayOrdersListByMap(param);
        if (list ==null || list.size() ==0) {
            return null;
        }
        return list.get(0);
    }
}

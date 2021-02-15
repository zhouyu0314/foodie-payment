package com.zy.mapper;

import com.zy.pojo.PayOrders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface PayOrdersMapper {

	PayOrders getPayOrdersById(@Param(value = "id") Long id)throws Exception;

	List<PayOrders>	getPayOrdersListByMap(Map<String,Object> param)throws Exception;

	Integer getPayOrdersCountByMap(Map<String,Object> param)throws Exception;

	Integer insertPayOrders(PayOrders payOrders)throws Exception;

	Integer updatePayOrders(PayOrders payOrders)throws Exception;


}

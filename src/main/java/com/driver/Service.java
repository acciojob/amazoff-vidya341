package com.driver;


import java.util.ArrayList;
import java.util.List;
import java.util.*;

@org.springframework.stereotype.Service
public class Service {
    repository repo = new repository();

    public void add_order(Order order)
    {
        repo.add_order(order);
    }
    public void add_dp(String  dp_id)
    {
        repo.add_deliverypartner(dp_id);
    }
    public void add_order_to_partner(String ord_id,String dp_id)
    {
        repo.add_order_to_partner(ord_id,dp_id);
    }
    public Order get_order_by_id(String ord_id)
    {
        return repo.get_order_by_id(ord_id);
    }
    public DeliveryPartner get_partner_by_id(String dp_id)
    {
        return repo.get_dp_by_id(dp_id);
    }
    public int get_ordercount_by_id(String dp_id)
    {
        int count=0;
        List<Order> list_of_orders = repo.get_order_by_dpid(dp_id);
        return list_of_orders.size();
    }
    public List<String> get_order_obj_dpid(String dp_id)
    {
        List<Order> temp = repo.get_order_by_dpid(dp_id);
        List<String > order_list = new ArrayList<>();
        for(Order ord:temp)
        {
            order_list.add(ord.getId());
        }
        return order_list;
    }
    public List<String> get_all_orders()
    {
        return repo.get_all_orders();
    }
    public int get_unaasigned_order_count()
    {
        return repo.get_unassigned_order_count();
    }
    public void delete_partner_and_orders(String dp_id)
    {
        repo.delete_partner_and_order(dp_id);
    }
    public void delete_order_unassign(String ord_id)
    {
        repo.delete_ord_and_unassign(ord_id);
    }
    public int count_ord_undelived_time(String time,String dp_id)
    {
        int count=0;
        List<Order> list = repo.get_order_by_dpid(dp_id);
        int h = Integer.parseInt(time.substring(0,2));
        int m = Integer.parseInt(time.substring(3,4));
        int int_time = (h*60)+m;
        for(Order ord:list)
        {
            int del_time = ord.getDeliveryTime();
            if(del_time<int_time)
            {
                count++;
            }
        }
        return count;

    }
    public String  get_last_del_time(String dp_id)
    {
        int max_time=Integer.MIN_VALUE;
        List<Order> list_ord = repo.get_order_by_dpid(dp_id);
        for(Order ord:list_ord)
        {
            int del_time = ord.getDeliveryTime();
            max_time = Math.max(max_time,del_time);
        }
        return max_time+"";


    }

}
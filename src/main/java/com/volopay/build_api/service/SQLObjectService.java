package com.volopay.build_api.service;

import com.volopay.build_api.entity.SQLObject;

import java.util.List;

public interface SQLObjectService
{
    List<SQLObject> find_total_items(String startTime, String endTime, String dept);

    List<SQLObject> find_item_by_quantity(String startTime, String endTime, int n);

    List<SQLObject> find_item_by_price(String startTime, String endTime, int n);

    List<SQLObject> find_percentage_departmentwise(String startTime, String endTime);
}

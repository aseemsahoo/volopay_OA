package com.volopay.build_api.rest;

import com.volopay.build_api.entity.SQLObject;
import com.volopay.build_api.service.SQLObjectService;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController
{
    private final SQLObjectService object_service;

    @Autowired
    public RestController(SQLObjectService object_service)
    {
        this.object_service = object_service;
    }

    // API 1
    @GetMapping("/total_items/{startTime}/{endTime}/{dept}")
    public int total_items(
            @PathVariable String startTime,
            @PathVariable String endTime,
            @PathVariable String dept)
    {
        // the SQL query returns all the items
        List<SQLObject> items = object_service.find_total_items(startTime, endTime, dept);

        // so we just return the size of the ArrayList
        return items.size();
    }

    // API 2
    @GetMapping("/nth_most_total_item/{amount}/{startTime}/{endTime}/{n}")
    public String nth_most_total_item(
            @PathVariable String amount,
            @PathVariable String startTime,@PathVariable String endTime,
            @PathVariable int n)
    {
        // item by quantity
        // SQL query returns top N objects
        List<SQLObject> item;
        if(amount.equals("quantity"))
        {
            item = object_service.find_item_by_quantity(startTime, endTime, n);
        }
        // item by price
        else
        {
            item = object_service.find_item_by_price(startTime, endTime, n);
        }
        // so we return the topmost object
        return item.get(item.size()-1).getSoftware();
    }

    // API 3
    @GetMapping("/percentage_of_department_wise_sold_items/{startTime}/{endTime}")
    public List<Pair<String,Integer>> percentage_of_department_wise_sold_items(
            @PathVariable String startTime,@PathVariable String endTime)
    {
        // SQL Query returns all departments with their percentage share
        List<SQLObject> item_array = object_service.find_percentage_departmentwise(startTime, endTime);

        List<Pair<String, Integer>> res = new ArrayList<>();
        for(SQLObject item : item_array)
        {

            Pair<String, Integer> tmp = new Pair<>(item.getDepartment(), item.getSeats());
            res.add(tmp);
        }
        return res;
    }

    // API 4
    @GetMapping("/monthly_sales/{software}/{year}")
    public List<SQLObject> monthly_sales(
            @PathVariable String software,
            @PathVariable String year)
    {
        return null;
    }
}

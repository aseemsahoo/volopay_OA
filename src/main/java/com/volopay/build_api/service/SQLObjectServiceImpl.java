package com.volopay.build_api.service;


import com.volopay.build_api.DAO.SQLObjectDAO;
import com.volopay.build_api.entity.SQLObject;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SQLObjectServiceImpl implements SQLObjectService
{

    private SQLObjectDAO objectDAO;

    public SQLObjectServiceImpl(SQLObjectDAO objectDAO) {
        this.objectDAO = objectDAO;
    }

    @Override
    @Transactional
    public List<SQLObject> find_total_items(String startTime, String endTime, String dept)
    {
        try
        {
            return objectDAO.find_total_items(startTime, endTime, dept);
        }
        catch(Exception ex)
        {
            throw ex;
        }
    }

    @Override
    public List<SQLObject> find_item_by_quantity(String startTime, String endTime, int n)
    {
        try
        {
            return objectDAO.find_item_by_quantity(startTime, endTime, n);
        }
        catch(Exception ex)
        {
            throw ex;
        }
    }

    @Override
    public List<SQLObject> find_item_by_price(String startTime, String endTime, int n)
    {
        try
        {
            return objectDAO.find_item_by_price(startTime, endTime, n);
        }
        catch(Exception ex)
        {
            throw ex;
        }
    }

    @Override
    public List<SQLObject> find_percentage_departmentwise(String startTime, String endTime)
    {
        try
        {
            return objectDAO.find_percentage_departmentwise(startTime, endTime);
        }
        catch(Exception ex)
        {
            throw ex;
        }
    }
}

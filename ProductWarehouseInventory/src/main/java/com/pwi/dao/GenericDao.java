package com.pwi.dao;

import com.pwi.model.Company;

import java.util.List;

public interface GenericDao {
    public Object save(Object object);
    public List findAll(String tableName);
    public List findById(String query, String mask, String param);
    public void update(Object object);
    public <T> T findById(Class<T> c, String id);
    public void delete(Object object);
}

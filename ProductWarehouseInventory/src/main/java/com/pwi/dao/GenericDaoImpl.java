package com.pwi.dao;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenericDaoImpl implements GenericDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSessionFactory() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Object save(Object object) {
        if (object != null) {
            String a = (String) this.getSessionFactory().save(object);
        }
        return object;
    }

    @Override
    public List findAll(String tableName) {
        if (StringUtils.isNotBlank(tableName)) {
            return this.getSessionFactory().createQuery("FROM " + tableName).list();
        }
        return null;
    }

    @Override
    public List findById(String query, String mask, String param) {
        return this.getSessionFactory().createQuery(query).setParameter(mask, param).list();
    }

    @Override
    public void update(Object object) {
        if (object != null) {
            this.getSessionFactory().saveOrUpdate(object);
        }
    }

    @Override
    public void delete(Object object) {
        if (object != null) {
            this.getSessionFactory().delete(object);
        }
    }

    @Override
    public <T> T findById(Class<T> c, String id) {
        if (c != null && StringUtils.isNotBlank(id)) {
            return this.getSessionFactory().get(c, id);
        }
        return null;
    }
}

package com.atguigu.base;

import com.atguigu.util.CastUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.Map;

/**
 * @author 孙消飞
 * @version 1.0
 */
public abstract class BaseServiceImpl<T> implements BaseService<T>{

    public abstract BaseDao<T> getEntityDao();

    @Override
    public Integer insert(T t) {
        Integer count = getEntityDao().insert(t);
        return count;
    }

    @Override
    public T getById(Serializable id) {
        T t = getEntityDao().getById(id);
        return t;
    }

    @Override
    public void update(T t) {
        getEntityDao().update(t);
    }

    @Override
    public void delete(Serializable id) {
        getEntityDao().delete(id);
    }

    @Override
    public PageInfo<T> findPage(Map<String, Object> filters) {
        //当前页数
        int pageNum = CastUtil.castInt(filters.get("pageNum"), 1);
        //每页显示的记录数
        int pageSize = CastUtil.castInt(filters.get("pageSize"), 5);
        //开启分页功能，将这两个参数，与当前线程进行绑定，传递给dao层。
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<T>(getEntityDao().findPage(filters),5);
    }
}

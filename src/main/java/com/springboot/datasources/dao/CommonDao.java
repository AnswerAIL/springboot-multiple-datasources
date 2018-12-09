package com.springboot.datasources.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by L.Answer on 2018-12-07 15:22
 * 增: insert*
 * 删: delete*
 * 改: update*
 * 查: find*
 */
public interface CommonDao<K> {

    /**
     * 根据主键查询记录
     * @param key 主键
     * @param pageInfo 分页信息
     * @return T
     * */
    <T> T findByPrimaryKey(K key, Map<String, Object> pageInfo);
    /**
     * 根据字段查询记录
     * @param params 具体字段集合
     * @return List<T>
     * */
    <T> List<T> findRecordsBySelectKeys(Map<String, Object> params);
    /**
     * 根据字段查询总数
     * @param params 具体字段集合
     * @return int
     * */
    int countRecordsBySelectKeys(Map<String, Object> params);



    /**
     * 根据字段更新记录
     * @param params 具体字段集合
     * @return int
     * */
    int updateBySelectKeys(Map<String, Object> params);
    /**
     * 根据对象更新记录
     * @param entity 实体对象
     * @return int
     * */
    <T> int updateByRecord(T entity);
    /**
     * 根据对象更新记录集
     * @param entities 实体对象集合
     * @return int
     * */
    <T> int updateByRecords(@Param("entities") List<T> entities);



    /**
     * 新增单条记录
     * @param entity 实体对象
     * @return int
     * */
    <T> int insertSingleRecord(T entity);
    /**
     * 批量新增记录集
     * @param entities 实体对象集合
     * @return int
     * */
    <T> int insertBatchRecords(@Param("entities") List<T> entities);


    /**
     * 更新主键删除记录
     * @param key 主键
     * @return int
     * */
    int deleteByPrimaryKey(K key);
    /**
     * 根据对象删除记录
     * @param entity 实体对象
     * @return int
     * */
    <T> int deleteByRecord(T entity);

}
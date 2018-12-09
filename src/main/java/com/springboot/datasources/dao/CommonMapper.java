package com.springboot.datasources.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by L.Answer on 2018-12-07 15:22
 */
public interface CommonMapper<K> {

    /**
     * 根据主键查询记录
     * @param key
     * @return T
     * */
    <T> T findByPrimaryKey(K key);
    /**
     * 根据字段查询记录
     * @param params
     * @return List<T>
     * */
    <T> List<T> findRecordsBySelectKeys(Map<String, Object> params);
    /**
     * 根据字段查询总数
     * @param params
     * @return int
     * */
    int countRecordsBySelectKeys(Map<String, Object> params);



    /**
     * 根据字段更新记录
     * @param params
     * @return int
     * */
    int updateBySelectKeys(Map<String, Object> params);
    /**
     * 根据对象更新记录
     * @param record
     * @return int
     * */
    <T> int updateByRecord(T record);
    /**
     * 根据对象更新记录集
     * @param records
     * @return int
     * */
    <T> int updateByRecords(@Param("records") List<T> records);



    /**
     * 新增单条记录
     * @param record
     * @return int
     * */
    <T> int insertSingleRecord(T record);
    /**
     * 批量新增记录集
     * @param records
     * @return int
     * */
    <T> int insertBatchRecords(@Param("records") List<T> records);


    /**
     * 更新主键删除记录
     * @param key
     * @return int
     * */
    int deleteByPrimaryKey(K key);
    /**
     * 根据对象删除记录
     * @param record
     * @return int
     * */
    <T> int deleteByRecord(T record);

}
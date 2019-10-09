package com.bradypod.base.service;


import com.bradypod.base.domain.po.PageRequest;

import java.io.Serializable;
import java.util.List;

/**
 * @author https://github.com/JumperYu
 * @version 2019/10/09
 */
public interface BaseMybatisService<E extends Serializable> {

    /**
     * 保存
     *
     * @param e - 实体对象
     * @return - 影响行数
     */
    int save(E e);

    /**
     * 更新
     *
     * @param
     * @param e - 实体对象
     * @return - 影响行数
     */
    int update(E e);

    /**
     * 获取全部
     *
     * @param
     * @return List - 返回实体数组
     */
    List<E> getAll(E e);

    /**
     * 删除实体
     *
     * @param
     * @param e - 实体对戏
     * @return int - 影响的数据表的行数
     */
    int delete(E e);

    /**
     * 获取实体
     *
     * @param
     * @return E - 返回实体
     */
    E get(E e);

    /**
     * 分页查询
     *
     * @param q
     * @return
     */
    <Q extends PageRequest> List<E> listData(Q q);

    /**
     * 统计行数
     *
     * @param q
     * @return
     */
    <Q extends PageRequest> Integer countData(Q q);
}

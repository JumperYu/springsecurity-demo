package com.bradypod.base.domain.mapper;


import com.bradypod.base.domain.po.PageRequest;

import java.util.List;

/**
 *
 * @author https://github.com/JumperYu
 * @version 2019/09/29
 */
public interface BaseMapper<E> {

    /**
     * 保存实体
     *
     * @param e - 实体类
     * @return int - 影响的数据表的行数
     */
    int save(E e);

    /**
     * 删除实体
     *
     * @param e - 实体类
     * @return int - 影响的数据表的行数
     */
    int delete(E e);

    /**
     * 获取实体
     *
     * @param e - 实体类
     * @return E - 返回实体
     */
    E get(E e);

    /**
     * 更新实体
     *
     * @param e - 实体对象
     * @return int - 数据库影响行数
     */
    int update(E e);

    /**
     * 获取全部
     *
     * @param e - 实体
     * @return List - 返回实体数组
     */
    List<E> getAll(E e);

    /**
     * 分页查询
     *
     * @param pageRequest - 分页实体
     * @return - List<E>
     */
    List<E> listData(PageRequest pageRequest);

    /**
     * 统计条数
     *
     * @param pageRequest - Map参数
     * @return - 条数
     */
    Integer countData(PageRequest pageRequest);
}

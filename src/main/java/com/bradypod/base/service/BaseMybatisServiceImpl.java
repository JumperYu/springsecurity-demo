package com.bradypod.base.service;

import com.bradypod.base.domain.mapper.BaseMapper;
import com.bradypod.base.domain.po.PageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @author https://github.com/JumperYu
 * @version 2019/10/09
 */
public abstract class BaseMybatisServiceImpl<M extends BaseMapper<E>, E extends Serializable>
        implements BaseMybatisService<E> {

    /**
     * @param e - 实体对象
     * @return {@link int}
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public int save(E e) {
        int rows = getMapper().save(e);
        if (rows != 1) {
            log.debug("插入数据失败, 期望插入1行, 结果为 {}", rows);
        }
        return rows;
    }

    /**
     * @param e - 实体对象
     * @return {@link int}
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public int update(E e) {
        int rows = getMapper().update(e);
        if (rows != 1) {
            log.debug("插入数据失败, 期望插入1行, 结果为 {}", rows);
        }
        return rows;
    }

    /**
     * 获取全部
     *
     * @return List - 返回实体数组
     */
    @Override
    public List<E> getAll(E e) {
        return getMapper().getAll(e);
    }

    /**
     * 删除实体
     *
     * @param e - 实体对戏
     * @return int - 影响的数据表的行数
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public int delete(E e) {
        return getMapper().delete(e);
    }

    /**
     * 获取实体
     *
     * @return E - 返回实体
     */
    @Override
    public E get(E e) {
        return getMapper().get(e);
    }

    @Override
    public <Q extends PageRequest> List<E> listData(Q pageRequest) {
        return getMapper().listData(pageRequest);
    }

    @Override
    public <Q extends PageRequest> Integer countData(Q pageRequest) {
        return getMapper().countData(pageRequest);
    }

    protected static final Logger log = LoggerFactory.getLogger(BaseMybatisServiceImpl.class);

    private M mapper;

    @Resource
    private void setMapper(M mapper) {
        this.mapper = mapper;
    }

    public M getMapper() {
        return mapper;
    }
}

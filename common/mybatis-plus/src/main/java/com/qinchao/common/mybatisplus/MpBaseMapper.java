package com.qinchao.common.mybatisplus;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * Description
 *
 * @author djdgt
 * @since 2023/3/1 15:06
 */
public interface MpBaseMapper<T> extends BaseMapper<T> {

    int insertBatchSomeColumn(List<T> entityList);
}

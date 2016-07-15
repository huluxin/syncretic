/*
 * Copyright (c) 2016 yunmle.com(四川云麦尔科技).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.yunmel.syncretic.core;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Param;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 自定义mapepr
 * 
 * @author xuyq
 *
 * @param <T>
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
  /**
   * 批量删除
   * 
   * @param ids 主键数组
   * @return
   */
  @DeleteProvider(type = BaseMapperProvider.class, method = "dynamicSQL")
  public abstract int deleteByIDS(@Param("ids") Object[] ids);

}

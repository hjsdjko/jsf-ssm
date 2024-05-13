package com.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.entity.JianshenqicaixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JianshenqicaixinxiView;

/**
 *  Dao 接口
 *
 * @author 
 * @since 2021-01-26
 */
public interface JianshenqicaixinxiDao extends BaseMapper<JianshenqicaixinxiEntity> {

   List<JianshenqicaixinxiView> selectListView(Page<JianshenqicaixinxiView> page, @Param("params") Map<String, Object> params);

}

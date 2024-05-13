package com.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.entity.YuykechengxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YuykechengxinxiView;

/**
 *  Dao 接口
 *
 * @author 
 * @since 2021-01-28
 */
public interface YuykechengxinxiDao extends BaseMapper<YuykechengxinxiEntity> {

   List<YuykechengxinxiView> selectListView(Page<YuykechengxinxiView> page, @Param("params") Map<String, Object> params);

}

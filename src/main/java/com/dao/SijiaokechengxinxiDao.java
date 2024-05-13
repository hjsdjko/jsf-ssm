package com.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.entity.SijiaokechengxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.SijiaokechengxinxiView;

/**
 *  Dao 接口
 *
 * @author 
 * @since 2021-01-26
 */
public interface SijiaokechengxinxiDao extends BaseMapper<SijiaokechengxinxiEntity> {

   List<SijiaokechengxinxiView> selectListView(Page<SijiaokechengxinxiView> page, @Param("params") Map<String, Object> params);

}

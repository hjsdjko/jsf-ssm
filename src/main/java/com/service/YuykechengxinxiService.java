package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YuykechengxinxiEntity;
import java.util.Map;

/**
 *  服务类
 * @author 
 * @since 2021-01-28
 */
public interface YuykechengxinxiService extends IService<YuykechengxinxiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}
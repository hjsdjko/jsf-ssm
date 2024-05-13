package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiaolianxinxiEntity;
import java.util.Map;

/**
 *  服务类
 * @author 
 * @since 2021-01-26
 */
public interface JiaolianxinxiService extends IService<JiaolianxinxiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}
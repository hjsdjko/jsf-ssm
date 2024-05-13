package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuiyuankaleixingEntity;
import java.util.Map;

/**
 *  服务类
 * @author 
 * @since 2021-01-26
 */
public interface HuiyuankaleixingService extends IService<HuiyuankaleixingEntity> {

     PageUtils queryPage(Map<String, Object> params);

}
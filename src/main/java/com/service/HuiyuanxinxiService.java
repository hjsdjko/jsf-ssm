package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuiyuanxinxiEntity;
import java.util.Map;

/**
 *  服务类
 * @author 
 * @since 2021-01-26
 */
public interface HuiyuanxinxiService extends IService<HuiyuanxinxiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}
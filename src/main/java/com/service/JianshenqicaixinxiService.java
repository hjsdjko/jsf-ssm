package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JianshenqicaixinxiEntity;
import java.util.Map;

/**
 *  服务类
 * @author 
 * @since 2021-01-26
 */
public interface JianshenqicaixinxiService extends IService<JianshenqicaixinxiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}
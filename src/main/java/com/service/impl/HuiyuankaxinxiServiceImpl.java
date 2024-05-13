package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.HuiyuankaxinxiDao;
import com.entity.HuiyuankaxinxiEntity;
import com.service.HuiyuankaxinxiService;
import com.entity.view.HuiyuankaxinxiView;

/**
 *  服务实现类
 * @author 
 * @since 2021-01-26
 */
@Service("huiyuankaxinxiService")
@Transactional
public class HuiyuankaxinxiServiceImpl extends ServiceImpl<HuiyuankaxinxiDao, HuiyuankaxinxiEntity> implements HuiyuankaxinxiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<HuiyuankaxinxiView> page =new Query<HuiyuankaxinxiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}

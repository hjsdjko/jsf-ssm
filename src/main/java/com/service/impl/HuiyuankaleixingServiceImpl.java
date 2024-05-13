package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.HuiyuankaleixingDao;
import com.entity.HuiyuankaleixingEntity;
import com.service.HuiyuankaleixingService;
import com.entity.view.HuiyuankaleixingView;

/**
 *  服务实现类
 * @author 
 * @since 2021-01-26
 */
@Service("huiyuankaleixingService")
@Transactional
public class HuiyuankaleixingServiceImpl extends ServiceImpl<HuiyuankaleixingDao, HuiyuankaleixingEntity> implements HuiyuankaleixingService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<HuiyuankaleixingView> page =new Query<HuiyuankaleixingView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}

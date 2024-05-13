package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.SijiaokechengxinxiDao;
import com.entity.SijiaokechengxinxiEntity;
import com.service.SijiaokechengxinxiService;
import com.entity.view.SijiaokechengxinxiView;

/**
 *  服务实现类
 * @author 
 * @since 2021-01-26
 */
@Service("sijiaokechengxinxiService")
@Transactional
public class SijiaokechengxinxiServiceImpl extends ServiceImpl<SijiaokechengxinxiDao, SijiaokechengxinxiEntity> implements SijiaokechengxinxiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<SijiaokechengxinxiView> page =new Query<SijiaokechengxinxiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}

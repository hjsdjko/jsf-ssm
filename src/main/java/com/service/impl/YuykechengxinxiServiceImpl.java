package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.YuykechengxinxiDao;
import com.entity.YuykechengxinxiEntity;
import com.service.YuykechengxinxiService;
import com.entity.view.YuykechengxinxiView;

/**
 *  服务实现类
 * @author 
 * @since 2021-01-28
 */
@Service("yuykechengxinxiService")
@Transactional
public class YuykechengxinxiServiceImpl extends ServiceImpl<YuykechengxinxiDao, YuykechengxinxiEntity> implements YuykechengxinxiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<YuykechengxinxiView> page =new Query<YuykechengxinxiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}

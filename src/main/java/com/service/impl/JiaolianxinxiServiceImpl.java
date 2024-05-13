package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.JiaolianxinxiDao;
import com.entity.JiaolianxinxiEntity;
import com.service.JiaolianxinxiService;
import com.entity.view.JiaolianxinxiView;

/**
 *  服务实现类
 * @author 
 * @since 2021-01-26
 */
@Service("jiaolianxinxiService")
@Transactional
public class JiaolianxinxiServiceImpl extends ServiceImpl<JiaolianxinxiDao, JiaolianxinxiEntity> implements JiaolianxinxiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<JiaolianxinxiView> page =new Query<JiaolianxinxiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}

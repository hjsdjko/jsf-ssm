package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.HuiyuanxinxiDao;
import com.entity.HuiyuanxinxiEntity;
import com.service.HuiyuanxinxiService;
import com.entity.view.HuiyuanxinxiView;

/**
 *  服务实现类
 * @author 
 * @since 2021-01-28
 */
@Service("huiyuanxinxiService")
@Transactional
public class HuiyuanxinxiServiceImpl extends ServiceImpl<HuiyuanxinxiDao, HuiyuanxinxiEntity> implements HuiyuanxinxiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<HuiyuanxinxiView> page =new Query<HuiyuanxinxiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}

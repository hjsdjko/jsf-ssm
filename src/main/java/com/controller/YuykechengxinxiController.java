package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.YuykechengxinxiEntity;

import com.service.YuykechengxinxiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 
 * 后端接口
 * @author
 * @email
 * @date 2021-01-28
*/
@RestController
@Controller
@RequestMapping("/yuykechengxinxi")
public class YuykechengxinxiController {
    private static final Logger logger = LoggerFactory.getLogger(YuykechengxinxiController.class);

    @Autowired
    private YuykechengxinxiService yuykechengxinxiService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        params.put("userId",request.getSession().getAttribute("userId"));
        params.put("role",request.getSession().getAttribute("role"));
        PageUtils page = yuykechengxinxiService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        YuykechengxinxiEntity yuykechengxinxi = yuykechengxinxiService.selectById(id);
        if(yuykechengxinxi!=null){
            return R.ok().put("data", yuykechengxinxi);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YuykechengxinxiEntity yuykechengxinxi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<YuykechengxinxiEntity> queryWrapper = new EntityWrapper<YuykechengxinxiEntity>()
            .eq("sjidTypes", yuykechengxinxi.getSjidTypes())
            .eq("hyidTypes", yuykechengxinxi.getHyidTypes());
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YuykechengxinxiEntity yuykechengxinxiEntity = yuykechengxinxiService.selectOne(queryWrapper);
        if(yuykechengxinxiEntity==null){
            yuykechengxinxiService.insert(yuykechengxinxi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YuykechengxinxiEntity yuykechengxinxi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<YuykechengxinxiEntity> queryWrapper = new EntityWrapper<YuykechengxinxiEntity>()
            .notIn("id",yuykechengxinxi.getId())
            .eq("sjidTypes", yuykechengxinxi.getSjidTypes())
            .eq("hyidTypes", yuykechengxinxi.getHyidTypes());
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YuykechengxinxiEntity yuykechengxinxiEntity = yuykechengxinxiService.selectOne(queryWrapper);
        if(yuykechengxinxiEntity==null){
            yuykechengxinxiService.updateById(yuykechengxinxi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        yuykechengxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}


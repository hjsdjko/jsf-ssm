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

import com.entity.JianshenqicaixinxiEntity;

import com.service.JianshenqicaixinxiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 
 * 后端接口
 * @author
 * @email
 * @date 2021-01-26
*/
@RestController
@Controller
@RequestMapping("/jianshenqicaixinxi")
public class JianshenqicaixinxiController {
    private static final Logger logger = LoggerFactory.getLogger(JianshenqicaixinxiController.class);

    @Autowired
    private JianshenqicaixinxiService jianshenqicaixinxiService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = jianshenqicaixinxiService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        JianshenqicaixinxiEntity jianshenqicaixinxi = jianshenqicaixinxiService.selectById(id);
        if(jianshenqicaixinxi!=null){
            return R.ok().put("data", jianshenqicaixinxi);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JianshenqicaixinxiEntity jianshenqicaixinxi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<JianshenqicaixinxiEntity> queryWrapper = new EntityWrapper<JianshenqicaixinxiEntity>()
            .eq("qcname", jianshenqicaixinxi.getQcname());
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JianshenqicaixinxiEntity jianshenqicaixinxiEntity = jianshenqicaixinxiService.selectOne(queryWrapper);
        if(jianshenqicaixinxiEntity==null){
            jianshenqicaixinxiService.insert(jianshenqicaixinxi);
            return R.ok();
        }else {
            return R.error("表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JianshenqicaixinxiEntity jianshenqicaixinxi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<JianshenqicaixinxiEntity> queryWrapper = new EntityWrapper<JianshenqicaixinxiEntity>()
            .notIn("id",jianshenqicaixinxi.getId())
            .eq("qcname", jianshenqicaixinxi.getQcname());
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JianshenqicaixinxiEntity jianshenqicaixinxiEntity = jianshenqicaixinxiService.selectOne(queryWrapper);
        if(jianshenqicaixinxiEntity==null){
            jianshenqicaixinxiService.updateById(jianshenqicaixinxi);//根据id更新
            return R.ok();
        }else {
            return R.error("表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        jianshenqicaixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}


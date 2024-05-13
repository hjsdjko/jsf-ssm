package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.HuiyuanxinxiEntity;
import com.entity.YuykechengxinxiEntity;
import com.service.HuiyuanxinxiService;
import com.service.YuykechengxinxiService;
import org.apache.commons.lang3.StringUtils;
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

import com.entity.SijiaokechengxinxiEntity;

import com.service.SijiaokechengxinxiService;
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
@RequestMapping("/sijiaokechengxinxi")
public class SijiaokechengxinxiController {
    private static final Logger logger = LoggerFactory.getLogger(SijiaokechengxinxiController.class);

    @Autowired
    private SijiaokechengxinxiService sijiaokechengxinxiService;

    @Autowired
    private YuykechengxinxiService yuykechengxinxiService;

    @Autowired
    private HuiyuanxinxiService huiyuanxinxiService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = sijiaokechengxinxiService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        SijiaokechengxinxiEntity sijiaokechengxinxi = sijiaokechengxinxiService.selectById(id);
        if(sijiaokechengxinxi!=null){
            return R.ok().put("data", sijiaokechengxinxi);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody SijiaokechengxinxiEntity sijiaokechengxinxi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<SijiaokechengxinxiEntity> queryWrapper = new EntityWrapper<SijiaokechengxinxiEntity>()
            .eq("sjname", sijiaokechengxinxi.getSjname()) ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SijiaokechengxinxiEntity sijiaokechengxinxiEntity = sijiaokechengxinxiService.selectOne(queryWrapper);
        if(sijiaokechengxinxiEntity==null){
            sijiaokechengxinxi.setId((int) (new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue()));
            sijiaokechengxinxiService.insert(sijiaokechengxinxi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody SijiaokechengxinxiEntity sijiaokechengxinxi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<SijiaokechengxinxiEntity> queryWrapper = new EntityWrapper<SijiaokechengxinxiEntity>()
                .notIn("id",sijiaokechengxinxi.getId())
                .eq("sjname", sijiaokechengxinxi.getSjname()) ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SijiaokechengxinxiEntity sijiaokechengxinxiEntity = sijiaokechengxinxiService.selectOne(queryWrapper);
        if(sijiaokechengxinxiEntity==null){
            sijiaokechengxinxiService.updateById(sijiaokechengxinxi);//根据id更新
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
        sijiaokechengxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    * 预约
    */
    @RequestMapping("/order")
    public R order(@RequestBody Integer ids, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",order");
        //获取到session中的用户id
        Object userId = request.getSession().getAttribute("userId");
        //获取到session中的用户权限
        Object role = request.getSession().getAttribute("role");
        //new一个会员课程信息表
        YuykechengxinxiEntity yuykechengxinxi = new YuykechengxinxiEntity();
        if(role.equals("管理员")){
            return R.error("管理大大不需要预约哦( •̀ ω •́ )✧");
        }
        //把会员id和前端传来的私教课程id放入，再new一个当前日期
        yuykechengxinxi.setHyidTypes((Integer) userId);
        yuykechengxinxi.setSjidTypes(ids);
        yuykechengxinxi.setCreateTime(new Date());
        //判断点击预约按钮的人是不是会员
        if(StringUtils.isNotBlank(role.toString()) && role.equals("会员")){
            //判断数据库中有没有重复的数据
            Wrapper<YuykechengxinxiEntity> queryWrapper = new EntityWrapper<YuykechengxinxiEntity>()
                    .eq("sjidTypes", yuykechengxinxi.getSjidTypes())
                    .eq("hyidTypes", yuykechengxinxi.getHyidTypes());
            logger.info("sql语句:"+queryWrapper.getSqlSegment());
            YuykechengxinxiEntity yuykechengxinxiEntity = yuykechengxinxiService.selectOne(queryWrapper);
            //数据库中没有重复数据再进行后续操作
            if(yuykechengxinxiEntity==null){
                //通过会员id和私教课程id获取到数据
                HuiyuanxinxiEntity huiyuanxinxiEntity = huiyuanxinxiService.selectById(yuykechengxinxi.getHyidTypes());
                SijiaokechengxinxiEntity sijiaokechengxinxiEntity = sijiaokechengxinxiService.selectById(yuykechengxinxi.getSjidTypes());
                //获取到会员的余额和私教课程的金额
                Double balance = huiyuanxinxiEntity.getBalance();
                Double cost = sijiaokechengxinxiEntity.getCost();
                //用会员余额减去私教金额
                Double qian = balance - cost;
                //判断得到的余额是否大于0，防止为会员余额为复数
                if(qian >= 0){
                    //把会员余额重新赋值
                    huiyuanxinxiEntity.setBalance(qian);
                    //进行修改
                    huiyuanxinxiService.updateById(huiyuanxinxiEntity);
                    //新增数据到数据库
                    yuykechengxinxiService.insert(yuykechengxinxi);
                    //提升用户预约成功
                    return R.ok("预约成功φ(*￣0￣)");
                }else{
                    //如果不大于0，直接返回错误信息
                    return R.error("亲，您余额不足，请请充值后再来预约！");
                }
            }else {
                //提升用户已经预约过了
                return R.error("亲，您已经预约过了，请不要重复预约！");
            }
        }
        //提示只能是会员才可以进行预约操作
        return R.error("亲，只有会员才可以预约哦(～￣▽￣)～");
    }
}


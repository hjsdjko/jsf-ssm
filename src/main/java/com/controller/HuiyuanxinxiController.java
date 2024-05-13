package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.annotation.IgnoreAuth;
import com.entity.HuiyuankaleixingEntity;
import com.entity.HuiyuanxinxiEntity;
import com.entity.UserEntity;
import com.service.HuiyuankaleixingService;
import com.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.HuiyuanxinxiEntity;

import com.service.HuiyuanxinxiService;
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
@RequestMapping("/huiyuanxinxi")
public class HuiyuanxinxiController {
    private static final Logger logger = LoggerFactory.getLogger(HuiyuanxinxiController.class);

    @Autowired
    private HuiyuanxinxiService huiyuanxinxiService;

    @Autowired
    private HuiyuankaleixingService huiyuankaleixingService;

    @Autowired
    private TokenService tokenService;

    /**
     * 登录
     */
    @IgnoreAuth
    @PostMapping(value = "/login")
    public R login(String username, String password, String role, HttpServletRequest request) {
        HuiyuanxinxiEntity user = huiyuanxinxiService.selectOne(new EntityWrapper<HuiyuanxinxiEntity>().eq("account", username));
        if(user == null){
            return R.error("您没有此权限或账号或密码不正确");
        }
        if(!user.getRole().equals(role)){
            return R.error("您没有此权限");
        }
        if(user==null || !user.getPassword().equals(password)) {
            return R.error("账号或密码不正确");
        }
        String token = tokenService.generateToken(user.getId(),username, "huiyuanxinxi", user.getRole());
        return R.ok().put("token", token);
    }

    /**
     * 注册
     */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody HuiyuanxinxiEntity user){
//    	ValidatorUtils.validateEntity(user);
        if(huiyuanxinxiService.selectOne(new EntityWrapper<HuiyuanxinxiEntity>().eq("username", user.getHyname()).eq("role",user.getRole())) != null) {
            return R.error("用户已存在");
        }
        huiyuanxinxiService.insert(user);
        return R.ok();
    }

    /**
     * 退出
     */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }

    /**
     * 密码重置
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
        HuiyuanxinxiEntity user = huiyuanxinxiService.selectOne(new EntityWrapper<HuiyuanxinxiEntity>().eq("username", username));
        if(user==null) {
            return R.error("账号不存在");
        }
        user.setPassword("123456");
        huiyuanxinxiService.update(user,null);
        return R.ok("密码已重置为：123456");
    }

    /**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
        Integer id = (Integer) request.getSession().getAttribute("userId");
        HuiyuanxinxiEntity user = huiyuanxinxiService.selectById(id);
        return R.ok().put("data", user);
    }

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        params.put("userId",request.getSession().getAttribute("userId"));
        params.put("role",request.getSession().getAttribute("role"));
        PageUtils page = huiyuanxinxiService.queryPage(params);
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        HuiyuanxinxiEntity huiyuanxinxi = huiyuanxinxiService.selectById(id);
        if(huiyuanxinxi!=null){
            return R.ok().put("data", huiyuanxinxi);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody HuiyuanxinxiEntity huiyuanxinxi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<HuiyuanxinxiEntity> queryWrapper = new EntityWrapper<HuiyuanxinxiEntity>()
            .eq("hyname", huiyuanxinxi.getHyname())
            .eq("account", huiyuanxinxi.getAccount());
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        huiyuanxinxi.setRole("会员");
        HuiyuanxinxiEntity huiyuanxinxiEntity = huiyuanxinxiService.selectOne(queryWrapper);
        if(huiyuanxinxiEntity==null){
            huiyuanxinxi.setId((int) (new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue()));
            huiyuanxinxiService.insert(huiyuanxinxi);
            return R.ok();
        }else {
            return R.error(511,"输入信息重复请重新输入");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HuiyuanxinxiEntity huiyuanxinxi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<HuiyuanxinxiEntity> queryWrapper = new EntityWrapper<HuiyuanxinxiEntity>()
            .notIn("id",huiyuanxinxi.getId())
            .eq("hyname", huiyuanxinxi.getHyname())
            .eq("account", huiyuanxinxi.getAccount());
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuiyuanxinxiEntity huiyuanxinxiEntity = huiyuanxinxiService.selectOne(queryWrapper);
        //根据id获取数据库信息
        HuiyuanxinxiEntity huiyuanxinxiEntity1 = huiyuanxinxiService.selectById(huiyuanxinxi.getId());
        //判断用户选的值是否和原来的一样
        if(huiyuanxinxiEntity1.getHykTypes() != huiyuanxinxi.getHykTypes()){
            //根据用户选的值去查询
            HuiyuankaleixingEntity huiyuankaleixingEntity = huiyuankaleixingService.selectById(huiyuanxinxi.getHykTypes());
            if(huiyuanxinxi.getBalance() <= 0){
                return R.error(511,"金额不足，请充值");
            }
            //将查询出来的会员卡的金额减去用户的余额
            Double balance = huiyuanxinxi.getBalance()-huiyuankaleixingEntity.getCost();
            //判断减完后数字是否大于0
            if(balance >= 0){
                //将减完的数字进行覆盖
                huiyuanxinxi.setBalance(balance);
            }else{
                //如果余额不足返回前端
                return R.error(511,"金额不足不能修改会员卡类型，请充值");
            }
        }
        if(huiyuanxinxiEntity==null){
            //进行修改
            huiyuanxinxiService.updateById(huiyuanxinxi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"输入信息重复请重新输入");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        huiyuanxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}


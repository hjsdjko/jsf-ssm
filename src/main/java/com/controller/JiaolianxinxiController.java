package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.annotation.IgnoreAuth;
import com.entity.HuiyuanxinxiEntity;
import com.entity.UserEntity;
import com.service.TokenService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.JiaolianxinxiEntity;

import com.service.JiaolianxinxiService;
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
@RequestMapping("/jiaolianxinxi")
public class JiaolianxinxiController {
    private static final Logger logger = LoggerFactory.getLogger(JiaolianxinxiController.class);

    @Autowired
    private JiaolianxinxiService jiaolianxinxiService;

    @Autowired
    private TokenService tokenService;

    /**
     * 登录
     */
    @IgnoreAuth
    @PostMapping(value = "/login")
    public R login(String username, String password, String role, HttpServletRequest request) {
        JiaolianxinxiEntity user = jiaolianxinxiService.selectOne(new EntityWrapper<JiaolianxinxiEntity>().eq("account", username));
        if(user == null){
            return R.error("您没有此权限或账号或密码不正确");
        }
        if(!user.getRole().equals(role)){
            return R.error("您没有此权限");
        }
        if(user==null || !user.getPassword().equals(password)) {
            return R.error("账号或密码不正确");
        }
        String token = tokenService.generateToken(user.getId(),username, "jiaolianxinxi", user.getRole());
        return R.ok().put("token", token);
    }

    /**
     * 注册
     */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody JiaolianxinxiEntity user){
//    	ValidatorUtils.validateEntity(user);
        if(jiaolianxinxiService.selectOne(new EntityWrapper<JiaolianxinxiEntity>().eq("username", user.getJlname()).eq("role",user.getRole())) != null) {
            return R.error("用户已存在");
        }
        jiaolianxinxiService.insert(user);
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
        JiaolianxinxiEntity user = jiaolianxinxiService.selectOne(new EntityWrapper<JiaolianxinxiEntity>().eq("username", username));
        if(user==null) {
            return R.error("账号不存在");
        }
        user.setPassword("123456");
        jiaolianxinxiService.update(user,null);
        return R.ok("密码已重置为：123456");
    }

    /**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
        Integer id = (Integer) request.getSession().getAttribute("userId");
        JiaolianxinxiEntity user = jiaolianxinxiService.selectById(id);
        return R.ok().put("data", user);
    }

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        params.put("userId",request.getSession().getAttribute("userId"));
        params.put("role",request.getSession().getAttribute("role"));
        PageUtils page = jiaolianxinxiService.queryPage(params);
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        JiaolianxinxiEntity jiaolianxinxi = jiaolianxinxiService.selectById(id);
        if(jiaolianxinxi!=null){
            return R.ok().put("data", jiaolianxinxi);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JiaolianxinxiEntity jiaolianxinxi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<JiaolianxinxiEntity> queryWrapper = new EntityWrapper<JiaolianxinxiEntity>()
            .eq("jlname", jiaolianxinxi.getJlname())
            .eq("account", jiaolianxinxi.getAccount());
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        jiaolianxinxi.setRole("教练");
        jiaolianxinxi.setCreateTime(new Date());
        JiaolianxinxiEntity jiaolianxinxiEntity = jiaolianxinxiService.selectOne(queryWrapper);
        if(jiaolianxinxiEntity==null){
            jiaolianxinxi.setId((int) (new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue()));
            jiaolianxinxiService.insert(jiaolianxinxi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiaolianxinxiEntity jiaolianxinxi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<JiaolianxinxiEntity> queryWrapper = new EntityWrapper<JiaolianxinxiEntity>()
            .notIn("id",jiaolianxinxi.getId())
            .eq("jlname", jiaolianxinxi.getJlname())
            .eq("account", jiaolianxinxi.getAccount());
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaolianxinxiEntity jiaolianxinxiEntity = jiaolianxinxiService.selectOne(queryWrapper);
        if(jiaolianxinxiEntity==null){
            jiaolianxinxiService.updateById(jiaolianxinxi);//根据id更新
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
        jiaolianxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}


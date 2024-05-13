package com.entity.model;

import com.entity.HuiyuankaleixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-01-26
 */
public class HuiyuankaleixingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * id
     */

    private Integer id;


    /**
     * 会员卡名称
     */

    private String hykname;


    /**
     * 费用
     */

    private Double cost;


    /**
	 * 设置：id
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：id
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：会员卡名称
	 */
    public String getHykname() {
        return hykname;
    }


    /**
	 * 获取：会员卡名称
	 */

    public void setHykname(String hykname) {
        this.hykname = hykname;
    }
    /**
	 * 设置：费用
	 */
    public Double getCost() {
        return cost;
    }


    /**
	 * 获取：费用
	 */

    public void setCost(Double cost) {
        this.cost = cost;
    }

    }

package com.entity.vo;

import com.entity.HuiyuankaleixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-01-26
 */
@TableName("huiyuankaleixing")
public class HuiyuankaleixingVO implements Serializable {
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

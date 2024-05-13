package com.entity.vo;

import com.entity.SijiaokechengxinxiEntity;

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
@TableName("sijiaokechengxinxi")
public class SijiaokechengxinxiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * id
     */

    private Integer id;


    /**
     * 私教名称
     */

    private String sjname;


    /**
     * 课程时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    private Date courseTime;


    /**
     * 教程介绍
     */

    private String message;


    /**
     * 费用
     */

    private Double cost;


    /**
     * 负责教练
     */

    private Integer jlidTypes;


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
	 * 设置：私教名称
	 */
    public String getSjname() {
        return sjname;
    }


    /**
	 * 获取：私教名称
	 */

    public void setSjname(String sjname) {
        this.sjname = sjname;
    }
    /**
	 * 设置：课程时间
	 */
    public Date getCourseTime() {
        return courseTime;
    }


    /**
	 * 获取：课程时间
	 */

    public void setCourseTime(Date courseTime) {
        this.courseTime = courseTime;
    }
    /**
	 * 设置：教程介绍
	 */
    public String getMessage() {
        return message;
    }


    /**
	 * 获取：教程介绍
	 */

    public void setMessage(String message) {
        this.message = message;
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
    /**
	 * 设置：负责教练
	 */
    public Integer getJlidTypes() {
        return jlidTypes;
    }


    /**
	 * 获取：负责教练
	 */

    public void setJlidTypes(Integer jlidTypes) {
        this.jlidTypes = jlidTypes;
    }

}

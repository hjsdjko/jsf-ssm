package com.entity.model;

import com.entity.SijiaokechengxinxiEntity;

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
public class SijiaokechengxinxiModel implements Serializable {
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

    private Date time;


    /**
     * 教程介绍
     */

    private String sjmessage;


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
    public Date getTime() {
        return time;
    }


    /**
	 * 获取：课程时间
	 */

    public void setTime(Date time) {
        this.time = time;
    }
    /**
	 * 设置：教程介绍
	 */
    public String getSjmessage() {
        return sjmessage;
    }


    /**
	 * 获取：教程介绍
	 */

    public void setSjmessage(String sjmessage) {
        this.sjmessage = sjmessage;
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

package com.entity.model;

import com.entity.YuykechengxinxiEntity;

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
public class YuykechengxinxiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * id
     */

    private Integer id;


    /**
     * 预约的私教课程
     */

    private Integer sjidTypes;


    /**
     * 会员id
     */

    private Integer hyidTypes;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    private Date createTime;


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
	 * 设置：预约的私教课程
	 */
    public Integer getSjidTypes() {
        return sjidTypes;
    }


    /**
	 * 获取：预约的私教课程
	 */

    public void setSjidTypes(Integer sjidTypes) {
        this.sjidTypes = sjidTypes;
    }
    /**
	 * 设置：会员id
	 */
    public Integer getHyidTypes() {
        return hyidTypes;
    }


    /**
	 * 获取：会员id
	 */

    public void setHyidTypes(Integer hyidTypes) {
        this.hyidTypes = hyidTypes;
    }
    /**
	 * 设置：预约时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：预约时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

package com.entity.model;

import com.entity.HuiyuankaxinxiEntity;

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
public class HuiyuankaxinxiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 
     */

    private Integer id;


    /**
     * 用户id
     */

    private Integer hyidTypes;


    /**
     * 会员卡类型
     */

    private Integer huTypes;


    /**
     * 购买时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    private Date createTime;


    /**
     * 到期时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    private Date expireTime;


    /**
	 * 设置：
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户id
	 */
    public Integer getHyidTypes() {
        return hyidTypes;
    }


    /**
	 * 获取：用户id
	 */

    public void setHyidTypes(Integer hyidTypes) {
        this.hyidTypes = hyidTypes;
    }
    /**
	 * 设置：会员卡类型
	 */
    public Integer getHuTypes() {
        return huTypes;
    }


    /**
	 * 获取：会员卡类型
	 */

    public void setHuTypes(Integer huTypes) {
        this.huTypes = huTypes;
    }
    /**
	 * 设置：购买时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：购买时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
	 * 设置：到期时间
	 */
    public Date getExpireTime() {
        return expireTime;
    }


    /**
	 * 获取：到期时间
	 */

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    }

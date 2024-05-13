package com.entity.vo;

import com.entity.JianshenfangxinxiEntity;

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
@TableName("jianshenfangxinxi")
public class JianshenfangxinxiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * id
     */

    private Integer id;


    /**
     * 健身区域名称
     */

    private String jsfname;


    /**
     * 健身房信息
     */

    private String jsfmessage;


    /**
     * 健身房图片 
     */

    private String jsfPhoto;


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
	 * 设置：健身区域名称
	 */
    public String getJsfname() {
        return jsfname;
    }


    /**
	 * 获取：健身区域名称
	 */

    public void setJsfname(String jsfname) {
        this.jsfname = jsfname;
    }
    /**
	 * 设置：健身房信息
	 */
    public String getJsfmessage() {
        return jsfmessage;
    }


    /**
	 * 获取：健身房信息
	 */

    public void setJsfmessage(String jsfmessage) {
        this.jsfmessage = jsfmessage;
    }
    /**
	 * 设置：健身房图片 
	 */
    public String getJsfPhoto() {
        return jsfPhoto;
    }


    /**
	 * 获取：健身房图片 
	 */

    public void setJsfPhoto(String jsfPhoto) {
        this.jsfPhoto = jsfPhoto;
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

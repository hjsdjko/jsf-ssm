package com.entity.vo;

import com.entity.JianshenqicaixinxiEntity;

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
@TableName("jianshenqicaixinxi")
public class JianshenqicaixinxiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * id
     */

    private Integer id;


    /**
     * 健身器材名称
     */

    private String qcname;


    /**
     * 健身器材信息
     */

    private String message;


    /**
     * 器材个数
     */

    private Integer number;


    /**
     * 器材类型（1、健身器材1，2、健身器材2,3、健身器材3）
     */

    private Integer qcTypes;


    /**
     * 创建时间
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
	 * 设置：健身器材名称
	 */
    public String getQcname() {
        return qcname;
    }


    /**
	 * 获取：健身器材名称
	 */

    public void setQcname(String qcname) {
        this.qcname = qcname;
    }
    /**
	 * 设置：健身器材信息
	 */
    public String getMessage() {
        return message;
    }


    /**
	 * 获取：健身器材信息
	 */

    public void setMessage(String message) {
        this.message = message;
    }
    /**
	 * 设置：器材个数
	 */
    public Integer getNumber() {
        return number;
    }


    /**
	 * 获取：器材个数
	 */

    public void setNumber(Integer number) {
        this.number = number;
    }
    /**
	 * 设置：器材类型（1、健身器材1，2、健身器材2,3、健身器材3）
	 */
    public Integer getQcTypes() {
        return qcTypes;
    }


    /**
	 * 获取：器材类型（1、健身器材1，2、健身器材2,3、健身器材3）
	 */

    public void setQcTypes(Integer qcTypes) {
        this.qcTypes = qcTypes;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

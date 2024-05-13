package com.entity.model;

import com.entity.JiaolianxinxiEntity;

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
public class JiaolianxinxiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * id
     */

    private Integer id;


    /**
     * 教练名称
     */

    private String jlname;


    /**
     * 
     */

    private String account;


    /**
     * 
     */

    private String password;


    /**
     * 身份
     */

    private String role;


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
	 * 设置：教练名称
	 */
    public String getJlname() {
        return jlname;
    }


    /**
	 * 获取：教练名称
	 */

    public void setJlname(String jlname) {
        this.jlname = jlname;
    }
    /**
	 * 设置：
	 */
    public String getAccount() {
        return account;
    }


    /**
	 * 获取：
	 */

    public void setAccount(String account) {
        this.account = account;
    }
    /**
	 * 设置：
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：身份
	 */
    public String getRole() {
        return role;
    }


    /**
	 * 获取：身份
	 */

    public void setRole(String role) {
        this.role = role;
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

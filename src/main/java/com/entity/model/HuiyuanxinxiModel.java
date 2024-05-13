package com.entity.model;

import com.entity.HuiyuanxinxiEntity;

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
public class HuiyuanxinxiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * id
     */

    private Integer id;


    /**
     * 会员名称
     */

    private String hyname;


    /**
     * 账号
     */

    private String account;


    /**
     * 密码
     */

    private String password;


    /**
     * 头像
     */

    private String imgPhoto;


    /**
     * 性别（1、男，2、女）
     */

    private Integer sexTypes;


    /**
     * 余额
     */

    private Double balance;


    /**
     * 身份
     */

    private String role;


    /**
     * 会员卡信息
     */

    private Integer hykTypes;


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
	 * 设置：会员名称
	 */
    public String getHyname() {
        return hyname;
    }


    /**
	 * 获取：会员名称
	 */

    public void setHyname(String hyname) {
        this.hyname = hyname;
    }
    /**
	 * 设置：账号
	 */
    public String getAccount() {
        return account;
    }


    /**
	 * 获取：账号
	 */

    public void setAccount(String account) {
        this.account = account;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：头像
	 */
    public String getImgPhoto() {
        return imgPhoto;
    }


    /**
	 * 获取：头像
	 */

    public void setImgPhoto(String imgPhoto) {
        this.imgPhoto = imgPhoto;
    }
    /**
	 * 设置：性别（1、男，2、女）
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别（1、男，2、女）
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：余额
	 */
    public Double getBalance() {
        return balance;
    }


    /**
	 * 获取：余额
	 */

    public void setBalance(Double balance) {
        this.balance = balance;
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
	 * 设置：会员卡信息
	 */
    public Integer getHykTypes() {
        return hykTypes;
    }


    /**
	 * 获取：会员卡信息
	 */

    public void setHykTypes(Integer hykTypes) {
        this.hykTypes = hykTypes;
    }

    }

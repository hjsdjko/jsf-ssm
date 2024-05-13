package com.entity.model;

import com.entity.KechengxinxiEntity;

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
public class KechengxinxiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * id
     */

    private Integer id;


    /**
     * 星期日期（星期1-星期天）
     */

    private Integer weekTypes;


    /**
     * 课程时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    private Date time;


    /**
     * 课程内容
     */

    private String kcname;


    /**
     * 课程信息
     */

    private String message;


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
	 * 设置：星期日期（星期1-星期天）
	 */
    public Integer getWeekTypes() {
        return weekTypes;
    }


    /**
	 * 获取：星期日期（星期1-星期天）
	 */

    public void setWeekTypes(Integer weekTypes) {
        this.weekTypes = weekTypes;
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
	 * 设置：课程内容
	 */
    public String getKcname() {
        return kcname;
    }


    /**
	 * 获取：课程内容
	 */

    public void setKcname(String kcname) {
        this.kcname = kcname;
    }
    /**
	 * 设置：课程信息
	 */
    public String getMessage() {
        return message;
    }


    /**
	 * 获取：课程信息
	 */

    public void setMessage(String message) {
        this.message = message;
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

package com.entity.model;

import com.entity.WuliuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 物流记录
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WuliuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 货运单
     */
    private Integer huoyunId;


    /**
     * 员工
     */
    private Integer yuangongId;


    /**
     * 物流编号
     */
    private String wuliuUuidNumber;


    /**
     * 物流标题
     */
    private String wuliuName;


    /**
     * 物流状态
     */
    private Integer wuliuTypes;


    /**
     * 仓库
     */
    private Integer cangkuTypes;


    /**
     * 物流详情
     */
    private String wuliuContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：货运单
	 */
    public Integer getHuoyunId() {
        return huoyunId;
    }


    /**
	 * 设置：货运单
	 */
    public void setHuoyunId(Integer huoyunId) {
        this.huoyunId = huoyunId;
    }
    /**
	 * 获取：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 设置：员工
	 */
    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 获取：物流编号
	 */
    public String getWuliuUuidNumber() {
        return wuliuUuidNumber;
    }


    /**
	 * 设置：物流编号
	 */
    public void setWuliuUuidNumber(String wuliuUuidNumber) {
        this.wuliuUuidNumber = wuliuUuidNumber;
    }
    /**
	 * 获取：物流标题
	 */
    public String getWuliuName() {
        return wuliuName;
    }


    /**
	 * 设置：物流标题
	 */
    public void setWuliuName(String wuliuName) {
        this.wuliuName = wuliuName;
    }
    /**
	 * 获取：物流状态
	 */
    public Integer getWuliuTypes() {
        return wuliuTypes;
    }


    /**
	 * 设置：物流状态
	 */
    public void setWuliuTypes(Integer wuliuTypes) {
        this.wuliuTypes = wuliuTypes;
    }
    /**
	 * 获取：仓库
	 */
    public Integer getCangkuTypes() {
        return cangkuTypes;
    }


    /**
	 * 设置：仓库
	 */
    public void setCangkuTypes(Integer cangkuTypes) {
        this.cangkuTypes = cangkuTypes;
    }
    /**
	 * 获取：物流详情
	 */
    public String getWuliuContent() {
        return wuliuContent;
    }


    /**
	 * 设置：物流详情
	 */
    public void setWuliuContent(String wuliuContent) {
        this.wuliuContent = wuliuContent;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 物流记录
 *
 * @author 
 * @email
 */
@TableName("wuliu")
public class WuliuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WuliuEntity() {

	}

	public WuliuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 货运单
     */
    @ColumnInfo(comment="货运单",type="int(11)")
    @TableField(value = "huoyun_id")

    private Integer huoyunId;


    /**
     * 员工
     */
    @ColumnInfo(comment="员工",type="int(11)")
    @TableField(value = "yuangong_id")

    private Integer yuangongId;


    /**
     * 物流编号
     */
    @ColumnInfo(comment="物流编号",type="varchar(200)")
    @TableField(value = "wuliu_uuid_number")

    private String wuliuUuidNumber;


    /**
     * 物流标题
     */
    @ColumnInfo(comment="物流标题",type="varchar(200)")
    @TableField(value = "wuliu_name")

    private String wuliuName;


    /**
     * 物流状态
     */
    @ColumnInfo(comment="物流状态",type="int(11)")
    @TableField(value = "wuliu_types")

    private Integer wuliuTypes;


    /**
     * 仓库
     */
    @ColumnInfo(comment="仓库",type="int(11)")
    @TableField(value = "cangku_types")

    private Integer cangkuTypes;


    /**
     * 物流详情
     */
    @ColumnInfo(comment="物流详情",type="longtext")
    @TableField(value = "wuliu_content")

    private String wuliuContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间   listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间   listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间   listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Wuliu{" +
            ", id=" + id +
            ", huoyunId=" + huoyunId +
            ", yuangongId=" + yuangongId +
            ", wuliuUuidNumber=" + wuliuUuidNumber +
            ", wuliuName=" + wuliuName +
            ", wuliuTypes=" + wuliuTypes +
            ", cangkuTypes=" + cangkuTypes +
            ", wuliuContent=" + wuliuContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}

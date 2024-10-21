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
 * 货运单
 *
 * @author 
 * @email
 */
@TableName("huoyun")
public class HuoyunEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HuoyunEntity() {

	}

	public HuoyunEntity(T t) {
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
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 员工
     */
    @ColumnInfo(comment="员工",type="int(11)")
    @TableField(value = "yuangong_id")

    private Integer yuangongId;


    /**
     * 货运单编号
     */
    @ColumnInfo(comment="货运单编号",type="varchar(200)")
    @TableField(value = "huoyun_uuid_number")

    private String huoyunUuidNumber;


    /**
     * 货物名称
     */
    @ColumnInfo(comment="货物名称",type="varchar(200)")
    @TableField(value = "huoyun_name")

    private String huoyunName;


    /**
     * 货物照片
     */
    @ColumnInfo(comment="货物照片",type="varchar(200)")
    @TableField(value = "huoyun_photo")

    private String huoyunPhoto;


    /**
     * 出发地点
     */
    @ColumnInfo(comment="出发地点",type="varchar(200)")
    @TableField(value = "huoyun_chufa_address")

    private String huoyunChufaAddress;


    /**
     * 出发地联系人
     */
    @ColumnInfo(comment="出发地联系人",type="varchar(200)")
    @TableField(value = "huoyun_chufa_lianxiren")

    private String huoyunChufaLianxiren;


    /**
     * 出发地电话
     */
    @ColumnInfo(comment="出发地电话",type="varchar(200)")
    @TableField(value = "huoyun_chufa_dianhua")

    private String huoyunChufaDianhua;


    /**
     * 送达地点
     */
    @ColumnInfo(comment="送达地点",type="varchar(200)")
    @TableField(value = "huoyun_songda_address")

    private String huoyunSongdaAddress;


    /**
     * 抵达地联系人
     */
    @ColumnInfo(comment="抵达地联系人",type="varchar(200)")
    @TableField(value = "huoyun_songda_lianxiren")

    private String huoyunSongdaLianxiren;


    /**
     * 抵达地电话
     */
    @ColumnInfo(comment="抵达地电话",type="varchar(200)")
    @TableField(value = "huoyun_songda_dianhua")

    private String huoyunSongdaDianhua;


    /**
     * 货运单类型
     */
    @ColumnInfo(comment="货运单类型",type="int(11)")
    @TableField(value = "huoyun_types")

    private Integer huoyunTypes;


    /**
     * 运送数量
     */
    @ColumnInfo(comment="运送数量",type="int(11)")
    @TableField(value = "huoyun_number")

    private Integer huoyunNumber;


    /**
     * 单个长宽高
     */
    @ColumnInfo(comment="单个长宽高",type="varchar(200)")
    @TableField(value = "huoyun_dan_changkuangao")

    private String huoyunDanChangkuangao;


    /**
     * 总长宽高
     */
    @ColumnInfo(comment="总长宽高",type="varchar(200)")
    @TableField(value = "huoyun_zong_changkuangao")

    private String huoyunZongChangkuangao;


    /**
     * 总重量
     */
    @ColumnInfo(comment="总重量",type="decimal(10,2)")
    @TableField(value = "huoyun_zhongliang")

    private Double huoyunZhongliang;


    /**
     * 货运备注
     */
    @ColumnInfo(comment="货运备注",type="longtext")
    @TableField(value = "huoyun_content")

    private String huoyunContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="申请时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 申请状态
     */
    @ColumnInfo(comment="申请状态",type="int(11)")
    @TableField(value = "huoyun_yesno_types")

    private Integer huoyunYesnoTypes;


    /**
     * 审核意见
     */
    @ColumnInfo(comment="审核意见",type="longtext")
    @TableField(value = "huoyun_yesno_text")

    private String huoyunYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "huoyun_shenhe_time")

    private Date huoyunShenheTime;


    /**
     * 货运金额
     */
    @ColumnInfo(comment="货运金额",type="decimal(10,2)")
    @TableField(value = "huoyun_jine")

    private Double huoyunJine;


    /**
     * 是否支付
     */
    @ColumnInfo(comment="是否支付",type="int(11)")
    @TableField(value = "huoyun_zhifu_types")

    private Integer huoyunZhifuTypes;


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
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
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
	 * 获取：货运单编号
	 */
    public String getHuoyunUuidNumber() {
        return huoyunUuidNumber;
    }
    /**
	 * 设置：货运单编号
	 */

    public void setHuoyunUuidNumber(String huoyunUuidNumber) {
        this.huoyunUuidNumber = huoyunUuidNumber;
    }
    /**
	 * 获取：货物名称
	 */
    public String getHuoyunName() {
        return huoyunName;
    }
    /**
	 * 设置：货物名称
	 */

    public void setHuoyunName(String huoyunName) {
        this.huoyunName = huoyunName;
    }
    /**
	 * 获取：货物照片
	 */
    public String getHuoyunPhoto() {
        return huoyunPhoto;
    }
    /**
	 * 设置：货物照片
	 */

    public void setHuoyunPhoto(String huoyunPhoto) {
        this.huoyunPhoto = huoyunPhoto;
    }
    /**
	 * 获取：出发地点
	 */
    public String getHuoyunChufaAddress() {
        return huoyunChufaAddress;
    }
    /**
	 * 设置：出发地点
	 */

    public void setHuoyunChufaAddress(String huoyunChufaAddress) {
        this.huoyunChufaAddress = huoyunChufaAddress;
    }
    /**
	 * 获取：出发地联系人
	 */
    public String getHuoyunChufaLianxiren() {
        return huoyunChufaLianxiren;
    }
    /**
	 * 设置：出发地联系人
	 */

    public void setHuoyunChufaLianxiren(String huoyunChufaLianxiren) {
        this.huoyunChufaLianxiren = huoyunChufaLianxiren;
    }
    /**
	 * 获取：出发地电话
	 */
    public String getHuoyunChufaDianhua() {
        return huoyunChufaDianhua;
    }
    /**
	 * 设置：出发地电话
	 */

    public void setHuoyunChufaDianhua(String huoyunChufaDianhua) {
        this.huoyunChufaDianhua = huoyunChufaDianhua;
    }
    /**
	 * 获取：送达地点
	 */
    public String getHuoyunSongdaAddress() {
        return huoyunSongdaAddress;
    }
    /**
	 * 设置：送达地点
	 */

    public void setHuoyunSongdaAddress(String huoyunSongdaAddress) {
        this.huoyunSongdaAddress = huoyunSongdaAddress;
    }
    /**
	 * 获取：抵达地联系人
	 */
    public String getHuoyunSongdaLianxiren() {
        return huoyunSongdaLianxiren;
    }
    /**
	 * 设置：抵达地联系人
	 */

    public void setHuoyunSongdaLianxiren(String huoyunSongdaLianxiren) {
        this.huoyunSongdaLianxiren = huoyunSongdaLianxiren;
    }
    /**
	 * 获取：抵达地电话
	 */
    public String getHuoyunSongdaDianhua() {
        return huoyunSongdaDianhua;
    }
    /**
	 * 设置：抵达地电话
	 */

    public void setHuoyunSongdaDianhua(String huoyunSongdaDianhua) {
        this.huoyunSongdaDianhua = huoyunSongdaDianhua;
    }
    /**
	 * 获取：货运单类型
	 */
    public Integer getHuoyunTypes() {
        return huoyunTypes;
    }
    /**
	 * 设置：货运单类型
	 */

    public void setHuoyunTypes(Integer huoyunTypes) {
        this.huoyunTypes = huoyunTypes;
    }
    /**
	 * 获取：运送数量
	 */
    public Integer getHuoyunNumber() {
        return huoyunNumber;
    }
    /**
	 * 设置：运送数量
	 */

    public void setHuoyunNumber(Integer huoyunNumber) {
        this.huoyunNumber = huoyunNumber;
    }
    /**
	 * 获取：单个长宽高
	 */
    public String getHuoyunDanChangkuangao() {
        return huoyunDanChangkuangao;
    }
    /**
	 * 设置：单个长宽高
	 */

    public void setHuoyunDanChangkuangao(String huoyunDanChangkuangao) {
        this.huoyunDanChangkuangao = huoyunDanChangkuangao;
    }
    /**
	 * 获取：总长宽高
	 */
    public String getHuoyunZongChangkuangao() {
        return huoyunZongChangkuangao;
    }
    /**
	 * 设置：总长宽高
	 */

    public void setHuoyunZongChangkuangao(String huoyunZongChangkuangao) {
        this.huoyunZongChangkuangao = huoyunZongChangkuangao;
    }
    /**
	 * 获取：总重量
	 */
    public Double getHuoyunZhongliang() {
        return huoyunZhongliang;
    }
    /**
	 * 设置：总重量
	 */

    public void setHuoyunZhongliang(Double huoyunZhongliang) {
        this.huoyunZhongliang = huoyunZhongliang;
    }
    /**
	 * 获取：货运备注
	 */
    public String getHuoyunContent() {
        return huoyunContent;
    }
    /**
	 * 设置：货运备注
	 */

    public void setHuoyunContent(String huoyunContent) {
        this.huoyunContent = huoyunContent;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getHuoyunYesnoTypes() {
        return huoyunYesnoTypes;
    }
    /**
	 * 设置：申请状态
	 */

    public void setHuoyunYesnoTypes(Integer huoyunYesnoTypes) {
        this.huoyunYesnoTypes = huoyunYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getHuoyunYesnoText() {
        return huoyunYesnoText;
    }
    /**
	 * 设置：审核意见
	 */

    public void setHuoyunYesnoText(String huoyunYesnoText) {
        this.huoyunYesnoText = huoyunYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getHuoyunShenheTime() {
        return huoyunShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setHuoyunShenheTime(Date huoyunShenheTime) {
        this.huoyunShenheTime = huoyunShenheTime;
    }
    /**
	 * 获取：货运金额
	 */
    public Double getHuoyunJine() {
        return huoyunJine;
    }
    /**
	 * 设置：货运金额
	 */

    public void setHuoyunJine(Double huoyunJine) {
        this.huoyunJine = huoyunJine;
    }
    /**
	 * 获取：是否支付
	 */
    public Integer getHuoyunZhifuTypes() {
        return huoyunZhifuTypes;
    }
    /**
	 * 设置：是否支付
	 */

    public void setHuoyunZhifuTypes(Integer huoyunZhifuTypes) {
        this.huoyunZhifuTypes = huoyunZhifuTypes;
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
        return "Huoyun{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", yuangongId=" + yuangongId +
            ", huoyunUuidNumber=" + huoyunUuidNumber +
            ", huoyunName=" + huoyunName +
            ", huoyunPhoto=" + huoyunPhoto +
            ", huoyunChufaAddress=" + huoyunChufaAddress +
            ", huoyunChufaLianxiren=" + huoyunChufaLianxiren +
            ", huoyunChufaDianhua=" + huoyunChufaDianhua +
            ", huoyunSongdaAddress=" + huoyunSongdaAddress +
            ", huoyunSongdaLianxiren=" + huoyunSongdaLianxiren +
            ", huoyunSongdaDianhua=" + huoyunSongdaDianhua +
            ", huoyunTypes=" + huoyunTypes +
            ", huoyunNumber=" + huoyunNumber +
            ", huoyunDanChangkuangao=" + huoyunDanChangkuangao +
            ", huoyunZongChangkuangao=" + huoyunZongChangkuangao +
            ", huoyunZhongliang=" + huoyunZhongliang +
            ", huoyunContent=" + huoyunContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", huoyunYesnoTypes=" + huoyunYesnoTypes +
            ", huoyunYesnoText=" + huoyunYesnoText +
            ", huoyunShenheTime=" + DateUtil.convertString(huoyunShenheTime,"yyyy-MM-dd") +
            ", huoyunJine=" + huoyunJine +
            ", huoyunZhifuTypes=" + huoyunZhifuTypes +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}

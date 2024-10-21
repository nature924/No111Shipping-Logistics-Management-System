package com.entity.vo;

import com.entity.WuliuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 物流记录
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wuliu")
public class WuliuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 货运单
     */

    @TableField(value = "huoyun_id")
    private Integer huoyunId;


    /**
     * 员工
     */

    @TableField(value = "yuangong_id")
    private Integer yuangongId;


    /**
     * 物流编号
     */

    @TableField(value = "wuliu_uuid_number")
    private String wuliuUuidNumber;


    /**
     * 物流标题
     */

    @TableField(value = "wuliu_name")
    private String wuliuName;


    /**
     * 物流状态
     */

    @TableField(value = "wuliu_types")
    private Integer wuliuTypes;


    /**
     * 仓库
     */

    @TableField(value = "cangku_types")
    private Integer cangkuTypes;


    /**
     * 物流详情
     */

    @TableField(value = "wuliu_content")
    private String wuliuContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：货运单
	 */
    public Integer getHuoyunId() {
        return huoyunId;
    }


    /**
	 * 获取：货运单
	 */

    public void setHuoyunId(Integer huoyunId) {
        this.huoyunId = huoyunId;
    }
    /**
	 * 设置：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 获取：员工
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 设置：物流编号
	 */
    public String getWuliuUuidNumber() {
        return wuliuUuidNumber;
    }


    /**
	 * 获取：物流编号
	 */

    public void setWuliuUuidNumber(String wuliuUuidNumber) {
        this.wuliuUuidNumber = wuliuUuidNumber;
    }
    /**
	 * 设置：物流标题
	 */
    public String getWuliuName() {
        return wuliuName;
    }


    /**
	 * 获取：物流标题
	 */

    public void setWuliuName(String wuliuName) {
        this.wuliuName = wuliuName;
    }
    /**
	 * 设置：物流状态
	 */
    public Integer getWuliuTypes() {
        return wuliuTypes;
    }


    /**
	 * 获取：物流状态
	 */

    public void setWuliuTypes(Integer wuliuTypes) {
        this.wuliuTypes = wuliuTypes;
    }
    /**
	 * 设置：仓库
	 */
    public Integer getCangkuTypes() {
        return cangkuTypes;
    }


    /**
	 * 获取：仓库
	 */

    public void setCangkuTypes(Integer cangkuTypes) {
        this.cangkuTypes = cangkuTypes;
    }
    /**
	 * 设置：物流详情
	 */
    public String getWuliuContent() {
        return wuliuContent;
    }


    /**
	 * 获取：物流详情
	 */

    public void setWuliuContent(String wuliuContent) {
        this.wuliuContent = wuliuContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

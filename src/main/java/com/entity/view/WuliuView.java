package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.WuliuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 物流记录
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("wuliu")
public class WuliuView extends WuliuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 物流状态的值
	*/
	@ColumnInfo(comment="物流状态的字典表值",type="varchar(200)")
	private String wuliuValue;
	/**
	* 仓库的值
	*/
	@ColumnInfo(comment="仓库的字典表值",type="varchar(200)")
	private String cangkuValue;

	//级联表 货运单
					 
		/**
		* 货运单 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer huoyunYonghuId;
					 
		/**
		* 货运单 的 员工
		*/
		@ColumnInfo(comment="员工",type="int(11)")
		private Integer huoyunYuangongId;
		/**
		* 货运单编号
		*/

		@ColumnInfo(comment="货运单编号",type="varchar(200)")
		private String huoyunUuidNumber;
		/**
		* 货物名称
		*/

		@ColumnInfo(comment="货物名称",type="varchar(200)")
		private String huoyunName;
		/**
		* 货物照片
		*/

		@ColumnInfo(comment="货物照片",type="varchar(200)")
		private String huoyunPhoto;
		/**
		* 出发地点
		*/

		@ColumnInfo(comment="出发地点",type="varchar(200)")
		private String huoyunChufaAddress;
		/**
		* 出发地联系人
		*/

		@ColumnInfo(comment="出发地联系人",type="varchar(200)")
		private String huoyunChufaLianxiren;
		/**
		* 出发地电话
		*/

		@ColumnInfo(comment="出发地电话",type="varchar(200)")
		private String huoyunChufaDianhua;
		/**
		* 送达地点
		*/

		@ColumnInfo(comment="送达地点",type="varchar(200)")
		private String huoyunSongdaAddress;
		/**
		* 抵达地联系人
		*/

		@ColumnInfo(comment="抵达地联系人",type="varchar(200)")
		private String huoyunSongdaLianxiren;
		/**
		* 抵达地电话
		*/

		@ColumnInfo(comment="抵达地电话",type="varchar(200)")
		private String huoyunSongdaDianhua;
		/**
		* 货运单类型
		*/
		@ColumnInfo(comment="货运单类型",type="int(11)")
		private Integer huoyunTypes;
			/**
			* 货运单类型的值
			*/
			@ColumnInfo(comment="货运单类型的字典表值",type="varchar(200)")
			private String huoyunValue;
		/**
		* 运送数量
		*/

		@ColumnInfo(comment="运送数量",type="int(11)")
		private Integer huoyunNumber;
		/**
		* 单个长宽高
		*/

		@ColumnInfo(comment="单个长宽高",type="varchar(200)")
		private String huoyunDanChangkuangao;
		/**
		* 总长宽高
		*/

		@ColumnInfo(comment="总长宽高",type="varchar(200)")
		private String huoyunZongChangkuangao;
		/**
		* 总重量
		*/
		@ColumnInfo(comment="总重量",type="decimal(10,2)")
		private Double huoyunZhongliang;
		/**
		* 货运备注
		*/

		@ColumnInfo(comment="货运备注",type="longtext")
		private String huoyunContent;
		/**
		* 申请状态
		*/
		@ColumnInfo(comment="申请状态",type="int(11)")
		private Integer huoyunYesnoTypes;
			/**
			* 申请状态的值
			*/
			@ColumnInfo(comment="申请状态的字典表值",type="varchar(200)")
			private String huoyunYesnoValue;
		/**
		* 审核意见
		*/

		@ColumnInfo(comment="审核意见",type="longtext")
		private String huoyunYesnoText;
		/**
		* 审核时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="审核时间",type="timestamp")
		private Date huoyunShenheTime;
		/**
		* 货运金额
		*/
		@ColumnInfo(comment="货运金额",type="decimal(10,2)")
		private Double huoyunJine;
		/**
		* 是否支付
		*/
		@ColumnInfo(comment="是否支付",type="int(11)")
		private Integer huoyunZhifuTypes;
			/**
			* 是否支付的值
			*/
			@ColumnInfo(comment="是否支付的字典表值",type="varchar(200)")
			private String huoyunZhifuValue;
	//级联表 员工
		/**
		* 工号
		*/

		@ColumnInfo(comment="工号",type="varchar(200)")
		private String yuangongUuidNumber;
		/**
		* 员工姓名
		*/

		@ColumnInfo(comment="员工姓名",type="varchar(200)")
		private String yuangongName;
		/**
		* 员工手机号
		*/

		@ColumnInfo(comment="员工手机号",type="varchar(200)")
		private String yuangongPhone;
		/**
		* 员工身份证号
		*/

		@ColumnInfo(comment="员工身份证号",type="varchar(200)")
		private String yuangongIdNumber;
		/**
		* 员工头像
		*/

		@ColumnInfo(comment="员工头像",type="varchar(200)")
		private String yuangongPhoto;
		/**
		* 员工邮箱
		*/

		@ColumnInfo(comment="员工邮箱",type="varchar(200)")
		private String yuangongEmail;
		/**
		* 账户状态
		*/
		@ColumnInfo(comment="账户状态",type="int(11)")
		private Integer jinyongTypes;
			/**
			* 账户状态的值
			*/
			@ColumnInfo(comment="账户状态的字典表值",type="varchar(200)")
			private String jinyongValue;



	public WuliuView() {

	}

	public WuliuView(WuliuEntity wuliuEntity) {
		try {
			BeanUtils.copyProperties(this, wuliuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 物流状态的值
	*/
	public String getWuliuValue() {
		return wuliuValue;
	}
	/**
	* 设置： 物流状态的值
	*/
	public void setWuliuValue(String wuliuValue) {
		this.wuliuValue = wuliuValue;
	}
	//当前表的
	/**
	* 获取： 仓库的值
	*/
	public String getCangkuValue() {
		return cangkuValue;
	}
	/**
	* 设置： 仓库的值
	*/
	public void setCangkuValue(String cangkuValue) {
		this.cangkuValue = cangkuValue;
	}


	//级联表的get和set 货运单
		/**
		* 获取：货运单 的 用户
		*/
		public Integer getHuoyunYonghuId() {
			return huoyunYonghuId;
		}
		/**
		* 设置：货运单 的 用户
		*/
		public void setHuoyunYonghuId(Integer huoyunYonghuId) {
			this.huoyunYonghuId = huoyunYonghuId;
		}
		/**
		* 获取：货运单 的 员工
		*/
		public Integer getHuoyunYuangongId() {
			return huoyunYuangongId;
		}
		/**
		* 设置：货运单 的 员工
		*/
		public void setHuoyunYuangongId(Integer huoyunYuangongId) {
			this.huoyunYuangongId = huoyunYuangongId;
		}

		/**
		* 获取： 货运单编号
		*/
		public String getHuoyunUuidNumber() {
			return huoyunUuidNumber;
		}
		/**
		* 设置： 货运单编号
		*/
		public void setHuoyunUuidNumber(String huoyunUuidNumber) {
			this.huoyunUuidNumber = huoyunUuidNumber;
		}

		/**
		* 获取： 货物名称
		*/
		public String getHuoyunName() {
			return huoyunName;
		}
		/**
		* 设置： 货物名称
		*/
		public void setHuoyunName(String huoyunName) {
			this.huoyunName = huoyunName;
		}

		/**
		* 获取： 货物照片
		*/
		public String getHuoyunPhoto() {
			return huoyunPhoto;
		}
		/**
		* 设置： 货物照片
		*/
		public void setHuoyunPhoto(String huoyunPhoto) {
			this.huoyunPhoto = huoyunPhoto;
		}

		/**
		* 获取： 出发地点
		*/
		public String getHuoyunChufaAddress() {
			return huoyunChufaAddress;
		}
		/**
		* 设置： 出发地点
		*/
		public void setHuoyunChufaAddress(String huoyunChufaAddress) {
			this.huoyunChufaAddress = huoyunChufaAddress;
		}

		/**
		* 获取： 出发地联系人
		*/
		public String getHuoyunChufaLianxiren() {
			return huoyunChufaLianxiren;
		}
		/**
		* 设置： 出发地联系人
		*/
		public void setHuoyunChufaLianxiren(String huoyunChufaLianxiren) {
			this.huoyunChufaLianxiren = huoyunChufaLianxiren;
		}

		/**
		* 获取： 出发地电话
		*/
		public String getHuoyunChufaDianhua() {
			return huoyunChufaDianhua;
		}
		/**
		* 设置： 出发地电话
		*/
		public void setHuoyunChufaDianhua(String huoyunChufaDianhua) {
			this.huoyunChufaDianhua = huoyunChufaDianhua;
		}

		/**
		* 获取： 送达地点
		*/
		public String getHuoyunSongdaAddress() {
			return huoyunSongdaAddress;
		}
		/**
		* 设置： 送达地点
		*/
		public void setHuoyunSongdaAddress(String huoyunSongdaAddress) {
			this.huoyunSongdaAddress = huoyunSongdaAddress;
		}

		/**
		* 获取： 抵达地联系人
		*/
		public String getHuoyunSongdaLianxiren() {
			return huoyunSongdaLianxiren;
		}
		/**
		* 设置： 抵达地联系人
		*/
		public void setHuoyunSongdaLianxiren(String huoyunSongdaLianxiren) {
			this.huoyunSongdaLianxiren = huoyunSongdaLianxiren;
		}

		/**
		* 获取： 抵达地电话
		*/
		public String getHuoyunSongdaDianhua() {
			return huoyunSongdaDianhua;
		}
		/**
		* 设置： 抵达地电话
		*/
		public void setHuoyunSongdaDianhua(String huoyunSongdaDianhua) {
			this.huoyunSongdaDianhua = huoyunSongdaDianhua;
		}
		/**
		* 获取： 货运单类型
		*/
		public Integer getHuoyunTypes() {
			return huoyunTypes;
		}
		/**
		* 设置： 货运单类型
		*/
		public void setHuoyunTypes(Integer huoyunTypes) {
			this.huoyunTypes = huoyunTypes;
		}


			/**
			* 获取： 货运单类型的值
			*/
			public String getHuoyunValue() {
				return huoyunValue;
			}
			/**
			* 设置： 货运单类型的值
			*/
			public void setHuoyunValue(String huoyunValue) {
				this.huoyunValue = huoyunValue;
			}

		/**
		* 获取： 运送数量
		*/
		public Integer getHuoyunNumber() {
			return huoyunNumber;
		}
		/**
		* 设置： 运送数量
		*/
		public void setHuoyunNumber(Integer huoyunNumber) {
			this.huoyunNumber = huoyunNumber;
		}

		/**
		* 获取： 单个长宽高
		*/
		public String getHuoyunDanChangkuangao() {
			return huoyunDanChangkuangao;
		}
		/**
		* 设置： 单个长宽高
		*/
		public void setHuoyunDanChangkuangao(String huoyunDanChangkuangao) {
			this.huoyunDanChangkuangao = huoyunDanChangkuangao;
		}

		/**
		* 获取： 总长宽高
		*/
		public String getHuoyunZongChangkuangao() {
			return huoyunZongChangkuangao;
		}
		/**
		* 设置： 总长宽高
		*/
		public void setHuoyunZongChangkuangao(String huoyunZongChangkuangao) {
			this.huoyunZongChangkuangao = huoyunZongChangkuangao;
		}

		/**
		* 获取： 总重量
		*/
		public Double getHuoyunZhongliang() {
			return huoyunZhongliang;
		}
		/**
		* 设置： 总重量
		*/
		public void setHuoyunZhongliang(Double huoyunZhongliang) {
			this.huoyunZhongliang = huoyunZhongliang;
		}

		/**
		* 获取： 货运备注
		*/
		public String getHuoyunContent() {
			return huoyunContent;
		}
		/**
		* 设置： 货运备注
		*/
		public void setHuoyunContent(String huoyunContent) {
			this.huoyunContent = huoyunContent;
		}
		/**
		* 获取： 申请状态
		*/
		public Integer getHuoyunYesnoTypes() {
			return huoyunYesnoTypes;
		}
		/**
		* 设置： 申请状态
		*/
		public void setHuoyunYesnoTypes(Integer huoyunYesnoTypes) {
			this.huoyunYesnoTypes = huoyunYesnoTypes;
		}


			/**
			* 获取： 申请状态的值
			*/
			public String getHuoyunYesnoValue() {
				return huoyunYesnoValue;
			}
			/**
			* 设置： 申请状态的值
			*/
			public void setHuoyunYesnoValue(String huoyunYesnoValue) {
				this.huoyunYesnoValue = huoyunYesnoValue;
			}

		/**
		* 获取： 审核意见
		*/
		public String getHuoyunYesnoText() {
			return huoyunYesnoText;
		}
		/**
		* 设置： 审核意见
		*/
		public void setHuoyunYesnoText(String huoyunYesnoText) {
			this.huoyunYesnoText = huoyunYesnoText;
		}

		/**
		* 获取： 审核时间
		*/
		public Date getHuoyunShenheTime() {
			return huoyunShenheTime;
		}
		/**
		* 设置： 审核时间
		*/
		public void setHuoyunShenheTime(Date huoyunShenheTime) {
			this.huoyunShenheTime = huoyunShenheTime;
		}

		/**
		* 获取： 货运金额
		*/
		public Double getHuoyunJine() {
			return huoyunJine;
		}
		/**
		* 设置： 货运金额
		*/
		public void setHuoyunJine(Double huoyunJine) {
			this.huoyunJine = huoyunJine;
		}
		/**
		* 获取： 是否支付
		*/
		public Integer getHuoyunZhifuTypes() {
			return huoyunZhifuTypes;
		}
		/**
		* 设置： 是否支付
		*/
		public void setHuoyunZhifuTypes(Integer huoyunZhifuTypes) {
			this.huoyunZhifuTypes = huoyunZhifuTypes;
		}


			/**
			* 获取： 是否支付的值
			*/
			public String getHuoyunZhifuValue() {
				return huoyunZhifuValue;
			}
			/**
			* 设置： 是否支付的值
			*/
			public void setHuoyunZhifuValue(String huoyunZhifuValue) {
				this.huoyunZhifuValue = huoyunZhifuValue;
			}
	//级联表的get和set 员工

		/**
		* 获取： 工号
		*/
		public String getYuangongUuidNumber() {
			return yuangongUuidNumber;
		}
		/**
		* 设置： 工号
		*/
		public void setYuangongUuidNumber(String yuangongUuidNumber) {
			this.yuangongUuidNumber = yuangongUuidNumber;
		}

		/**
		* 获取： 员工姓名
		*/
		public String getYuangongName() {
			return yuangongName;
		}
		/**
		* 设置： 员工姓名
		*/
		public void setYuangongName(String yuangongName) {
			this.yuangongName = yuangongName;
		}

		/**
		* 获取： 员工手机号
		*/
		public String getYuangongPhone() {
			return yuangongPhone;
		}
		/**
		* 设置： 员工手机号
		*/
		public void setYuangongPhone(String yuangongPhone) {
			this.yuangongPhone = yuangongPhone;
		}

		/**
		* 获取： 员工身份证号
		*/
		public String getYuangongIdNumber() {
			return yuangongIdNumber;
		}
		/**
		* 设置： 员工身份证号
		*/
		public void setYuangongIdNumber(String yuangongIdNumber) {
			this.yuangongIdNumber = yuangongIdNumber;
		}

		/**
		* 获取： 员工头像
		*/
		public String getYuangongPhoto() {
			return yuangongPhoto;
		}
		/**
		* 设置： 员工头像
		*/
		public void setYuangongPhoto(String yuangongPhoto) {
			this.yuangongPhoto = yuangongPhoto;
		}

		/**
		* 获取： 员工邮箱
		*/
		public String getYuangongEmail() {
			return yuangongEmail;
		}
		/**
		* 设置： 员工邮箱
		*/
		public void setYuangongEmail(String yuangongEmail) {
			this.yuangongEmail = yuangongEmail;
		}
		/**
		* 获取： 账户状态
		*/
		public Integer getJinyongTypes() {
			return jinyongTypes;
		}
		/**
		* 设置： 账户状态
		*/
		public void setJinyongTypes(Integer jinyongTypes) {
			this.jinyongTypes = jinyongTypes;
		}


			/**
			* 获取： 账户状态的值
			*/
			public String getJinyongValue() {
				return jinyongValue;
			}
			/**
			* 设置： 账户状态的值
			*/
			public void setJinyongValue(String jinyongValue) {
				this.jinyongValue = jinyongValue;
			}


	@Override
	public String toString() {
		return "WuliuView{" +
			", wuliuValue=" + wuliuValue +
			", cangkuValue=" + cangkuValue +
			", huoyunUuidNumber=" + huoyunUuidNumber +
			", huoyunName=" + huoyunName +
			", huoyunPhoto=" + huoyunPhoto +
			", huoyunChufaAddress=" + huoyunChufaAddress +
			", huoyunChufaLianxiren=" + huoyunChufaLianxiren +
			", huoyunChufaDianhua=" + huoyunChufaDianhua +
			", huoyunSongdaAddress=" + huoyunSongdaAddress +
			", huoyunSongdaLianxiren=" + huoyunSongdaLianxiren +
			", huoyunSongdaDianhua=" + huoyunSongdaDianhua +
			", huoyunNumber=" + huoyunNumber +
			", huoyunDanChangkuangao=" + huoyunDanChangkuangao +
			", huoyunZongChangkuangao=" + huoyunZongChangkuangao +
			", huoyunZhongliang=" + huoyunZhongliang +
			", huoyunContent=" + huoyunContent +
			", huoyunYesnoText=" + huoyunYesnoText +
			", huoyunShenheTime=" + DateUtil.convertString(huoyunShenheTime,"yyyy-MM-dd") +
			", huoyunJine=" + huoyunJine +
			", yuangongUuidNumber=" + yuangongUuidNumber +
			", yuangongName=" + yuangongName +
			", yuangongPhone=" + yuangongPhone +
			", yuangongIdNumber=" + yuangongIdNumber +
			", yuangongPhoto=" + yuangongPhoto +
			", yuangongEmail=" + yuangongEmail +
			"} " + super.toString();
	}
}

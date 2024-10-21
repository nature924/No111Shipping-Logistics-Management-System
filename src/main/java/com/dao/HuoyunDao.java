package com.dao;

import com.entity.HuoyunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.HuoyunView;

/**
 * 货运单 Dao 接口
 *
 * @author 
 */
public interface HuoyunDao extends BaseMapper<HuoyunEntity> {

   List<HuoyunView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

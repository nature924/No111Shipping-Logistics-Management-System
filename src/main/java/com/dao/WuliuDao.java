package com.dao;

import com.entity.WuliuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WuliuView;

/**
 * 物流记录 Dao 接口
 *
 * @author 
 */
public interface WuliuDao extends BaseMapper<WuliuEntity> {

   List<WuliuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

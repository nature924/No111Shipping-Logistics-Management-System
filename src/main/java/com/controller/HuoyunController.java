
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 货运单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/huoyun")
public class HuoyunController {
    private static final Logger logger = LoggerFactory.getLogger(HuoyunController.class);

    private static final String TABLE_NAME = "huoyun";

    @Autowired
    private HuoyunService huoyunService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private NewsService newsService;//新闻信息
    @Autowired
    private SingleSeachService singleSeachService;//单页数据
    @Autowired
    private WuliuService wuliuService;//物流记录
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private YuangongService yuangongService;//员工
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = huoyunService.queryPage(params);

        //字典表数据转换
        List<HuoyunView> list =(List<HuoyunView>)page.getList();
        for(HuoyunView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HuoyunEntity huoyun = huoyunService.selectById(id);
        if(huoyun !=null){
            //entity转view
            HuoyunView view = new HuoyunView();
            BeanUtils.copyProperties( huoyun , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(huoyun.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"
, "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 员工
            //级联表
            YuangongEntity yuangong = yuangongService.selectById(huoyun.getYuangongId());
            if(yuangong != null){
            BeanUtils.copyProperties( yuangong , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"
, "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYuangongId(yuangong.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
     * 支付货运单
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/zhifu")
    public R info(Integer id, HttpServletRequest request){
        logger.debug("zhifu方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HuoyunEntity huoyun = huoyunService.selectById(id);
        if(huoyun !=null){
            if(huoyun.getHuoyunZhifuTypes()==2)
                return R.error("不能重复支付");

            YonghuEntity yonghuEntity = yonghuService.selectById(huoyun.getYonghuId());
            if(yonghuEntity==null)
                return R.error("查不到用户");
            double balance = yonghuEntity.getNewMoney() - huoyun.getHuoyunJine();
            if(balance<0)
                return R.error("账户不够支付,请充值后再支付货运单");
            yonghuEntity.setNewMoney(balance);
            yonghuService.updateById(yonghuEntity);

            huoyun.setHuoyunZhifuTypes(2);
            huoyunService.updateById(huoyun);

            return R.ok();
        }else {
            return R.error(511,"查不到货运单");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody HuoyunEntity huoyun, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,huoyun:{}",this.getClass().getName(),huoyun.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            huoyun.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("员工".equals(role))
            huoyun.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<HuoyunEntity> queryWrapper = new EntityWrapper<HuoyunEntity>()
            .eq("yonghu_id", huoyun.getYonghuId())
            .eq("yuangong_id", huoyun.getYuangongId())
            .eq("huoyun_name", huoyun.getHuoyunName())
            .eq("huoyun_chufa_address", huoyun.getHuoyunChufaAddress())
            .eq("huoyun_chufa_lianxiren", huoyun.getHuoyunChufaLianxiren())
            .eq("huoyun_chufa_dianhua", huoyun.getHuoyunChufaDianhua())
            .eq("huoyun_songda_address", huoyun.getHuoyunSongdaAddress())
            .eq("huoyun_songda_lianxiren", huoyun.getHuoyunSongdaLianxiren())
            .eq("huoyun_songda_dianhua", huoyun.getHuoyunSongdaDianhua())
            .eq("huoyun_types", huoyun.getHuoyunTypes())
            .eq("huoyun_number", huoyun.getHuoyunNumber())
            .eq("huoyun_dan_changkuangao", huoyun.getHuoyunDanChangkuangao())
            .eq("huoyun_zong_changkuangao", huoyun.getHuoyunZongChangkuangao())
            .in("huoyun_yesno_types", new Integer[]{1,2})
            .eq("huoyun_zhifu_types", huoyun.getHuoyunZhifuTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuoyunEntity huoyunEntity = huoyunService.selectOne(queryWrapper);
        if(huoyunEntity==null){
            huoyun.setInsertTime(new Date());
            huoyun.setHuoyunYesnoTypes(1);
            huoyun.setCreateTime(new Date());
            huoyunService.insert(huoyun);
            return R.ok();
        }else {
            if(huoyunEntity.getHuoyunYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(huoyunEntity.getHuoyunYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HuoyunEntity huoyun, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,huoyun:{}",this.getClass().getName(),huoyun.toString());
        HuoyunEntity oldHuoyunEntity = huoyunService.selectById(huoyun.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            huoyun.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("员工".equals(role))
//            huoyun.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(huoyun.getHuoyunPhoto()) || "null".equals(huoyun.getHuoyunPhoto())){
                huoyun.setHuoyunPhoto(null);
        }
        if("".equals(huoyun.getHuoyunContent()) || "null".equals(huoyun.getHuoyunContent())){
                huoyun.setHuoyunContent(null);
        }
        if("".equals(huoyun.getHuoyunYesnoText()) || "null".equals(huoyun.getHuoyunYesnoText())){
                huoyun.setHuoyunYesnoText(null);
        }

            huoyunService.updateById(huoyun);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody HuoyunEntity huoyunEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,huoyunEntity:{}",this.getClass().getName(),huoyunEntity.toString());

        HuoyunEntity oldHuoyun = huoyunService.selectById(huoyunEntity.getId());//查询原先数据

//        if(huoyunEntity.getHuoyunYesnoTypes() == 2){//通过
//            huoyunEntity.setHuoyunTypes();
//        }else if(huoyunEntity.getHuoyunYesnoTypes() == 3){//拒绝
//            huoyunEntity.setHuoyunTypes();
//        }
        huoyunEntity.setHuoyunShenheTime(new Date());//审核时间
        huoyunService.updateById(huoyunEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<HuoyunEntity> oldHuoyunList =huoyunService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        huoyunService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<HuoyunEntity> huoyunList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            HuoyunEntity huoyunEntity = new HuoyunEntity();
//                            huoyunEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            huoyunEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            huoyunEntity.setHuoyunUuidNumber(data.get(0));                    //货运单编号 要改的
//                            huoyunEntity.setHuoyunName(data.get(0));                    //货物名称 要改的
//                            huoyunEntity.setHuoyunPhoto("");//详情和图片
//                            huoyunEntity.setHuoyunChufaAddress(data.get(0));                    //出发地点 要改的
//                            huoyunEntity.setHuoyunChufaLianxiren(data.get(0));                    //出发地联系人 要改的
//                            huoyunEntity.setHuoyunChufaDianhua(data.get(0));                    //出发地电话 要改的
//                            huoyunEntity.setHuoyunSongdaAddress(data.get(0));                    //送达地点 要改的
//                            huoyunEntity.setHuoyunSongdaLianxiren(data.get(0));                    //抵达地联系人 要改的
//                            huoyunEntity.setHuoyunSongdaDianhua(data.get(0));                    //抵达地电话 要改的
//                            huoyunEntity.setHuoyunTypes(Integer.valueOf(data.get(0)));   //货运单类型 要改的
//                            huoyunEntity.setHuoyunNumber(Integer.valueOf(data.get(0)));   //运送数量 要改的
//                            huoyunEntity.setHuoyunDanChangkuangao(data.get(0));                    //单个长宽高 要改的
//                            huoyunEntity.setHuoyunZongChangkuangao(data.get(0));                    //总长宽高 要改的
//                            huoyunEntity.setHuoyunZhongliang(data.get(0));                    //总重量 要改的
//                            huoyunEntity.setHuoyunContent("");//详情和图片
//                            huoyunEntity.setInsertTime(date);//时间
//                            huoyunEntity.setHuoyunYesnoTypes(Integer.valueOf(data.get(0)));   //申请状态 要改的
//                            huoyunEntity.setHuoyunYesnoText(data.get(0));                    //审核意见 要改的
//                            huoyunEntity.setHuoyunShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            huoyunEntity.setHuoyunJine(data.get(0));                    //货运金额 要改的
//                            huoyunEntity.setHuoyunZhifuTypes(Integer.valueOf(data.get(0)));   //是否支付 要改的
//                            huoyunEntity.setCreateTime(date);//时间
                            huoyunList.add(huoyunEntity);


                            //把要查询是否重复的字段放入map中
                                //货运单编号
                                if(seachFields.containsKey("huoyunUuidNumber")){
                                    List<String> huoyunUuidNumber = seachFields.get("huoyunUuidNumber");
                                    huoyunUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> huoyunUuidNumber = new ArrayList<>();
                                    huoyunUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("huoyunUuidNumber",huoyunUuidNumber);
                                }
                        }

                        //查询是否重复
                         //货运单编号
                        List<HuoyunEntity> huoyunEntities_huoyunUuidNumber = huoyunService.selectList(new EntityWrapper<HuoyunEntity>().in("huoyun_uuid_number", seachFields.get("huoyunUuidNumber")));
                        if(huoyunEntities_huoyunUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HuoyunEntity s:huoyunEntities_huoyunUuidNumber){
                                repeatFields.add(s.getHuoyunUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [货运单编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        huoyunService.insertBatch(huoyunList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = huoyunService.queryPage(params);

        //字典表数据转换
        List<HuoyunView> list =(List<HuoyunView>)page.getList();
        for(HuoyunView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HuoyunEntity huoyun = huoyunService.selectById(id);
            if(huoyun !=null){


                //entity转view
                HuoyunView view = new HuoyunView();
                BeanUtils.copyProperties( huoyun , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(huoyun.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    YuangongEntity yuangong = yuangongService.selectById(huoyun.getYuangongId());
                if(yuangong != null){
                    BeanUtils.copyProperties( yuangong , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYuangongId(yuangong.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody HuoyunEntity huoyun, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,huoyun:{}",this.getClass().getName(),huoyun.toString());
        Wrapper<HuoyunEntity> queryWrapper = new EntityWrapper<HuoyunEntity>()
            .eq("yonghu_id", huoyun.getYonghuId())
            .eq("yuangong_id", huoyun.getYuangongId())
            .eq("huoyun_uuid_number", huoyun.getHuoyunUuidNumber())
            .eq("huoyun_name", huoyun.getHuoyunName())
            .eq("huoyun_chufa_address", huoyun.getHuoyunChufaAddress())
            .eq("huoyun_chufa_lianxiren", huoyun.getHuoyunChufaLianxiren())
            .eq("huoyun_chufa_dianhua", huoyun.getHuoyunChufaDianhua())
            .eq("huoyun_songda_address", huoyun.getHuoyunSongdaAddress())
            .eq("huoyun_songda_lianxiren", huoyun.getHuoyunSongdaLianxiren())
            .eq("huoyun_songda_dianhua", huoyun.getHuoyunSongdaDianhua())
            .eq("huoyun_types", huoyun.getHuoyunTypes())
            .eq("huoyun_number", huoyun.getHuoyunNumber())
            .eq("huoyun_dan_changkuangao", huoyun.getHuoyunDanChangkuangao())
            .eq("huoyun_zong_changkuangao", huoyun.getHuoyunZongChangkuangao())
            .in("huoyun_yesno_types", new Integer[]{1,2})
            .eq("huoyun_yesno_text", huoyun.getHuoyunYesnoText())
            .eq("huoyun_zhifu_types", huoyun.getHuoyunZhifuTypes())
//            .notIn("huoyun_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuoyunEntity huoyunEntity = huoyunService.selectOne(queryWrapper);
        if(huoyunEntity==null){
            huoyun.setInsertTime(new Date());
            huoyun.setHuoyunYesnoTypes(1);
            huoyun.setCreateTime(new Date());
        huoyunService.insert(huoyun);

            return R.ok();
        }else {
            if(huoyunEntity.getHuoyunYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(huoyunEntity.getHuoyunYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}


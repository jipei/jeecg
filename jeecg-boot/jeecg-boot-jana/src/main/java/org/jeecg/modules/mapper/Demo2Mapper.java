package org.jeecg.modules.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jeecg.modules.entity.Demo2;
import org.jeecg.modules.vo.DemoTestVo;

import java.util.List;
import java.util.Map;


/**
 * @Description: Demo2测试
 * @Author: jeecg-boot
 * @Date:   2019-12-09
 * @Version: V1.0
 */
public interface Demo2Mapper extends BaseMapper<Demo2> {

    //@Select("SELECT * FROM DEMO2 WHERE ID = #{id}")
    public DemoTestVo selectCustomersByMainId(String id);

//    @Select("SELECT * FROM JEECG_ORDER_CUSTOMER WHERE ORDER_ID = #{mainId}")
//    public List<JeecgOrderCustomer> selectCustomersByMainId(String mainId);

    //分页使用
    @Select({"<script>  SELECT  * FROM (${sql} )</script>"})
    public List<Map<String, Object>> searchByPage(Page<Map<String,Object>> page, String sql);

    //sql
    @Select({"<script> SELECT * FROM (${sql} ) </script>"})
    public List<Map<String,Object>> sqlsearchByMap(@Param("sql")String sql);


}

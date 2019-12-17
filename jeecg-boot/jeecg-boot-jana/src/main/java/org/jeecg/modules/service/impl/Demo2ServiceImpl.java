package org.jeecg.modules.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.jeecg.modules.entity.Demo2;
import org.jeecg.modules.mapper.Demo2Mapper;
import org.jeecg.modules.service.IDemo2Service;
import org.jeecg.modules.vo.DemoTestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.demo2;

import java.util.List;
import java.util.Map;

/**
 * @Description: Demo2测试
 * @Author: jeecg-boot
 * @Date:   2019-12-09
 * @Version: V1.0
 */
@Service
public class Demo2ServiceImpl extends ServiceImpl<Demo2Mapper, Demo2> implements IDemo2Service {

    @Autowired
    private Demo2Mapper demo2Mapper;

    @Override
    public DemoTestVo getById2(String id) {

        DemoTestVo demo2 = demo2Mapper.selectCustomersByMainId(id);
//        String sql ="(select * from demo2  where id = '"+id+"') as d";
//        List<Map<String, Object>> list = demo2Mapper.sqlsearchByMap(sql);
        return demo2;
    }
}

package org.jeecg.modules.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.entity.Demo2;
import org.jeecg.modules.vo.DemoTestVo;

/**
 * @Description: Demo2测试
 * @Author: jeecg-boot
 * @Date:   2019-12-09
 * @Version: V1.0
 */
public interface IDemo2Service extends IService<Demo2> {

    DemoTestVo getById2(String id);
}

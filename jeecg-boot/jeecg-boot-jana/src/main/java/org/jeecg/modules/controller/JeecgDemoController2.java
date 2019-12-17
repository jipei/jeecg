package org.jeecg.modules.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.jeecg.common.api.vo.Result;
import test.taluopai;

import java.util.Map;

@Api(tags="测试")
@RestController
@RequestMapping("/test/jeecgDemo2")
@Slf4j
public class JeecgDemoController2 {

    /**
     * hello world
     *
     * @param
     * @return
     */
    @ApiOperation(value = "hello", notes = "hello")
    @GetMapping(value = "/hello")
    public Result<String> hello() {
        Result<String> result = new Result<String>();
        result.setResult("Hello World!");
        result.setSuccess(true);
        return result;
    }

    @ApiOperation(value = "taluo", notes = "taluo")
    @GetMapping(value = "/taluo")
    public Result<Object> taluo() {
        Result<Object> result = new Result<>();
        result.setResult("Hello World!");
        result.setSuccess(true);

        taluopai taluopai = new taluopai();
        Map<String, Object> date = taluopai.show();
        JSONObject object = new JSONObject(date);
        result.setResult(object);

        return result;
    }
}

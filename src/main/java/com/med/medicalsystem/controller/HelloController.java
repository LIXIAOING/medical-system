package com.med.medicalsystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 医疗系统基础接口：用于验证 SpringBoot 工程初始化是否成功。
 */
@RestController
@RequestMapping("/api")
public class HelloController {

    /**
     * 供前端调用的 Hello World 接口，返回 JSON 数据以体现前后端分离。
     */
    @GetMapping("/hello")
    public Map<String, Object> hello() {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("systemName", "医疗系统");
        data.put("version", "1.0.0");
        data.put("springBoot", "3.2.0");
        data.put("jdk", "17");
        data.put("frontend", "Vue 3 + Vite");
        data.put("status", "运行成功");

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("code", 200);
        result.put("message", "医疗系统 Hello World 运行成功！");
        result.put("data", data);
        return result;
    }
}

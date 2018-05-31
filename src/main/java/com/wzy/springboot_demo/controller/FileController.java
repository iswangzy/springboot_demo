package com.wzy.springboot_demo.controller;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * springboot_demo
 * 过滤
 *
 * @author Wang Zhiyuan
 * @date 2018-05-31 10:28
 **/
@Controller
@PropertySource({"classpath:application.properties"})
public class FileController {
    @GetMapping("/getIndex")
    public Object index(){
        return "index";
    }
   // private static final String filePath="E:/工作文档/spring boot/springboot_demo/springboot_demo/src/main/resources/static/images/";
    @Value("${web.file.path}")
    private  String filePath;

    @PostMapping("/upload")
    @ResponseBody
    public Object upload(MultipartFile head_img,String name){
        //file.isEmpty();判断图片是否为空
        //file.geSize();图片大小进行判断
        //姓名
        System.out.println("上传地址:"+filePath);
        System.out.println("姓名："+name);
        //获取文件名
        String fileName=head_img.getOriginalFilename();
        System.out.println("上传文件名:"+fileName);
        //获取文件后缀名字
        String suffixName=fileName.substring(fileName.lastIndexOf("."));
        System.out.println("文件后缀名："+suffixName);
        //文件上传后的路径
        fileName= UUID.randomUUID()+suffixName;
        System.out.println("上传后文件的名字"+fileName);
        File dest=new File(filePath,fileName);
        try {
            head_img.transferTo(dest);
            return fileName;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }
}

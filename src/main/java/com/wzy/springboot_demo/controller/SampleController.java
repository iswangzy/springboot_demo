package com.wzy.springboot_demo.controller;

import com.wzy.springboot_demo.enttiy.ServerSettings;
import com.wzy.springboot_demo.enttiy.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * springboot_demo
 * 样本
 *
 * @author Wang Zhiyuan
 * @date 2018-05-30 17:03
 **/
@RestController
@PropertySource({"classpath:application.properties"})
public class SampleController {
    private Map<String,Object> params=new HashMap<>();
    @GetMapping("/v1/{city_id}/{user_id}")
    /**
    * 测试restful风格
    * @param cityId 城市ID
    * @param userId 用户ID
    * @return java.lang.Object
    * @author Wang Zhiyuan
    * @date 2018/5/30
    */
    public Object findUser(@PathVariable("city_id") String cityId,@PathVariable("user_id") String userId){
        params.put("cityId",cityId);
        params.put("userId",userId);
        return params;
    }
    /**
    * bin对象传参
    *  json(application/jsn)
    * @return java.lang.Object
    * @author Wang Zhiyuan
    * @date 2018/5/30
    */
    @RequestMapping("/save_user")
    public Object savaUser(@RequestBody User user){
        params.clear();
        params.put("user",user);
        return params;
    }
    /**
    * 获取http请求头信息
    * @param accessToken token
    * @return java.lang.Object
    * @author Wang Zhiyuan
    * @date 2018/5/31
    */
    @GetMapping("/get_header")
    public Object getHeader(@RequestHeader("access_token") String accessToken,String id){
        params.clear();
        params.put("accessToken",accessToken);
        System.out.println("热加载");
        params.put("id",id);
        return params;
    }
    @Autowired
    private ServerSettings error;
    @PutMapping("/put")
    public Object put(String id){
        params.clear();
        params.put("id",error);
        return params;
    }
    @DeleteMapping("/delete")
    public Object del(String id){
        params.clear();
        params.put("id",id);
        return params;
    }
    @GetMapping("/testjson")
    public Object testJson(){
        params.clear();
        params.put("user",new User(1,"男","asdfsf","13137324706",new Date()));
        return params;
    }
}

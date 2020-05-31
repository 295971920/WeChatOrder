package cn.xiaoshan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : XiaoShan
 * @Contact_QQ : 295971920
 * @CreateDate : 2020-05-31 19:47
 * @Description :
 **/
@RestController
public class HellWord {

    @GetMapping("/test")
    public String test(){
        return "123";
    }
}

package cn.xiaoshan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author : XIAOSHAN
 * @Contact_QQ : 295971920
 * @CreateDate : 2020/10/18 0:34
 * @Description : 原生微信授权
 * 1、用户同意授权，获取code，替换appid,redirect_uri,scope
 * https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxbbcc880c6c06faae&redirect_uri=http://sell.xiaoshan2016.site/sell/weixin/auth&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect
 **/
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeiXinController {

    @GetMapping("/auth")
    public void auth(@RequestParam("code")String code){
        log.info("调用了author方法");
        log.info("code={}",code);
        //获取code后，请求以下链接获取access_token
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxbbcc880c6c06faae&secret=1a416d3061fdd48329b58eeb03fe38bc&code=" + code + "&grant_type=authorization_code";
        //url为json，使用RestTemplate模板
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}",response);
    }
}

package cn.xiaoshan.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author : XIAOSHAN
 * @Contact_QQ : 295971920
 * @CreateDate : 2020/10/23 0:04
 * @Description : 账户配置
 **/
@Component
@ConfigurationProperties(prefix = "wechat")
@Data
public class WechatAccountConfig {
    private String mpAppId;
    private String mpAppSecret;
    private String redirectUrl;
}





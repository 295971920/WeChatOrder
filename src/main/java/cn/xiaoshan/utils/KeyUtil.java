package cn.xiaoshan.utils;

import java.util.Random;

/**
 * @Author : XIAOSHAN
 * @Contact_QQ : 295971920
 * @CreateDate : 2020/9/18 10:35
 * @Description : 生成订单编号
 **/
public class KeyUtil {
    /**
     * 生成唯一的主键
     * 通过synchronized保证高并发订单唯一性
     * 格式：时间+随机数
     * @return
     * */
    public static synchronized String getUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000)+100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}

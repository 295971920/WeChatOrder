package cn.xiaoshan;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author : XiaoShan
 * @Contact_QQ : 295971920
 * @CreateDate : 2020-06-04 22:04
 * @Description : 使用Slf4j需导入lombok依赖
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test(){
        /*Ctrl+Shift+Alt+N 搜索Level 选org.slf4j.event 可以查看级别*/
        String name = "XiaoShan";
        String password = "xiaoshan.cn";
        logger.info("name:"+name+" ,Password:"+password);
        log.info("name:{}"+ ",password:"+name,password);
        logger.debug("debug...");
        logger.info("info...");
        log.error("error...");
    }
}

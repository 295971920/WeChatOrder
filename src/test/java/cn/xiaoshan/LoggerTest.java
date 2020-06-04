package cn.xiaoshan;

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
 * @Description :
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTest {

    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test(){
        logger.debug("debug...");
        logger.info("info...");
        logger.error("error...");
    }
}

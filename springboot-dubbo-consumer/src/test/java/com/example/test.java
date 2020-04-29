package com.example;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.logging.Level;

/**
 * @author sergei
 * @create 2020-03-25
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = test.class)
//@Slf4j
public class test {

//    @Autowired
//    MyJsonService myJsonService;

//    Logger logger = LoggerFactory.getLogger(test.class);
    @Test
    public void test(){
        new a().aa();
//        IMarkerFactory markerFactory = MarkerFactory.getIMarkerFactory();
//
//        LoggerFactory.getLogger("test");
//        Marker fatal =MarkerFactory.getMarker("FATAL");
////        log.info(m.getName()+"test111");
//        logger.info(fatal,"test类的test方法");
    }

    public class a{
        public void aa(){
            System.out.println("aaa");
        }
    }


}

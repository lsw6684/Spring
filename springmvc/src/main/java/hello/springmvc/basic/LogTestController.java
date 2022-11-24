package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j      // 롬복 사용 가능(필드에 log 주석)
@RestController
public class LogTestController {
    //private final Logger log = LoggerFactory.getLogger(getClass()); // org.slf4j로!! & 현재 클래스 넣기.
                                                                    // getClass() == LogTestController.class
    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        log.trace(" trace log = {}" + name);    // CPU를 사용하여 String 합치는 연산 발생 (낭비)
        log.trace(" trace log = {}", name);     // 파라미터를 넘기는 메서드로, 아무 연산이 발생하지 않음.
        log.debug(" debug log = {}", name);
        log.info(" info log = {}", name);
        log.warn(" warn log = {}", name);
        log.error(" error log = {}", name);

        return "ok";
    }
}

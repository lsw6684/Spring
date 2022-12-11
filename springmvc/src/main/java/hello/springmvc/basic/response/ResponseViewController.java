package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {
    @RequestMapping("/response-view-v1")
    public ModelAndView respponseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");

        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String respponseViewV2(Model model) {
        model.addAttribute("data", "hello!");
        return "response/hello"; // @Controller + String 반환 = view 의 논리적 이름
    }

    @RequestMapping("/response/hello")  // 컨트롤러 이름과 뷰의 논리적 이름이 같으면 반환이 없어도 스프링에서 처리.(권장 x)
    public void respponseViewV3(Model model) {
        model.addAttribute("data", "hello!");
    }
}

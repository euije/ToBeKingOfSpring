package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
//    DI시 MyLogger를 주입하려고함, but @Scope("request")의 생존범위는 요청시 이기 때문이다.
//    private final MyLogger myLogger;
//    private final ObjectProvider<MyLogger> myLoggerProvider;

    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURI().toString();
//        MyLogger myLogger = myLoggerProvider.getObject();

//        myLogger = class hello.core.common.MyLogger$$EnhancerBySpringCGLIB$$a07f96ff
        System.out.println("myLogger = " + myLogger.getClass());

        myLogger.setRequestURL(requestURL);



        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}

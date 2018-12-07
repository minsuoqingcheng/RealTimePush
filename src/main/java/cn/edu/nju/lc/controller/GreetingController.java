package cn.edu.nju.lc.controller;

import cn.edu.nju.lc.message.input.HelloMessage;
import cn.edu.nju.lc.message.output.Greeting;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        String info = "Hello, " + HtmlUtils.htmlEscape(message.getName() + "!");
        return new Greeting(info);
    }

}

package hamster.demo.controller;

import org.apache.tomcat.util.net.TLSClientHelloExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {

    @GetMapping("hello")
    public String GetView(Model model){
        model.addAttribute("data","hamster.");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String hellomvc(@RequestParam(value = "name", required = true) String name, Model model){
        model.addAttribute("name", name);
        return "hello-mvc" ;
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello"+name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello

    static class Hello{
        private String
    }


}

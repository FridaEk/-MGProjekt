package team.alex.Grupp1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    // TODO: Add index mapping "/"

    @GetMapping("/error")
    public ModelAndView error() {
        // Render error(.html)
        ModelAndView mv = new ModelAndView("error");
        return mv;
    }

}

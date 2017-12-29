package mil.nga.gisdevops;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by mikemenne on 12/29/17.
 */

@Controller
public class ListController {

    @RequestMapping(value = "/alive")
    @ResponseBody
    public String alive() {
        return "yes";
    }

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
}

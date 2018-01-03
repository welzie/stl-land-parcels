package mil.nga.gisdevops.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by mikemenne on 12/29/17.
 */

@Controller
public class ParcelController {

    /* Go to url localhost:8080/alive to see output */
    @RequestMapping(value = "/alive")
    @ResponseBody
    public String alive() {
        return "yes";
    }

    /* Go to url localhost:8080/parcels to see output */
    @RequestMapping(value = "/parcels")
    public String index() {
        return "index";
    }
}

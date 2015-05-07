/**
 * 
 */
package com.roadtobe.supaldubey.examples.spring.mvc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Supal
 * 
 */
@Controller
public class BaseController
{
    @RequestMapping("welcome")
    public ModelAndView welcome(@RequestParam(value = "name", required = false,
	    defaultValue = "Supal Dubey") String name)
    {
	Map<String, String> model = new HashMap<String, String>();
	model.put("user", name);
	return new ModelAndView("namaste", model);
    }
}

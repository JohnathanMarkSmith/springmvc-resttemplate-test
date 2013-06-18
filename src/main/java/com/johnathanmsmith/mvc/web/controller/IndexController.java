package com.johnathanmsmith.mvc.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Date:   6/5/13 / 7:58 AM
 * Author: Johnathan Mark Smith
 * Email:  john@johnathanmarksmith.com
 * <p/>
 * Comments:
 * <p/>
 * This is my basic controller for my web app.
 */


@Controller
@RequestMapping("/ask")
class IndexController
{

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);


    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String getName(@PathVariable String name, ModelMap model)
    {

        logger.debug("I am in the controller and got user name: " + name);

        /*

            Taking the REST call param 'name' and setting it to the user
            attribute for the output screen

         */

        model.addAttribute("user", name);

        return "helloworld";

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getDisplayDefault(ModelMap model)
    {

        /*

            you did not enter a name so the default is going to run

         */


        model.addAttribute("user", "Johnathan Mark Smith");
        return "helloworld";

    }
}

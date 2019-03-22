package com.swu.leosanqing.controller;

import com.swu.leosanqing.annotation.MyAutowired;
import com.swu.leosanqing.annotation.MyController;
import com.swu.leosanqing.annotation.MyRequestMapping;
import com.swu.leosanqing.annotation.MyRequestParam;
import com.swu.leosanqing.service.PersonService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@MyController
@MyRequestMapping("/person")
public class PersonController {
    @MyAutowired("personServiceImpl")
    private PersonService personService;

    @MyRequestMapping("/query")
    public void query(HttpServletRequest request, HttpServletResponse response,
                      @MyRequestParam("name") String name,@MyRequestParam("age") String age){
        try {
            PrintWriter pw = response.getWriter();
            String string = personService.query(name, age);
            pw.write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}

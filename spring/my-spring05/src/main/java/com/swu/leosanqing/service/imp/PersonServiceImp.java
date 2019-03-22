package com.swu.leosanqing.service.imp;

import com.swu.leosanqing.annotation.MyService;
import com.swu.leosanqing.service.PersonService;

@MyService("PersonServiceImp")  // 加载的时候执行 map.put("PersonServiceImp",new PersonServiceImp())
public class PersonServiceImp implements PersonService {

    public String query(String name, String age) {
        return "name========"+name+"    ; age========"+age;
    }
}

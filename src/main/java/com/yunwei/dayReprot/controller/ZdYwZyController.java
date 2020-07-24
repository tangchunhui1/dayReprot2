package com.yunwei.dayReprot.controller;

import com.yunwei.dayReprot.dao.ZdYwZyService;
import com.yunwei.dayReprot.entity.ZdYwZy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController

@RequestMapping({"zdywzy"})
public class ZdYwZyController {

    @Autowired
    ZdYwZyService zdywzyService;


    @GetMapping({"selectOne"})

    @ResponseBody
    public ZdYwZy selectzdywzybyid(String id) {
        /* 37 */
        ZdYwZy zdywzy = this.zdywzyService.selectzdywzyById(Integer.parseInt(id));

        /* 39 */
        return zdywzy;

    }


    @GetMapping({"selectzdywzysByDate"})

    @ResponseBody
    public List<ZdYwZy> selectYuezdywByDate(String date) {
        /* 50 */
        List<ZdYwZy> zdYwZIES = this.zdywzyService.selectzdywzyByDate(date);

        /* 52 */
        return zdYwZIES;

    }


    @GetMapping({"selectzdywzys"})

    @ResponseBody
    public List<ZdYwZy> selectAllYuezdyw() {
        /* 64 */
        List<ZdYwZy> zdYwZIES = this.zdywzyService.selectzdywzy();

        /* 66 */
        return zdYwZIES;

    }

}

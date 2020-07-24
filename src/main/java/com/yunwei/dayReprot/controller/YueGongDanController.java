package com.yunwei.dayReprot.controller;

import com.yunwei.dayReprot.dao.YueGonDanMapper;
import com.yunwei.dayReprot.entity.YueGongDan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController

@RequestMapping({"gongdan"})
public class YueGongDanController {

    @Autowired
    YueGonDanMapper yuegondanMapper;


    @GetMapping({"selectYueGonDanById"})

    @ResponseBody
    public YueGongDan selectGondanById(String id) {

        YueGongDan yuegongdan = this.yuegondanMapper.selectGongDanById(Integer.parseInt(id));


        return yuegongdan;

    }


    @GetMapping({"selectdongdanByDate"})

    @ResponseBody
    public List<YueGongDan> selectGondanByDate(String date) {

        List<YueGongDan> listyuegongdans1 = this.yuegondanMapper.selectGongDanByDate(date);

        return listyuegongdans1;

    }


    @GetMapping({"selectAllYueGongDan"})

    @ResponseBody
    public List<YueGongDan> selectAllGongdan() {

        List<YueGongDan> listyuegongdans = this.yuegondanMapper.selectAllGongDan();


        return listyuegongdans;

    }


    @GetMapping
    public ModelAndView index() {

        List<YueGongDan> yueGongDans = this.yuegondanMapper.selectAllGongDan();

        return new ModelAndView("test", "yuegongdans", yueGongDans);

    }


    @PostMapping({"addgondan"})
    public void addgondan(YueGongDan yuegongdan) {

        this.yuegondanMapper.addgondan(yuegongdan);

    }


    @PostMapping({"updategongdan"})
    public void updategongdan(YueGongDan yuegongdan) {

        this.yuegondanMapper.updategondan(yuegongdan);

    }


    @PostMapping({"deletegongdan"})
    public void deletegongdan(String id) {

        this.yuegondanMapper.deletegondan(Integer.parseInt(id));

    }

}


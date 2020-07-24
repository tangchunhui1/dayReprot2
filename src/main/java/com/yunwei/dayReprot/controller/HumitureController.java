package com.yunwei.dayReprot.controller;

import com.yunwei.dayReprot.dao.HumitureService;
import com.yunwei.dayReprot.entity.Humiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping({"humiture"})
public class HumitureController {
    @Autowired
    HumitureService humitureService;

    @GetMapping({"selectHumitureByDate"})
    @ResponseBody
    public List<Humiture> selectHumitureByDate(String dayDate) {
        List<Humiture> humitures = this.humitureService.selectByDate(dayDate);

        return humitures;
    }


    @GetMapping({"selectAllHumiture"})
    @ResponseBody
    public List<Humiture> selectAllHumiture() {

        List<Humiture> humiture1 = this.humitureService.selectAll();

        Date dayDate1 = ((Humiture) humiture1.get(humiture1.size() - 1)).getDayDate();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");


        String dayDate = sdf.format(dayDate1);


        List<Humiture> humitures = this.humitureService.selectByDate(dayDate);

        return humitures;
    }


    @GetMapping({"selectHumitureByRegion"})
    @ResponseBody
    public Humiture selectByRegion(String region) {

        Humiture humiture = this.humitureService.selectByRegion(region);

        return humiture;
    }
}


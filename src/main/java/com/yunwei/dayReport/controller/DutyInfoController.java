package com.yunwei.dayReport.controller;

import com.yunwei.dayReport.dao.DutyInfoService;
import com.yunwei.dayReport.entity.DutyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping({"dutyInfo"})
public class DutyInfoController {
    @Autowired
    DutyInfoService dutyInfoService;

    @GetMapping({"selectDutyInfoByDate"})
    @ResponseBody
    public DutyInfo selectDutyInfoByDate(String dayDate) {
        DutyInfo dutyInfo = this.dutyInfoService.selectByDate(dayDate);

        return dutyInfo;
    }


    @GetMapping({"selectDayDutyInfo"})
    @ResponseBody
    public DutyInfo selectDayDutyInfo() {
        List<DutyInfo> dutyInfo1 = this.dutyInfoService.selectAll();
        Date dayDate1 = ((DutyInfo) dutyInfo1.get(dutyInfo1.size() - 1)).getDayDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dayDate = sdf.format(dayDate1);
        DutyInfo dutyInfo = this.dutyInfoService.selectByDate(dayDate);
        return dutyInfo;
    }
}

package com.yunwei.dayReport.controller;

import com.yunwei.dayReport.dao.ServicerService;
import com.yunwei.dayReport.entity.Servicer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController

@RequestMapping({"servicer"})
public class ServicerController {

    @Autowired
    ServicerService servicerService;


    @GetMapping({"selectServicerByDate"})

    @ResponseBody
    public List<Servicer> selectServicerByDate(String dayDate) {

        List<Servicer> servicers = this.servicerService.selectByDate(dayDate);

        return servicers;

    }


    @GetMapping({"selectAllServicer"})

    @ResponseBody
    public List<Servicer> selectAllServicer() {

        List<Servicer> servicer1 = this.servicerService.selectAll();

        Date dayDate1 = ((Servicer) servicer1.get(servicer1.size() - 1)).getDayDate();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        String dayDate = sdf.format(dayDate1);

        List<Servicer> servicers = this.servicerService.selectByDate(dayDate);

        return servicers;

    }


    @GetMapping({"selectServicerByCpuPeak"})

    @ResponseBody
    public List<Servicer> selectServicerByCpuPeak(String cpuPeak) {

        List<Servicer> servicers = this.servicerService.selectByCpuPeak(cpuPeak);

        return servicers;

    }


    @GetMapping({"selectServicerByMemoryPeak"})

    @ResponseBody
    public List<Servicer> selectServicerByMemoryPeak(String memoryUsage) {

        List<Servicer> servicers = this.servicerService.selectByMemoryPeak(memoryUsage);

        return servicers;

    }


    @GetMapping({"selectServicerByResponseTime"})

    @ResponseBody
    public List<Servicer> selectServicerByResponseTime(String responseTime) {

        List<Servicer> servicers = this.servicerService.selectByResponseTime(responseTime);

        return servicers;

    }

}


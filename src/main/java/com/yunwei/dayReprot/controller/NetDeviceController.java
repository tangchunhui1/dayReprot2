package com.yunwei.dayReprot.controller;

import com.yunwei.dayReprot.dao.NetDeviceService;
import com.yunwei.dayReprot.entity.NetDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController

@RequestMapping({"netDevice"})
public class NetDeviceController {

    @Autowired
    NetDeviceService netDeviceService;


    @GetMapping({"selectNetDeviceByDate"})

    @ResponseBody
    public List<NetDevice> selectResourceByDate(String dayDate) {

        List<NetDevice> netDevices = this.netDeviceService.selectByDate(dayDate);


        return netDevices;

    }


    @GetMapping({"selectAllNetDevice"})

    @ResponseBody
    public List<NetDevice> selectAllNetDevice() {

        List<NetDevice> netDevice1 = this.netDeviceService.selectAll();

        Date dayDate1 = ((NetDevice) netDevice1.get(netDevice1.size() - 1)).getDayDate();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        String dayDate = sdf.format(dayDate1);

        List<NetDevice> netDevices = this.netDeviceService.selectByDate(dayDate);

        return netDevices;

    }


    @GetMapping({"selectNetDeviceByCpuPeak"})

    @ResponseBody
    public List<NetDevice> selectNetDeviceByCpuPeak(String cpuPeak) {

        List<NetDevice> netDevices = this.netDeviceService.selectByCpuPeak(cpuPeak);

        return netDevices;

    }


    @GetMapping({"selectNetDeviceByMemoryPeak"})

    @ResponseBody
    public List<NetDevice> selectNetDeviceByMemoryPeak(String memoryPeak) {

        List<NetDevice> netDevices = this.netDeviceService.selectByMemoryPeak(memoryPeak);

        return netDevices;

    }


    @GetMapping({"selectNetDeviceByResponseTime"})

    @ResponseBody
    public List<NetDevice> selectNetDeviceByResponseTime(String responseTime) {

        List<NetDevice> netDevices = this.netDeviceService.selectByResponseTime(responseTime);

        return netDevices;

    }

}

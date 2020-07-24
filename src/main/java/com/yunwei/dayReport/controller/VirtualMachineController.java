package com.yunwei.dayReport.controller;

import com.yunwei.dayReport.dao.VirtualMachineService;
import com.yunwei.dayReport.entity.VirtualMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;


@RestController

@RequestMapping({"virtualMachine"})
public class VirtualMachineController {

    @Autowired
    VirtualMachineService virtualMachineService;
    String[] categorys = new String[]{"电子政务", "互联网"};


    @GetMapping({"selectVirtualMachineByDate"})

    @ResponseBody
    public List<VirtualMachine> selectVirtualMachineByDate(String dayDate) {

        List<VirtualMachine> virtualMachines = this.virtualMachineService.selectByDate(dayDate);

        return virtualMachines;

    }


    @GetMapping({"selectAllVirtualMachine"})

    @ResponseBody
    public List<VirtualMachine> selectAllResource() {

        List<VirtualMachine> virtualMachine1 = this.virtualMachineService.selectAll();

        Date dayDate1 = ((VirtualMachine) virtualMachine1.get(virtualMachine1.size() - 1)).getDayDate();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        String dayDate = sdf.format(dayDate1);

        List<VirtualMachine> virtualMachines = this.virtualMachineService.selectByDate(dayDate);

        return virtualMachines;

    }


    @GetMapping({"selectVmInfoByCategoryAndDate"})

    @ResponseBody
    public Map selectVMByCategoryAndDate(String dayDate) {

        Map<Object, Object> vmNumInfo = new HashMap<>();

        List<String> dzzwentryName1 = new ArrayList();

        List hlwentryName1 = new ArrayList();

        List<VirtualMachine> dzzwvirtualMachines = this.virtualMachineService.selectByCategoryAndDaydate(this.categorys[0], dayDate);


        for (int i = 0; i < dzzwvirtualMachines.size(); i++) {


            System.out.println("未去重的EntryName：" + ((VirtualMachine) dzzwvirtualMachines.get(i)).getEntryName());


            dzzwentryName1.add(((VirtualMachine) dzzwvirtualMachines.get(i)).getEntryName());

        }

        System.out.println("未去重的category：" + dzzwentryName1);

        LinkedHashSet<String> hashSet = new LinkedHashSet<>(dzzwentryName1);

        ArrayList<String> dzzwentryNameqc = new ArrayList<>(hashSet);


        dzzwentryNameqc.removeAll(Collections.singleton(null));

        dzzwentryNameqc.removeAll(Collections.singleton(""));

        System.out.println("去重的category：" + dzzwentryNameqc);


        int dzzwNum = dzzwentryNameqc.size();


        System.out.println("电子政务虚机数：" + dzzwNum);

        List<VirtualMachine> hlwvirtualMachines = this.virtualMachineService.selectByCategoryAndDaydate(this.categorys[1], dayDate);


        for (int j = 0; j < hlwvirtualMachines.size(); j++) {


            System.out.println("未去重的EntryName：" + ((VirtualMachine) hlwvirtualMachines.get(j)).getEntryName());

            dzzwentryName1.add(((VirtualMachine) hlwvirtualMachines.get(j)).getEntryName());

        }


        System.out.println("未去重的category：" + dzzwentryName1);


        LinkedHashSet<String> hashSet1 = new LinkedHashSet<>(dzzwentryName1);


        ArrayList<String> hlwentryName1qc = new ArrayList<>(hashSet1);

        hlwentryName1qc.removeAll(Collections.singleton(null));

        hlwentryName1qc.removeAll(Collections.singleton(""));


        System.out.println("去重的category：" + hlwentryName1qc);


        int hlwNum = hlwentryName1qc.size();


        System.out.println("电子政务虚机数：" + hlwNum);


        vmNumInfo.put("dzzwNum", Integer.valueOf(dzzwNum));

        vmNumInfo.put("hlwNum", Integer.valueOf(hlwNum));

        return vmNumInfo;

    }


    @GetMapping({"selectVirtualMachineByCpuPeak"})

    @ResponseBody
    public List<VirtualMachine> selectVirtualMachineByCpuPeak(String cpuPeak) {

        List<VirtualMachine> virtualMachines = this.virtualMachineService.selectByCpuPeak(cpuPeak);

        return virtualMachines;

    }


    @GetMapping({"selectVirtualMachineByMemoryPeak"})

    @ResponseBody
    public List<VirtualMachine> selectVirtualMachineByMemoryPeak(String memoryUsage) {

        List<VirtualMachine> virtualMachines = this.virtualMachineService.selectByMemoryPeak(memoryUsage);

        return virtualMachines;

    }


    @GetMapping({"selectVirtualMachineByResponseTime"})

    @ResponseBody
    public List<VirtualMachine> selectVirtualMachineByResponseTime(String responseTime) {

        List<VirtualMachine> virtualMachines = this.virtualMachineService.selectByResponseTime(responseTime);

        return virtualMachines;

    }

}


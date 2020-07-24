package com.yunwei.dayReprot.controller;

import com.yunwei.dayReprot.dao.CloudResourceService;
import com.yunwei.dayReprot.entity.CloudResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping({"resource"})
public class CloudResourceController {
    @Autowired
    CloudResourceService cloudResourceService;

    @GetMapping({"selectResourceByDate"})
    @ResponseBody
    public List<CloudResource> selectResourceByDate(String dayDate) {
        List<CloudResource> cloudResources = this.cloudResourceService.selectByDate(dayDate);


        return cloudResources;
    }


    @GetMapping({"selectAllResource"})
    @ResponseBody
    public List<CloudResource> selectAllResource() {
        List<CloudResource> cloudResources1 = this.cloudResourceService.selectAll();


        Date dayDate1 = ((CloudResource) cloudResources1.get(cloudResources1.size() - 1)).getDayDate();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        String dayDate = sdf.format(dayDate1);

        List<CloudResource> cloudResources = this.cloudResourceService.selectByDate(dayDate);

        return cloudResources;
    }


    @GetMapping({"selectResourceByCategory"})
    @ResponseBody
    public List<CloudResource> selectResourceByCategory(String category) {
        List<CloudResource> cloudResources = this.cloudResourceService.selectByCategory(category);
        return cloudResources;
    }


    @GetMapping({"selectResourceByCpuUsage"})
    @ResponseBody
    public List<CloudResource> selectResourceByCpuUsage(String cpuUsage) {
        List<CloudResource> cloudResources = this.cloudResourceService.selectByCpuUsage(cpuUsage);
        return cloudResources;
    }


    @GetMapping({"selectResourceByMemoryUsage"})
    @ResponseBody
    public List<CloudResource> selectResourceByMemoryUsage(String memoryUsage) {
        List<CloudResource> cloudResources = this.cloudResourceService.selectByMemoryUsage(memoryUsage);
        return cloudResources;
    }
}



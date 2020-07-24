package com.yunwei.dayReprot.controller;

import com.yunwei.dayReprot.dao.MemoryPoolService;
import com.yunwei.dayReprot.entity.MemoryPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController

@RequestMapping({"memoryPool"})
public class MemoryPoolController {

    @Autowired
    MemoryPoolService memoryPoolService;


    @GetMapping({"selectMemoryPoolByDate"})

    @ResponseBody
    public List<MemoryPool> selectMemoryPoolByDate(String dayDate) {

        List<MemoryPool> memoryPools = this.memoryPoolService.selectByDate(dayDate);

        return memoryPools;

    }


    @GetMapping({"selectAllMemoryPool"})

    @ResponseBody
    public List<MemoryPool> selectAllMemoryPool() {

        List<MemoryPool> memoryPool1 = this.memoryPoolService.selectAll();

        Date dayDate1 = ((MemoryPool) memoryPool1.get(memoryPool1.size() - 1)).getDayDate();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        String dayDate = sdf.format(dayDate1);

        List<MemoryPool> memoryPools = this.memoryPoolService.selectByDate(dayDate);

        return memoryPools;

    }


    @GetMapping({"selectMemoryPoolByCategory"})

    @ResponseBody
    public List<MemoryPool> selectMemoryPoolByCategory(String category) {

        List<MemoryPool> memoryPools = this.memoryPoolService.selectByCategory(category);

        return memoryPools;

    }

}

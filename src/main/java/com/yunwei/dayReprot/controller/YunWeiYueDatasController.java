package com.yunwei.dayReprot.controller;

import com.yunwei.dayReprot.dao.YunWeiYueDatasMapper;
import com.yunwei.dayReprot.entity.YunWeiYueDatas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController

@RequestMapping({"yueDatas"})
public class YunWeiYueDatasController {

    @Autowired
    YunWeiYueDatasMapper yunweiyuedatasMapper;


    @GetMapping({"selectYuedatasByDate"})

    @ResponseBody
    public List<YunWeiYueDatas> selectyuedatasByDate(String date) {

        List<YunWeiYueDatas> yuedatas1 = this.yunweiyuedatasMapper.selectYwydatasByDate(date);


        return yuedatas1;

    }


    @GetMapping({"selectAllYueDatas"})

    @ResponseBody
    public List<YunWeiYueDatas> selectAllYueDatas() {

        List<YunWeiYueDatas> yuedatas = this.yunweiyuedatasMapper.selectAllYwydatas();


        return yuedatas;

    }

}


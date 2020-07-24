package com.yunwei.dayReprot.controller;


import com.yunwei.dayReprot.dao.DistributionService;
import com.yunwei.dayReprot.entity.Distribution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;


@RestController
@RequestMapping({"distribution"})
public class DistributionController {
    @Autowired
    DistributionService distributionService;

    @GetMapping({"selectDistributionByDate"})
    @ResponseBody
    public List selectDistributionByDate(String dayDate) {
        List<Object> pjdistribution = new ArrayList();

        List<Distribution> distribution1 = this.distributionService.selectByDate(dayDate);
        List<String> region1 = new ArrayList<>();
        List<Double> phaseVoltage = new ArrayList<>();
        List<Double> pjPhaseVoltages = new ArrayList<>();


        for (int u = 0; u < distribution1.size(); u++) {
            region1.add(((Distribution) distribution1.get(u)).getRegion());
            phaseVoltage.add(((Distribution) distribution1.get(u)).getPhaseVoltage());
        }

        List<Double> subset = new ArrayList<>();

        DecimalFormat df = new DecimalFormat("#.0");
        for (int i = 0; i < distribution1.size() / 3; i++) {
            subset = null;
            subset = phaseVoltage.subList(i * 3, (i + 1) * 3);
            Double dianliang = Double.valueOf(0.0D);
            for (int p = 0; p < subset.size(); p++) {
                dianliang = Double.valueOf(((Double) subset.get(p)).doubleValue() + dianliang.doubleValue());
            }
            pjPhaseVoltages.add(Double.valueOf(df.format(dianliang.doubleValue() / 3.0D)));
        }
        LinkedHashSet<String> hashSet = new LinkedHashSet<>(region1);
        ArrayList<String> regionqc = new ArrayList<>(hashSet);

        System.out.println("去重的region：" + regionqc);
        System.out.println("region电量：" + pjPhaseVoltages);
        pjdistribution.add(regionqc);
        pjdistribution.add(pjPhaseVoltages);

        return pjdistribution;
    }


    @GetMapping({"selectAllDistribution"})
    @ResponseBody
    public List selectAllDistribution() {
        List<Object> pjdistribution1 = new ArrayList();
        List<Distribution> distribution1 = this.distributionService.selectAll();


        Date dayDate1 = ((Distribution) distribution1.get(distribution1.size() - 1)).getDayDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dayDate = sdf.format(dayDate1);
        List<Distribution> distributions = this.distributionService.selectByDate(dayDate);

        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
        String day1 = df.format(((Distribution) distributions.get(0)).getDayDate());

        List<String> region1 = new ArrayList<>();
        List<Double> phaseVoltage = new ArrayList<>();
        List<Double> pjPhaseVoltages = new ArrayList<>();


        for (int u = 0; u < distributions.size(); u++) {
            region1.add(((Distribution) distributions.get(u)).getRegion());
            phaseVoltage.add(((Distribution) distributions.get(u)).getPhaseVoltage());
        }
        System.out.println(phaseVoltage);
        List<Double> subset = new ArrayList<>();
        DecimalFormat dfm = new DecimalFormat("#.0");
        for (int i = 0; i < distributions.size() / 3; i++) {
            subset = null;
            subset = phaseVoltage.subList(i * 3, (i + 1) * 3);
            Double dianliang = Double.valueOf(0.0D);
            for (int p = 0; p < subset.size(); p++) {
                dianliang = Double.valueOf(((Double) subset.get(p)).doubleValue() + dianliang.doubleValue());
            }
            pjPhaseVoltages.add(Double.valueOf(dfm.format(dianliang.doubleValue() / 3.0D)));
        }
        LinkedHashSet<String> hashSet = new LinkedHashSet<>(region1);
        ArrayList<String> regionqc = new ArrayList<>(hashSet);
        System.out.println("去重的region：" + regionqc);
        System.out.println("region电量：" + pjPhaseVoltages);

        pjdistribution1.add(regionqc);
        pjdistribution1.add(pjPhaseVoltages);
        pjdistribution1.add(day1);
        return pjdistribution1;
    }


    @GetMapping({"selectDistributionByElectrofacies"})
    @ResponseBody
    public List<Distribution> selectDistributionByElectrofacies(String electrofacies) {
        List<Distribution> distributions = this.distributionService.selectByElectrofacies(electrofacies);

        return distributions;
    }


    @GetMapping({"selectDistributionByRegion"})
    @ResponseBody
    public List<Distribution> selectDistributionByRegion(String region) {
        List<Distribution> distributions = this.distributionService.selectByRegin(region);

        return distributions;
    }
}



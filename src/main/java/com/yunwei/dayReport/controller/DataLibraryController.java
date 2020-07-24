package com.yunwei.dayReport.controller;

 import com.yunwei.dayReport.dao.DataLibraryService;
 import com.yunwei.dayReport.entity.DataLibrary;
 import java.text.SimpleDateFormat;
 import java.util.Date;
 import java.util.List;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.ResponseBody;
 import org.springframework.web.bind.annotation.RestController;



 @RestController
 @RequestMapping({"library"})
 public class DataLibraryController
 {
   @Autowired
   DataLibraryService dataLibraryService;

   @GetMapping({"selectLibraryByDate"})
   @ResponseBody
   public List<DataLibrary> selectLibraryByDate(String dayDate) {
     List<DataLibrary> DataLibrarys = this.dataLibraryService.selectDataByDate(dayDate);
    return DataLibrarys;
   }






   @GetMapping({"selectAllLibrary"})
   @ResponseBody
   public List<DataLibrary> selectAllLibrary() {
     List<DataLibrary> DataLibrary1 = this.dataLibraryService.selectAll();
     Date dayDate1 = ((DataLibrary)DataLibrary1.get(DataLibrary1.size() - 1)).getDayDate();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
     String dayDate = sdf.format(dayDate1);
     List<DataLibrary> DataLibrarys = this.dataLibraryService.selectDataByDate(dayDate);
    return DataLibrarys;
   }





   @GetMapping({"selectLibraryByStatus"})
   @ResponseBody
   public List<DataLibrary> selectLibraryByStatus(String status) {
     List<DataLibrary> DataLibrarys = this.dataLibraryService.selectDataByInstanceStatus(status);
     return DataLibrarys;
   }
 }



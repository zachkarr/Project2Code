package disburse.controller;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import disburse.dao.HouseDisburseDAO;
import disburse.vo.HouseDisburseDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HouseDisburseController
{
   @Autowired HouseDisburseDAO hdDAO;
   @GetMapping("/all")
    public String getAll(Model model) {

       List<HouseDisburseDetail> hdList = hdDAO.getListOfAllRowsMapper();
       System.out.println(hdList);
       model.addAttribute("hdList", hdList);
       return "disburse";
   }

   @GetMapping("/highestAmount")
   public String getByHighestAmount( Model model) {
      List<HouseDisburseDetail> hdList = hdDAO.getListOfHighestAmount();
      model.addAttribute("hdList", hdList);
      return "disburse";
   }

   @PostMapping("/loadDisburse")

   public @ResponseBody HouseDisburseDetail postHDD(@RequestBody HouseDisburseDetail hdd){
      hdDAO.saveHDToDB(hdd);
      return hdd;
   }
   @GetMapping("/bioGuideID/{bioGuideID}")
   public String getByID(@PathVariable("bioGuideID") String bioGuideID, Model model) {
      List<HouseDisburseDetail> hdList = hdDAO.getHDByIdMyBatis(bioGuideID);
      model.addAttribute("hdList", hdList);
      return "disburse";
   }
}

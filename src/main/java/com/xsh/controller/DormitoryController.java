package com.xsh.controller;

import com.xsh.entity.Dormitory;
import com.xsh.entity.Student;
import com.xsh.service.BuildingService;
import com.xsh.service.DormitoryService;
import com.xsh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dormitory")
public class DormitoryController {

    @Autowired
    private DormitoryService dormitoryService;
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dormitorymanager");
        modelAndView.addObject("list", this.dormitoryService.list());
        modelAndView.addObject("buildingList", this.buildingService.list());
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView search(String key,String value){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dormitorymanager");
        modelAndView.addObject("list", this.dormitoryService.search(key, value));
        modelAndView.addObject("buildingList", this.buildingService.list());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Dormitory dormitory){
        this.dormitoryService.save(dormitory);
        return "redirect:/dormitory/list";
    }

    @PostMapping("/update")
    public String update(Dormitory dormitory){
        this.dormitoryService.update(dormitory);
        return "redirect:/dormitory/list";
    }

    @PostMapping("/delete")
    public String update(Integer id){
        this.dormitoryService.delete(id);
        return "redirect:/dormitory/list";
    }

    @PostMapping("/findByBuildingId")
    @ResponseBody
    public List findByBuildingId(Integer buildingId){
        List<Dormitory> dormitoryList = this.dormitoryService.findByBuildingId(buildingId);
        List list = new ArrayList();
        if(dormitoryList.size() > 0){
            List<Student> studentList = this.studentService.findByDormitoryId(dormitoryList.get(0).getId());
            list.add(dormitoryList);
            list.add(studentList);
        } else {
            list.add(new ArrayList<>());
            list.add(new ArrayList<>());
        }
        return list;
    }
}

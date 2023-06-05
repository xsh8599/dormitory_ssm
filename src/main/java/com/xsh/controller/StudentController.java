package com.xsh.controller;

import com.xsh.entity.Student;
import com.xsh.service.DormitoryAdminService;
import com.xsh.service.DormitoryService;
import com.xsh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private DormitoryService dormitoryService;
    @GetMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentmanager");
        modelAndView.addObject("list",this.studentService.list());
        modelAndView.addObject("dormitoryList", this.dormitoryService.availableList());
        return modelAndView;
    }
    @PostMapping ("/search")
    public ModelAndView search(String key,String value){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentmanager");
        modelAndView.addObject("list",this.studentService.search(key, value));
        modelAndView.addObject("dormitoryList", this.dormitoryService.availableList());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Student student){
        this.studentService.save(student);
        return "redirect:/student/list";
    }

    @PostMapping("/update")
    public String update(Student student){
        this.studentService.update(student);
        return "redirect:/student/list";
    }

    @PostMapping("/delete")
    public String delete(Student student){
        this.studentService.delete(student);
        return "redirect:/student/list";
    }






}

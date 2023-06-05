package com.xsh.controller;

import com.xsh.entity.DormitoryAdmin;
import com.xsh.service.DormitoryAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @program: dormitory
 * @description: 宿管管理
 * @author: xsh
 * @create: 2023-06-04 16:33
 **/

@Controller
@RequestMapping("/dormitoryAdmin")
public class DormitoryAdminController {
    @Autowired
    private DormitoryAdminService dormitoryAdminService;
    @GetMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminmanager");
        modelAndView.addObject("list",this.dormitoryAdminService.list());
        return modelAndView;
    }
    @PostMapping("/search")
    public ModelAndView search(String key,String value){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminmanager");
        modelAndView.addObject("list",this.dormitoryAdminService.search(key, value));
        return modelAndView;
    }
    @PostMapping("/save")
    public String save(DormitoryAdmin dormitoryAdmin){
        this.dormitoryAdminService.save(dormitoryAdmin);
        return "redirect:/dormitoryAdmin/list";
    }

    @PostMapping("/delete")
    public String delete(Integer id){
        this.dormitoryAdminService.delete(id);
        return "redirect:/dormitoryAdmin/list";
    }

    @PostMapping("/update")
    public String update(DormitoryAdmin dormitoryAdmin){
        this.dormitoryAdminService.update(dormitoryAdmin);
        return "redirect:/dormitoryAdmin/list";
    }



}

package com.xsh.service.impl;

import com.xsh.entity.Building;
import com.xsh.entity.Student;
import com.xsh.mapper.BuildingMapper;
import com.xsh.mapper.DormitoryMapper;
import com.xsh.mapper.StudentMapper;
import com.xsh.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: dormitory
 * @description: 楼宇
 * @author: xsh
 * @create: 2023-06-05 13:15
 **/

@Service
public class BuildingServiceImpl implements BuildingService {


    @Autowired
    private BuildingMapper buildingMapper;

    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Building> list() {
        return this.buildingMapper.list();
    }

    @Override
    public List<Building> search(String key, String value) {
        List<Building> list = null;
        if (key.equals("")) return this.buildingMapper.list();

        switch (key) {
            case "name":
                list = this.buildingMapper.searchByName(value);
                break;
            case "introduction":
                list = this.buildingMapper.searchByIntroduction(value);
                break;
        }
        return list;
    }

    @Override
    public void save(Building building) {
        this.buildingMapper.save(building);
    }

    @Override
    public void update(Building building) {
        this.buildingMapper.update(building);
    }


    @Override
    public void delete(Integer id) {
        //找到楼宇包含的所有宿舍
        //找到宿舍包含的所有学生
        //学生调换宿舍
        //删除宿舍，删除楼宇

        List<Integer> dormitoryIdList = this.dormitoryMapper.findDormitoryIdByBuildingId(id);
        for (Integer dormitoryId : dormitoryIdList) {
            List<Integer> studentIdList = this.studentMapper.findStudentIdByDormitoryId(dormitoryId);
            for (Integer studentId : studentIdList) {
                Integer availableDormitoryId = this.dormitoryMapper.findAvailableDormitoryId();
                this.studentMapper.resetDormitoryId(studentId, availableDormitoryId);
                this.dormitoryMapper.subAvailable(availableDormitoryId);
            }
            this.dormitoryMapper.delete(dormitoryId);
        }
        this.buildingMapper.delete(id);
    }
}

package com.xsh.service.impl;

import com.xsh.entity.Moveout;
import com.xsh.entity.Student;
import com.xsh.mapper.DormitoryAdminMapper;
import com.xsh.mapper.DormitoryMapper;
import com.xsh.mapper.StudentMapper;
import com.xsh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: dormitory
 * @description: 学生类
 * @author: xsh
 * @create: 2023-06-05 08:38
 **/

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private DormitoryMapper dormitoryMapper;


    @Override
    public List<Student> list() {
        return this.studentMapper.list();
    }

    @Override
    public List<Student> search(String key, String value) {
        if(value.equals(""))return this.studentMapper.list();
        List<Student> list = null;
        switch (key){
            case "number":
                list = this.studentMapper.searchByNumber(value);
                break;
            case "name":
                list = this.studentMapper.searchByName(value);
                break;
        }

        return list;
    }

    @Override
    public void save(Student student) {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        student.setCreateDate(format.format(date));
            this.studentMapper.save(student);
            this.dormitoryMapper.subAvailable(student.getDormitoryId());

    }


    @Override
    public void update(Student student) {
            this.studentMapper.update(student);
            if(!student.getDormitoryId().equals(student.getOldDormitoryId())){
                this.dormitoryMapper.subAvailable(student.getDormitoryId());
                this.dormitoryMapper.addAvailable(student.getOldDormitoryId());
            }
    }

    @Override
    public void delete(Student student) {
            this.studentMapper.delete(student.getId());
            this.dormitoryMapper.addAvailable(student.getDormitoryId());
    }



    @Override
    public List<Student> moveoutList() {
        return null;
    }

    @Override
    public List<Student> searchForMoveoutList(String key, String value) {
        return null;
    }

    @Override
    public void moveout(Moveout moveout) {

    }

    @Override
    public List<Student> findByDormitoryId(Integer dormitoryId) {
        return null;
    }
}

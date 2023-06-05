package com.xsh.service;

import com.xsh.entity.Moveout;
import com.xsh.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    public List<Student> list();
    public List<Student> search(String key,String value);
    public void save(Student student);
    public void update(Student student);
    public void delete(Student student);

    public List<Student> moveoutList();
    public List<Student> searchForMoveoutList(String key,String value);
    public void moveout(Moveout moveout);
    public List<Student> findByDormitoryId(Integer dormitoryId);
}

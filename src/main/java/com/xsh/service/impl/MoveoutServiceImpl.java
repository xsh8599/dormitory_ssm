package com.xsh.service.impl;

import com.xsh.entity.Moveout;
import com.xsh.mapper.MoveoutMapper;
import com.xsh.service.MoveoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoveoutServiceImpl implements MoveoutService {

    @Autowired
    private MoveoutMapper moveoutMapper;

    @Override
    public List<Moveout> list() {
        return this.moveoutMapper.list();
    }

    @Override
    public List<Moveout> search(String key, String value) {
        if(value.equals("")) return this.moveoutMapper.list();
        List<Moveout> list = null;
        switch (key){
            case "studentName":
                list = this.moveoutMapper.searchByStudentName(value);
                break;
            case "dormitoryName":
                list = this.moveoutMapper.searchByDormitoryName(value);
                break;
        }
        return list;
    }
}

package com.xsh.service.impl;

import com.xsh.entity.DormitoryAdmin;
import com.xsh.mapper.DormitoryAdminMapper;
import com.xsh.service.DormitoryAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: dormitory
 * @description: 宿管管理实现类
 * @author: xsh
 * @create: 2023-06-04 16:41
 **/

@Service
public class DormitoryAdminServiceImpl implements DormitoryAdminService {

    @Autowired
    private DormitoryAdminMapper dormitoryAdminMapper;

    @Override
    public List<DormitoryAdmin> list() {

        return this.dormitoryAdminMapper.list();
    }

    @Override
    public List<DormitoryAdmin> search(String key, String value) {
        if(key.equals("")) return this.dormitoryAdminMapper.list();
        List<DormitoryAdmin> list = null;
        switch (key){
            case "username":
                list = this.dormitoryAdminMapper.searchByUsername(value);
                break;
            case "name":
                list = this.dormitoryAdminMapper.searchByName(value);
                break;
            case "telephone":
                list = this.dormitoryAdminMapper.searchByTelephone(value);
                break;
        }

        return list;
    }

    @Override
    public void save(DormitoryAdmin dormitoryAdmin) {
        this.dormitoryAdminMapper.save(dormitoryAdmin);
    }

    @Override
    public void delete(Integer id) {
        this.dormitoryAdminMapper.delete(id);
    }

    @Override
    public void update(DormitoryAdmin dormitoryAdmin) {
        this.dormitoryAdminMapper.update(dormitoryAdmin);
    }


}

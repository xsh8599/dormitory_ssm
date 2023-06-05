package com.xsh.mapper;

import com.xsh.entity.Dormitory;
import com.xsh.entity.DormitoryAdmin;

import java.util.List;

public interface DormitoryAdminMapper {
    public List<DormitoryAdmin> list();
    public List<DormitoryAdmin> searchByUsername(String value);
    public List<DormitoryAdmin> searchByName(String value);
    public List<DormitoryAdmin> searchByTelephone(String value);
    public void save(DormitoryAdmin dormitoryAdmin);
    public void delete(Integer id);
    public void update(DormitoryAdmin dormitoryAdmin);
    public DormitoryAdmin findByUserName(String username);

}


package com.xsh.service;

import com.xsh.entity.DormitoryAdmin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DormitoryAdminService {
    public List<DormitoryAdmin> list();
    public List<DormitoryAdmin> search(String key,String value);
    public void save(DormitoryAdmin dormitoryAdmin);
    public void delete(Integer id);
    public void update(DormitoryAdmin dormitoryAdmin);
}

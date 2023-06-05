package com.xsh.service;

import com.xsh.entity.Dormitory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DormitoryService {

    public List<Dormitory> availableList();
    public List<Dormitory> list();
    public List<Dormitory> search(String key,String value);
    public void save(Dormitory dormitory);
    public void update(Dormitory dormitory);
    public void delete(Integer id);
    public List<Dormitory> findByBuildingId(Integer buildingId);

}

package com.xsh.service;

import com.xsh.entity.Building;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public interface BuildingService {
    public List<Building> list();
    public List<Building> search(String key,String value);
    public void save(Building building);
    public void update(Building building);
    public void delete(Integer id);
}

package com.xsh.mapper;

import com.xsh.entity.Dormitory;

import java.util.List;

public interface DormitoryMapper {
    public List<Dormitory> availableList();
    public void subAvailable(Integer id);
    public void addAvailable(Integer id);
    public List<Integer> findDormitoryIdByBuildingId(Integer buildingId);
    public Integer findAvailableDormitoryId();
    public void delete(Integer id);
    public List<Dormitory> list();
    public List<Dormitory> searchByName(String value);
    public List<Dormitory> searchByTelephone(String value);
    public void save(Dormitory dormitory);
    public void update(Dormitory dormitory);
    public List<Dormitory> findByBuildingId(Integer buildingId);
}

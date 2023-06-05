package com.xsh.service;

import com.xsh.entity.Absent;

import java.util.List;

public interface AbsentService {
    public List<Absent> list();
    public List<Absent> search(String key,String value);
    public void save(Absent absent);
}

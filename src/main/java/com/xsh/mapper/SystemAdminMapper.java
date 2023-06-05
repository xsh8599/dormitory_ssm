package com.xsh.mapper;

import com.xsh.entity.SystemAdmin;

public interface SystemAdminMapper {
    public SystemAdmin findByUsername(String username);
}

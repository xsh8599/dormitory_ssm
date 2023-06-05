package com.xsh.dto;

import com.xsh.entity.SystemAdmin;
import lombok.Data;

/**
 * 定义管理员和用户，使用泛型切换
 * code==-1 用户名错误
 * code==-2 密码错误
 * code==0 登入成功
 */
@Data
public class AccountDto<T> {
    private  Integer code;
    private T admin;
}

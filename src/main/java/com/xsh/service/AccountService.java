package com.xsh.service;

import com.xsh.dto.AccountDto;
import com.xsh.form.AccountForm;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    public AccountDto login(AccountForm accountForm);
}

package com.geekgame.demo.service.impl;

import com.geekgame.demo.dao.AccountDAO;
import com.geekgame.demo.dataobject.AccountDO;
import com.geekgame.demo.model.Account;
import com.geekgame.demo.service.AccountService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@DubboService
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDAO accountDAO;

    @Override
    public Account add(Account account) {
        if(account==null){
            return null;
        }
        AccountDO accountDO = new AccountDO(account);
        int insert = accountDAO.insert(accountDO);
        if(insert==1){
            return account;
        }
        return null;
    }
}

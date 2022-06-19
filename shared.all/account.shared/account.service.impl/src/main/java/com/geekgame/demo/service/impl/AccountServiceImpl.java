package com.geekgame.demo.service.impl;

import com.geekgame.demo.dao.AccountDAO;
import com.geekgame.demo.dataobject.AccountDO;
import com.geekgame.demo.model.Account;
import com.geekgame.demo.model.Paging;
import com.geekgame.demo.param.QueryAccountParam;
import com.geekgame.demo.service.AccountService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        int insert = accountDAO.add(accountDO);
        if(insert==1){
            return account;
        }
        return null;
    }

    @Override
    public int delete(String account) {
        if(StringUtils.isEmpty(account)){
            return 0;
        }
        return accountDAO.delete(account);
    }

    @Override
    public int update(Account account) {
        if (account == null) {
            return 0;
        }
        return accountDAO.update(new AccountDO(account));
    }

    @Override
    public Account selectByAccount(String account) {
        if(StringUtils.isEmpty(account)){
            return null;
        }
        return accountDAO.selectByAccount(account).convertToModel();
    }

    @Override
    public Paging<Account> pageQuery(QueryAccountParam param) {
        Paging<Account> result = new Paging<>();
        if(param==null){
            return null;
        }
        if(param.getStartTime()!=null&&param.getEndTime()!=null){
            if(param.getStartTime().compareTo(param.getEndTime())>0){
                return null;
            }
        }
        int counts = accountDAO.selectCounts(param);
        List<AccountDO> accountDOS = accountDAO.pageQuery(param);
        List<Account> accounts = accountDOS.stream().map(AccountDO::convertToModel).collect(Collectors.toList());
        result.setData(accounts);
        result.setTotalCount(counts);
        result.setTotalPage(counts/ result.getPageSize());
        return result;
    }
}

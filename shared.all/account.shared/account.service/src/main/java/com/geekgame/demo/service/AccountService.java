package com.geekgame.demo.service;

import com.geekgame.demo.model.Account;
import com.geekgame.demo.model.Paging;
import com.geekgame.demo.param.QueryAccountParam;

import java.util.List;

public interface AccountService {

    Account add(Account account);

    int delete(String account);

    int update(Account account);

    Account selectByAccount(String account);

    Paging<Account> pageQuery(QueryAccountParam param);

}

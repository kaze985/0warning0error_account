package com.geekgame.demo.dao;

import com.geekgame.demo.dataobject.AccountDO;
import com.geekgame.demo.param.QueryAccountParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountDAO {

    int add(AccountDO accountDO);

    int delete(String account);

    int update(AccountDO accountDO);

    AccountDO selectByAccount(String account);

    List<AccountDO> pageQuery(QueryAccountParam param);

    int selectCounts(QueryAccountParam param);
}

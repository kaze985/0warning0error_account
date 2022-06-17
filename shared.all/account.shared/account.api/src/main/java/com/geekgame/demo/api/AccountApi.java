package com.geekgame.demo.api;

import com.geekgame.demo.model.Account;
import com.geekgame.demo.model.Result;
import com.geekgame.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/account")
public class AccountApi {
    @Autowired
    private AccountService accountService;

    @PostMapping(path = "/add")
    public Result<Account> addAccount(@RequestBody Account account){
        Result<Account> result = new Result<>();
        result.setSuccess(true);
        if(account==null){
            result.setSuccess(false);
            result.setMessage("account is null");
            return result;
        }
        Account accountResult = accountService.add(account);
        result.setData(accountResult);
        return result;
    }
}

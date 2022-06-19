package com.geekgame.demo.api;

import com.geekgame.demo.model.Account;
import com.geekgame.demo.model.Paging;
import com.geekgame.demo.model.Result;
import com.geekgame.demo.param.QueryAccountParam;
import com.geekgame.demo.service.AccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/account")
public class AccountApi {
    @Autowired
    private AccountService accountService;

    @PostMapping(path = "/add")
    public Result<Account> addAccount(@RequestBody Account account){
        Result<Account> result = new Result<>();
        if(account==null){
            result.setMessage("account is null");
            return result;
        }
        Account accountResult = accountService.add(account);
        result.setData(accountResult);
        result.setSuccess(true);
        return result;
    }

    @GetMapping(path = "/delete")
    public Result<Integer> deleteAccount(@RequestParam String accountNumber){
        Result<Integer> result = new Result<>();
        if(StringUtils.isEmpty(accountNumber)){
            result.setMessage("accountNumber is empty");
            return result;
        }
        int delete = accountService.delete(accountNumber);
        if(delete==1){
            result.setSuccess(true);
            result.setData(delete);
        }
        return result;
    }

    @PostMapping(path = "/update")
    public Result<Integer> updateAccount(@RequestBody Account account){
        Result<Integer> result = new Result<>();
        if(account==null){
            result.setMessage("account is null");
            return result;
        }
        int update = accountService.update(account);
        if(update==1){
            result.setSuccess(true);
            result.setData(update);
        }
        return result;
    }

    @GetMapping(path = "/select")
    public Result<Account> selectAccountByNumber(@RequestParam String accountNumber){
        Result<Account> result = new Result<>();
        if(StringUtils.isEmpty(accountNumber)){
            result.setMessage("accountNumber is empty");
            return result;
        }
        Account account = accountService.selectByAccount(accountNumber);
        result.setSuccess(true);
        result.setData(account);
        return result;
    }

    @GetMapping(path = "/query")
    public Result<Paging<Account>> selectAccountByTime(@RequestBody QueryAccountParam param){
        Result<Paging<Account>> result = new Result<>();
        if (param == null) {
            result.setMessage("param is null");
            return result;
        }
        Paging<Account> accountPaging = accountService.pageQuery(param);
        result.setSuccess(true);
        result.setData(accountPaging);
        return result;

    }

}

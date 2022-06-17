package com.geekgame.demo.dataobject;

import com.geekgame.demo.model.Account;
import com.geekgame.demo.model.AccountType;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AccountDO implements Serializable {
    /**
     * 账号
     */
    private String account;
    /**
     * 账户类型
     */
    private String accountType;
    /**
     * 币种
     */
    private String currency;
    /**
     * 可用余额
     */
    private Double balance;
    /**
     * 开立时间
     */
    private LocalDateTime gmtCreated;
    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;

    public AccountDO() {
    }

    public AccountDO(Account account){
        BeanUtils.copyProperties(account,this);
        if(account.getAccountType()!=null){
            this.setAccountType(account.getAccountType().getTypeVal());
        }
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public LocalDateTime getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(LocalDateTime gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Account convertToModel(){
        Account account = new Account();
        BeanUtils.copyProperties(this,account);
        account.setAccountType(AccountType.getAccountType(getAccountType()));
        return account;
    }
}

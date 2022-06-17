package com.geekgame.demo.model;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * 账户类型
 */

public enum AccountType implements Serializable {
    INDIVIDUAL_DEMAND("个人活期","01"),
    INDIVIDUAL_PERIODIC("个人定期","02"),
    CORPORATE_ACCOUNT("对公户","03");

    private final String typeName;
    private final String typeVal;

    AccountType(String typeName,String typeVal){
        this.typeName=typeName;
        this.typeVal=typeVal;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getTypeVal() {
        return typeVal;
    }

    /**
     * 根据typeVal的值获取枚举实例
     */
    public static AccountType getAccountType(String typeVal){
        for(AccountType type:AccountType.values()){
            if(StringUtils.equals(type.getTypeVal(),typeVal)){
                return type;
            }
        }
        return null;
    }
}

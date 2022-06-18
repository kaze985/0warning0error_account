package com.geekgame.demo.config;


import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import java.util.Collection;

/**
 * 自定义分表策略类
 */

public class TablePreciseShardingAlgorithm implements PreciseShardingAlgorithm<String> {

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<String> preciseShardingValue) {
        return  "account_"+(Integer.parseInt(preciseShardingValue.getValue())%10);
    }
}

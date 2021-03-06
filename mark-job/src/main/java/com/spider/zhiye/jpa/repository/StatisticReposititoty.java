package com.spider.zhiye.jpa.repository;

import com.spider.zhiye.jpa.entity.StatisticEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticReposititoty extends CrudRepository<StatisticEntity, Long> {
    @Query(value = "select id,avg(moneyHigh) as avg_money_high,avg(moneyLow) as avg_money_low ,count(*) cnt,companyName as company_name,xueli,thirdName as third_name from zhiye.simple_work_info " +
            "where companyName is not null group by companyNo,xueli order by count(*) desc,companyNo limit 10", nativeQuery = true)
    List<StatisticEntity> selectByPkid();
}
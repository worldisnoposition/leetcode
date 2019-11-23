package com.spider.zhiye.jpa.repository;

import com.spider.zhiye.jpa.entity.ZhiyeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZhiyeReposititoty extends PagingAndSortingRepository<ZhiyeEntity, Long> {

}
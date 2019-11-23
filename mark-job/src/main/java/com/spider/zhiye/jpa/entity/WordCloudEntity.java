package com.spider.zhiye.jpa.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class WordCloudEntity {
    @Id
    private Integer id;
    private String name;
    private String value;
}

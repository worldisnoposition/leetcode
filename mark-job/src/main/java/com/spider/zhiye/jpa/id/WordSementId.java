package com.spider.zhiye.jpa.id;

import lombok.Data;

import java.io.Serializable;

@Data
public class WordSementId implements Serializable {
    private String jobId;

    private String word;
}

package com.mark.eureka.client.consumer.ribbon;

import com.mark.eureka.base.UserVO;

public interface IRibbonService {
    String getUser();
    String saveUser(UserVO userVO);
}

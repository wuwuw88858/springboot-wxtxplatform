package com.wxplatform.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.exceptions.ExpiredException;
import common.exceptions.InvalidException;
import common.utils.getOpenId.OpenIdConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentSkipListMap;


import static common.utils.NotNullCheckUtils.NotNull;


@Service
public class WxGetOpenIdService {


    private static final Logger logger = LoggerFactory.getLogger(WxGetOpenIdService.class);

    @Autowired
    ConcurrentSkipListMap<String, JSONObject> concurrentSkipListMap;
    @Autowired
    OpenIdConnection openIdConnection;

    public JSONObject getOpenId(String code) {
        NotNull(code, "code.is.null");
        String openId = openIdConnection.getOpenId(code);
        JSONObject openIdJSON = JSON.parseObject(openId);
        logger.info("WxGetOpenIdService.getOpenId() success");

        //获取到请求返回的key值来判断是否获取成功
        if (openIdJSON.containsKey("errcode") == true) {
            if (openIdJSON.getString("errcode").equals("40163")) {
                throw new ExpiredException();
            } else if (openIdJSON.getString("errcode").equals("40029")) {
                throw new InvalidException();
            }
        }
       return openIdJSON;
    }
}


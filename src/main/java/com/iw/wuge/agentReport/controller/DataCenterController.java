package com.iw.wuge.agentReport.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/6/22.
 */
public class DataCenterController {

    protected Logger logger = Logger.getLogger(getClass());
    @RequestMapping(value = "testLogger.rest")
    public void testLogging(){

        logger.info("testIt");
    }
}

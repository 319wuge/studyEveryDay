package com.iw.wuge.agentReport.controller;

import com.iw.wuge.agentReport.business.service.IDataCenterService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/6/22.
 */
@Controller
public class DataCenterController {

    protected Logger logger = Logger.getLogger(getClass());
    @Autowired
    private IDataCenterService dataCenterService;

    @RequestMapping(value = "testLogger.rest")
    @ResponseBody
    public void testLogging(){

        dataCenterService.testLogger();

    }
}

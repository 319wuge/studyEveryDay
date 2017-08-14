package com.iw.wuge.agentReport.business.service.service.impl;

import com.iw.wuge.agentReport.business.service.service.IDataCenterService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/7/6 0006.
 */
@Service
public class DataCenterServiceImpl implements IDataCenterService{
    private Logger logger = Logger.getLogger(getClass());
    public void testLogger() {
        logger.info("sssedksk");
        System.out.println("wugeswgwsw");
    }
}

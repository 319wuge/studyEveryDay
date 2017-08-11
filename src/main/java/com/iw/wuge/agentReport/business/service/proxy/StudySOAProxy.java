package com.iw.wuge.agentReport.business.service.proxy;

import com.wuge.study.client.StudySOAClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by Administrator on 2017/8/11 0011.
 */
@Component
public class StudySOAProxy {
    protected Logger logger = Logger.getLogger(getClass());

    @Autowired
    private StudySOAClient studySOAClient;

    public void  testSoa() {
        studySOAClient.testContract();
    }
}

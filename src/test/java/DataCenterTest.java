
import com.iw.wuge.agentReport.service.IDataCenterService;
import com.iw.wuge.agentReport.service.impl.DataCenterServiceImpl;
import org.junit.Test;

/**
 * Created by Administrator on 2017/7/6 0006.
 */
public class DataCenterTest {
    @Test
    public void testDataCenter(){
        IDataCenterService dataCenterService = new DataCenterServiceImpl();
        dataCenterService.testLogger();
    }
}

package single.sugarzh.multi_datasource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import single.sugarzh.multi_datasource.service.InterfaceInfoService;
import single.sugarzh.multi_datasource.service.ProjectInfoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiDatasourceApplicationTests {

    @Autowired
    private ProjectInfoService projectInfoService;

    @Autowired
    private InterfaceInfoService interfaceInfoService;

    @Test
    public void personInfoService() {

        System.out.println(projectInfoService.getProjectInfo());
    }

    @Test
    public void interfaceInfoService(){

        System.out.println(interfaceInfoService.getInterfaceInfo());
    }

}

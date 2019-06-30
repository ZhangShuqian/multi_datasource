package single.sugarzh.multi_datasource.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import single.sugarzh.multi_datasource.model.InterfaceInfo;
import single.sugarzh.multi_datasource.model.ProjectInfo;
import single.sugarzh.multi_datasource.service.InterfaceInfoService;
import single.sugarzh.multi_datasource.service.ProjectInfoService;

import java.util.List;

@RestController
public class MultiDataSourceController {

    @Autowired
    private InterfaceInfoService interfaceInfoService;

    @Autowired
    private ProjectInfoService projectInfoService;

    @RequestMapping(value = "/getProjectInfo", method = RequestMethod.GET)
    public List<ProjectInfo> getProjectInfo(){
        return projectInfoService.getProjectInfo();
    }


    @RequestMapping(value = "/getInterfaceInfo", method = RequestMethod.GET)
    public List<InterfaceInfo> getInterfaceInfo(){
        return interfaceInfoService.getInterfaceInfo();
    }
}

package single.sugarzh.multi_datasource.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import single.sugarzh.multi_datasource.config.TargetDataSource;
import single.sugarzh.multi_datasource.dao.ProjectInfoDao;
import single.sugarzh.multi_datasource.model.ProjectInfo;

import java.util.List;

@Service
public class ProjectInfoService {

    @Autowired
    private ProjectInfoDao dao;


    @TargetDataSource(name = "moreDsDataSource")
    public List<ProjectInfo> getProjectInfo(){
        return dao.findAll();
    }
}

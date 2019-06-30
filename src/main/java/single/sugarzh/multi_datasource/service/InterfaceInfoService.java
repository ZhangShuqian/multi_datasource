package single.sugarzh.multi_datasource.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import single.sugarzh.multi_datasource.config.TargetDataSource;
import single.sugarzh.multi_datasource.dao.InterfaceInfoDao;
import single.sugarzh.multi_datasource.model.InterfaceInfo;

import java.util.List;

@Service
public class InterfaceInfoService {

    @Autowired
    private InterfaceInfoDao dao;


    @TargetDataSource
    public List<InterfaceInfo> getInterfaceInfo(){
        return dao.findAll();
    }
}

package single.sugarzh.multi_datasource.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import single.sugarzh.multi_datasource.model.InterfaceInfo;

import java.util.List;

@Repository
@Mapper
public interface InterfaceInfoDao {

    /**
     * 获取所有数据
     * */
    @Select("select * from interface_info where disabled=0")
    List<InterfaceInfo> findAll();
}

package single.sugarzh.multi_datasource.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import single.sugarzh.multi_datasource.model.ProjectInfo;

import java.util.List;

@Repository
@Mapper
public interface ProjectInfoDao {

    @Select("select * from project_info")
    List<ProjectInfo> findAll();
}

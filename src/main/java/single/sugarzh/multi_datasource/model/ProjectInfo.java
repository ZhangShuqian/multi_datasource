package single.sugarzh.multi_datasource.model;


import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@ToString
public class ProjectInfo {

    private Long id;
    private String projectName;
    private String projectCode;
    private String createBy;
    private Date createTime;
    private String modifyBy;
    private Date modifyTime;
    private String remark;
}

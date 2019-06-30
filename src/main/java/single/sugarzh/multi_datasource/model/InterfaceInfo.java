package single.sugarzh.multi_datasource.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@ToString
public class InterfaceInfo {

    private Long id;
    private String projectName;
    private String interfaceName;
    private String interfacePath;
    private String interfaceWay;
    private String interfaceDesc;
    private Integer disabled;
    private String createBy;
    private Date createTime;
    private String modifyBy;
    private Date modifyTime;
}

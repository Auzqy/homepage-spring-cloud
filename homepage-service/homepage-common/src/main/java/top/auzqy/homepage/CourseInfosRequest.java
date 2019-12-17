package top.auzqy.homepage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * description:  <h1>课程信息请求对象定义</h1>
 * createTime: 2019-12-17 16:12
 * @author au
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseInfosRequest {

    private List<Long> ids;
}
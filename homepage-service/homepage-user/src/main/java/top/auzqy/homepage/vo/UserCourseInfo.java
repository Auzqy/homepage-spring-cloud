package top.auzqy.homepage.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.auzqy.homepage.CourseInfo;
import top.auzqy.homepage.UserInfo;

import java.util.Collections;
import java.util.List;

/**
 * description:  <h1>用户课程信息对象定义</h1>
 * createTime: 2019-12-17 21:43
 * @author au
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCourseInfo {

    private UserInfo userInfo;
    private List<CourseInfo> courseInfos;

    public static UserCourseInfo invalid() {

        return new UserCourseInfo(
                UserInfo.invalid(),
                Collections.emptyList()
        );
    }
}
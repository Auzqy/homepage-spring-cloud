package top.auzqy.homepage.service;


import top.auzqy.homepage.CourseInfo;
import top.auzqy.homepage.CourseInfosRequest;

import java.util.List;

/**
 * <h1>课程相关服务接口定义</h1>
 * Created by Qinyi.
 */
public interface ICourseService {

    /**
     * <h2>通过 id 获取课程信息</h2>
     * */
    CourseInfo getCourseInfo(Long id);

    /**
     * <h2>通过 ids 获取课程信息</h2>
     * */
    List<CourseInfo> getCourseInfos(CourseInfosRequest request);
}

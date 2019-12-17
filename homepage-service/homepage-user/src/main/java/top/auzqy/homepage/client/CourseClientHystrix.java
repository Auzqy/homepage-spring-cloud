package top.auzqy.homepage.client;


import org.springframework.stereotype.Component;
import top.auzqy.homepage.CourseInfo;
import top.auzqy.homepage.CourseInfosRequest;

import java.util.Collections;
import java.util.List;

/**
 * <h1>熔断降级策略</h1>
 * Created by Qinyi.
 */
@Component
public class CourseClientHystrix implements CourseClient {

    @Override
    public CourseInfo getCourseInfo(Long id) {
        return CourseInfo.invalid();
    }

    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {
        return Collections.emptyList();
    }
}
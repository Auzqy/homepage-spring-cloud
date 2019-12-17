package top.auzqy.homepage.client;


import org.springframework.stereotype.Component;
import top.auzqy.homepage.CourseInfo;
import top.auzqy.homepage.CourseInfosRequest;

import java.util.Collections;
import java.util.List;

/**
 * description:  <h1>熔断降级策略</h1>
 *
 * 我们要是用熔断降级，这个方法名必须要一样，
 * 所以为了方便我们直接实现这个接口就可以了。
 *
 * createTime: 2019-12-17 21:40
 * @author au
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
package top.auzqy.homepage.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.auzqy.homepage.CourseInfo;
import top.auzqy.homepage.CourseInfosRequest;

import java.util.List;

/**
 * description:  <h1>通过 Feign 访问课程微服务</h1>
 * createTime: 2019-12-17 22:28
 * @author au
 */
@FeignClient(value = "eureka-client-homepage-course",
fallback = CourseClientHystrix.class)
public interface CourseClient {

    @RequestMapping(value = "/homepage-course/get/course",
            method = RequestMethod.GET)
    CourseInfo getCourseInfo(Long id);

    @RequestMapping(value = "/homepage-course/get/courses",
            method = RequestMethod.POST)
    List<CourseInfo> getCourseInfos(@RequestBody CourseInfosRequest request);
}
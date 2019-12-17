package top.auzqy.homepage.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.auzqy.homepage.CourseInfo;
import top.auzqy.homepage.CourseInfosRequest;
import top.auzqy.homepage.service.ICourseService;

import java.util.List;

/**
 * <h1>课程对外服务接口</h1>
 * Created by Qinyi.
 */
@Slf4j
@RestController
public class HomepageCourseController {

    /** 课程服务接口 */
//    private final ICourseService courseService;
//
//    @Autowired
//    public HomepageCourseController(ICourseService courseService) {
//        this.courseService = courseService;
//    }
    @Autowired
    private ICourseService courseService;;

    /**
     * 127.0.0.1:7001/homepage-course/get/course?id=
     * 127.0.0.1:9000/homepage/homepage-course/get/course?id=
     * */
    @GetMapping("/get/course")
    public CourseInfo getCourseInfo(Long id) {
        log.info("<homepage-course>: get course -> {}", id);
        return courseService.getCourseInfo(id);
    }

    @PostMapping("/get/courses")
    public List<CourseInfo> getCourseInfos(
            @RequestBody CourseInfosRequest request) {
        log.info("<homepage-course>: get courses -> {}",
                JSON.toJSONString(request));
        return courseService.getCourseInfos(request);
    }
}

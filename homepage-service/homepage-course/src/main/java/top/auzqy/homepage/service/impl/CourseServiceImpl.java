package top.auzqy.homepage.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import top.auzqy.homepage.CourseInfo;
import top.auzqy.homepage.CourseInfosRequest;
import top.auzqy.homepage.dao.HomepageCourseDao;
import top.auzqy.homepage.entity.HomepageCourse;
import top.auzqy.homepage.service.ICourseService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <h1>课程服务功能实现</h1>
 * Created by Qinyi.
 */
@Slf4j
@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private HomepageCourseDao homepageCourseDao;

    @Override
    public CourseInfo getCourseInfo(Long id) {

        Optional<HomepageCourse> course = homepageCourseDao.findById(id);
        return buildCourseInfo(course.orElse(HomepageCourse.invalid()));
    }

    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {

        if (CollectionUtils.isEmpty(request.getIds())) {
            return Collections.emptyList();
        }

        List<HomepageCourse> courses = homepageCourseDao.findAllById(
                request.getIds()
        );
        return courses.stream()
                .map(this::buildCourseInfo)
                .collect(Collectors.toList());
    }

    /**
     * <h2>根据数据记录构造对象信息</h2>
     * */
    private CourseInfo buildCourseInfo(HomepageCourse course) {

        return CourseInfo.builder()
                .id(course.getId())
                .courseName(course.getCourseName())
                .courseType(course.getCourseType() == 0
                        ? "免费课程" : "实战课程")
                .courseIcon(course.getCourseIcon())
                .courseIntro(course.getCourseIntro())
                .build();
    }
}

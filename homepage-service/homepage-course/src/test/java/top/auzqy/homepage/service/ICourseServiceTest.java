package top.auzqy.homepage.service;

import com.alibaba.fastjson.JSON;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import top.auzqy.homepage.ApplicationTest;
import top.auzqy.homepage.CourseInfo;
import top.auzqy.homepage.CourseInfosRequest;
import top.auzqy.homepage.dao.HomepageCourseDao;
import top.auzqy.homepage.entity.HomepageCourse;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * description:  <h1>课程服务测试</h1>
 * createTime: 2019-12-17 17:15
 * @author au
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationTest.class},
webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ICourseServiceTest {

    @Autowired
    private HomepageCourseDao courseDao;

    @Autowired
    private ICourseService courseService;

    private HomepageCourse course1 = new HomepageCourse(
            "JDK11&12 新特性解读",
            0,
            "https://www.imooc.com",
            "解读 JDK11 和 JDK12 的新版本特性"
    );
    private HomepageCourse course2 = new HomepageCourse(
            "基于 SpringCloud 微服务架构 广告系统设计与实现",
            1,
            "https://www.imooc.com",
            "广告系统的设计与实现"
    );

    /**
     * 支持事物，@SpringBootTest 配合 @Transactional 事物默认自动回滚
     * 配合 @Rollback(false) 可以实现不回滚，默认是 true 即回滚
     */
    @Transactional
//    @Rollback(false)
    @Disabled("only for createTest")
    @Test
    void createCourseInfo(){
        List<HomepageCourse> homepageCourses = Arrays.asList(course1, course2);
        Assertions.assertEquals(homepageCourses.size(),
                courseDao.saveAll(homepageCourses).size());
    }

    @Test
    void getCourseInfo() {
        String s8 = JSON.toJSONString(
                courseService.getCourseInfo(8L));
        String s9 = JSON.toJSONString(
                courseService.getCourseInfo(9L));
        Assertions.assertNotNull(s8);
        Assertions.assertNotNull(s9);
    }

    @Test
    void getCourseInfos() {
        List<Long> ids = Arrays.asList(8L, 9L);
        List<CourseInfo> courseInfos = courseService.getCourseInfos(
                new CourseInfosRequest(ids)
        );
        Assertions.assertEquals(ids.size(),courseInfos.size());
    }
}
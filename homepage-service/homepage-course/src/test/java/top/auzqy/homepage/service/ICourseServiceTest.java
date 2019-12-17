package top.auzqy.homepage.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.auzqy.homepage.ApplicationTest;
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

    @Test
    void createCourseInfo(){
        HomepageCourse course1 = new HomepageCourse(
                "JDK11&12 新特性解读",
                0,
                "https://www.imooc.com",
                "解读 JDK11 和 JDK12 的新版本特性"
        );
        HomepageCourse course2 = new HomepageCourse(
                "基于 SpringCloud 微服务架构 广告系统设计与实现",
                1,
                "https://www.imooc.com",
                "广告系统的设计与实现"
        );

        List<HomepageCourse> homepageCourses = Arrays.asList(course1, course2);
        Assertions.assertEquals(homepageCourses.size(),
                courseDao.saveAll(homepageCourses).size());
    }

    @Test
    void getCourseInfo() {

    }

    @Test
    void getCourseInfos() {
    }
}
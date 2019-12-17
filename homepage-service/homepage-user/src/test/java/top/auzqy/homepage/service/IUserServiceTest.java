package top.auzqy.homepage.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.auzqy.homepage.HomepageUserApplicationTest;
import top.auzqy.homepage.UserInfo;
import top.auzqy.homepage.dao.HomepageUserCourseDao;
import top.auzqy.homepage.entity.HomepageUserCourse;
import top.auzqy.homepage.vo.CreateUserRequest;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HomepageUserApplicationTest.class)
class IUserServiceTest {

    @Autowired
    private IUserService userService;

    @Autowired
    private HomepageUserCourseDao userCourseDao;

    @Disabled
    @Test
    void createUser() {
        UserInfo user = userService.createUser(new CreateUserRequest(
                "zhangsan", "zhangsan@qq.com"));
        Assertions.assertTrue(user.getId()>0);
    }

    @Test
    void getUserInfo() {
        UserInfo userInfo = userService.getUserInfo(8L);
        Assertions.assertTrue(userInfo.getId()>0);
    }

    @Test
    void getUserCourseInfo() {
        HomepageUserCourse course1 = new HomepageUserCourse();
        course1.setUserId(8L);
        course1.setCourseId(8L);

        HomepageUserCourse course2 = new HomepageUserCourse();
        course2.setUserId(8L);
        course2.setCourseId(9L);

        List<HomepageUserCourse> courseList = Arrays.asList(course1, course2);
        Assertions.assertEquals(courseList.size(),
                userCourseDao.saveAll(courseList).size());
    }
}
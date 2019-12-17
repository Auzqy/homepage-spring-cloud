package top.auzqy.homepage.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import top.auzqy.homepage.CourseInfo;
import top.auzqy.homepage.CourseInfosRequest;
import top.auzqy.homepage.UserInfo;
import top.auzqy.homepage.client.CourseClient;
import top.auzqy.homepage.dao.HomepageUserCourseDao;
import top.auzqy.homepage.dao.HomepageUserDao;
import top.auzqy.homepage.entity.HomepageUser;
import top.auzqy.homepage.entity.HomepageUserCourse;
import top.auzqy.homepage.service.IUserService;
import top.auzqy.homepage.vo.CreateUserRequest;
import top.auzqy.homepage.vo.UserCourseInfo;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <h1>用户相关服务实现</h1>
 * Created by Qinyi.
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private HomepageUserDao homepageUserDao;
    @Autowired
    private HomepageUserCourseDao homepageUserCourseDao;
    @Autowired
    private CourseClient courseClient;

    @Override
    public UserInfo createUser(CreateUserRequest request) {

        if (!request.validate()) {
            return UserInfo.invalid();
        }

        HomepageUser oldUser = homepageUserDao.findByUsername(
                request.getUsername()
        );
        if (null != oldUser) {
            return UserInfo.invalid();
        }

        HomepageUser newUser = homepageUserDao.save(
                new HomepageUser(request.getUsername(), request.getEmail())
        );

        return new UserInfo(newUser.getId(),
                newUser.getUsername(), newUser.getEmail());
    }

    @Override
    public UserInfo getUserInfo(Long id) {

        Optional<HomepageUser> user = homepageUserDao.findById(id);
        if (!user.isPresent()) {
            return UserInfo.invalid();
        }

        HomepageUser curUser = user.get();

        return new UserInfo(curUser.getId(),
                curUser.getUsername(), curUser.getEmail());
    }

    @Override
    public UserCourseInfo getUserCourseInfo(Long id) {

        Optional<HomepageUser> user = homepageUserDao.findById(id);
        if (!user.isPresent()) {
            return UserCourseInfo.invalid();
        }

        HomepageUser homepageUser = user.get();
        UserInfo userInfo = new UserInfo(homepageUser.getId(),
                homepageUser.getUsername(), homepageUser.getEmail());

        List<HomepageUserCourse> userCourses =
                homepageUserCourseDao.findAllByUserId(id);
        if (CollectionUtils.isEmpty(userCourses)) {
            return new UserCourseInfo(userInfo, Collections.emptyList());
        }

        List<CourseInfo> courseInfos = courseClient.getCourseInfos(
                new CourseInfosRequest(userCourses.stream()
                        .map(HomepageUserCourse::getCourseId)
                        .collect(Collectors.toList()))
        );

        return new UserCourseInfo(userInfo, courseInfos);
    }
}
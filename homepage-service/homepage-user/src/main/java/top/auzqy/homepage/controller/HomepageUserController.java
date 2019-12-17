package top.auzqy.homepage.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.auzqy.homepage.UserInfo;
import top.auzqy.homepage.service.IUserService;
import top.auzqy.homepage.vo.CreateUserRequest;
import top.auzqy.homepage.vo.UserCourseInfo;

/**
 * description:  <h1>用户服务对外接口</h1>
 * createTime: 2019-12-17 22:47
 * @author au
 */
@Slf4j
@RestController
public class HomepageUserController {

    @Autowired
    private IUserService userService;

    /**
     * 127.0.0.1:9000/imooc/homepage-user/create/user
     * */
    @PostMapping("/create/user")
    public UserInfo createUser(@RequestBody CreateUserRequest request) {
        log.info("<homepage-user>: create user -> {}",
                JSON.toJSONString(request));
        return userService.createUser(request);
    }

    @GetMapping("/get/user")
    public UserInfo getUserInfo(Long id) {
        log.info("<homepage-user>: get user -> {}", id);
        return userService.getUserInfo(id);
    }

    @GetMapping("/get/user/course")
    public UserCourseInfo getUserCourseInfo(Long id) {
        log.info("<homepage-user>: get user course info -> {}", id);
        return userService.getUserCourseInfo(id);
    }
}
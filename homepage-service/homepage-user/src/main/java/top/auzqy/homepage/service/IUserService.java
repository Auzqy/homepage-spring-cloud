package top.auzqy.homepage.service;


import top.auzqy.homepage.UserInfo;
import top.auzqy.homepage.vo.CreateUserRequest;
import top.auzqy.homepage.vo.UserCourseInfo;

/**
 * description:  <h1>用户相关服务接口定义</h1>
 * createTime: 2019-12-17 22:26
 * @author au
 */
public interface IUserService {

    /**
     * <h2>创建用户</h2>
     * */
    UserInfo createUser(CreateUserRequest request);

    /**
     * <h2>根据 id 获取用户信息</h2>
     * */
    UserInfo getUserInfo(Long id);

    /**
     * <h2>获取用户和课程信息</h2>
     * */
    UserCourseInfo getUserCourseInfo(Long id);
}
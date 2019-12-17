package top.auzqy.homepage.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import top.auzqy.homepage.entity.HomepageUser;

/**
 * <h1>HomepageUser 数据表访问接口定义</h1>
 * Created by Qinyi.
 */
public interface HomepageUserDao
        extends JpaRepository<HomepageUser, Long> {

    /**
     * <h2>通过用户名寻找数据记录</h2>
     * */
    HomepageUser findByUsername(String username);
}
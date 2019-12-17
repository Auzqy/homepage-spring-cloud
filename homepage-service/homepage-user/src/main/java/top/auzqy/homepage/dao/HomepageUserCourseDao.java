package top.auzqy.homepage.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import top.auzqy.homepage.entity.HomepageUserCourse;

import java.util.List;

/**
 * description:  <h1>HomepageUserCourse 数据表访问接口定义</h1>
 * createTime: 2019-12-17 21:38
 * @author au
 */
public interface HomepageUserCourseDao
        extends JpaRepository<HomepageUserCourse, Long> {

    /**
     * <h2>通过用户 id 寻找数据记录</h2>
     * */
    List<HomepageUserCourse> findAllByUserId(Long userId);
}
package top.auzqy.homepage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.auzqy.homepage.entity.HomepageCourse;

/**
 * Created by Qinyi.
 */
public interface HomepageCourseDao extends
        JpaRepository<HomepageCourse, Long> {
}
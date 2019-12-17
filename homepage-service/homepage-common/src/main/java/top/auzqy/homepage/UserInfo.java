package top.auzqy.homepage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description:  <h1>基本的用户信息</h1>
 * createTime: 2019-12-17 16:12
 * @author au
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    private Long id;
    private String username;
    private String email;

    public static UserInfo invalid() {
        return new UserInfo(-1L, "", "");
    }
}
package qsh.laputa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import qsh.laputa.entity.User;
import qsh.laputa.mapper.UserMapper;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OptLockerTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void select() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void update() {
        int version = 1;
        User user = new User();
        user.setEmail("zqg@baomidou.com");
        user.setId(1360116789345845250L);
        //user.setVersion(version);
        int rows = userMapper.updateById(user);
        System.out.println("更新数：" + rows);
    }
}

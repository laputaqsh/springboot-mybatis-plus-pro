package qsh.laputa;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import qsh.laputa.entity.User;
import qsh.laputa.mapper.UserMapper;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void select() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

}

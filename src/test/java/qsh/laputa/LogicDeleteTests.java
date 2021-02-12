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
class LogicDeleteTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void select() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void deleteById() {
        int rows = userMapper.deleteById(1094592041087729666L);
        System.out.println("删除数：" + rows);
    }

    @Test
    public void updateById() {
        User user = new User();
        user.setId(1094592041087729666L);
        user.setAge(33);
        int rows = userMapper.updateById(user);
        System.out.println("更新数：" + rows);
    }

}

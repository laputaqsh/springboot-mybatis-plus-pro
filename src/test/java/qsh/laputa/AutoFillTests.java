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
public class AutoFillTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void select() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void insert() {
        User user = new User();
        user.setName("蔡译文");
        user.setAge(30);
        user.setEmail("cyw@baomidou.com");
        //user.setManagerId(1088248166370832385L);
        int rows = userMapper.insert(user);
        System.out.println("插入数：" + rows);
    }

    @Test
    public void update() {
        User user = new User();
        user.setAge(26);
        user.setId(1360116031497965569L);
        //user.setUpdateTime(LocalDateTime.now());
        int rows = userMapper.updateById(user);
        System.out.println("更新数：" + rows);
    }
}

package qsh.laputa;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
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
        QueryWrapper<User> queryWrapper = Wrappers.query();

        int version = 2;
        User user = new User();
        user.setEmail("zqg@baomidou.com");
        user.setVersion(version);
        queryWrapper.eq("name", "张琪格");

        int rows = userMapper.update(user, queryWrapper);
        System.out.println("更新数：" + rows);

        /*//Wrapper不能复用，会出现sql语句逻辑混乱的情况
        int version2 = 3;
        User user2 = new User();
        user2.setEmail("z7g@baomidou.com");
        user2.setVersion(version2);
        queryWrapper.eq("age", 26);

        int rows2 = userMapper.update(user2, queryWrapper);
        System.out.println("更新数2：" + rows2);*/
    }
}

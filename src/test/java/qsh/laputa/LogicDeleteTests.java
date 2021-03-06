package qsh.laputa;

import org.junit.Test;
import org.junit.runner.RunWith;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import qsh.laputa.entity.User;
import qsh.laputa.mapper.UserMapper;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogicDeleteTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void select() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void select1() {
        List<User> userList = userMapper.selectList(Wrappers.<User>lambdaQuery()
                .eq(User::getDeleted, 0).eq(User::getId, 1087982257332887553L));
        userList.forEach(System.out::println);
    }

    @Test
    public void mySelect() {
        List<User> userList = userMapper.mySelect(Wrappers.<User>lambdaQuery()
                .eq(User::getDeleted, 0).eq(User::getId, 1087982257332887553L));
        userList.forEach(System.out::println);
    }

    @Test
    public void deleteById() {
        int rows = userMapper.deleteById(1360116789345845250L);
        System.out.println("删除数：" + rows);
    }

    @Test
    public void updateById() {
        User user = new User();
        user.setId(1360116031497965569L);
        user.setAge(27);
        int rows = userMapper.updateById(user);
        System.out.println("更新数：" + rows);
    }

}

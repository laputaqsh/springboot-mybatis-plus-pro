package qsh.laputa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import qsh.laputa.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InjectorTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void deleteAll() {
        int rows = userMapper.deleteAll();
        System.out.println("删除数：" + rows);
    }
}

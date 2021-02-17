package qsh.laputa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import qsh.laputa.entity.User;
import qsh.laputa.mapper.UserMapper;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InjectorTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectAll() {
        List<User> userList = userMapper.selectAll();
        userList.forEach(System.out::println);
    }

    @Test
    public void insertBatch() { //自选字段插入
        // 如果个别字段在 entity 里为 null 但是数据库中有配置默认值, insert 后数据库字段是为 null 而不是默认值
        User user1 = new User();
        user1.setName("测试5");
        user1.setAge(32);
        user1.setManagerId(1088248166370832385L);
        User user2 = new User();
        user2.setName("测试6");
        user2.setAge(33);
        user2.setManagerId(1088248166370832385L);

        List<User> userList = Arrays.asList(user1, user2);
        int rows = userMapper.insertBatchSomeColumn(userList);
        System.out.println("插入数：" + rows);
    }
}

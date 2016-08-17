import demo.mapper.UserMapper;
import demo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.ParseState;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.text.MessageFormat;
import java.util.*;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestUserMapper {
    @Autowired
    private UserMapper userMapper;

    /**
     * 增加记录
     */
    @Test
    public void testInsert() {
        User user = new User();
        user.setUsername("username");
        user.setPassword("password");
        userMapper.insert(user);
    }

    /**
     * 查询记录或根据一些条件进行记录的查询
     */
    @Test
    public void testfindAll() {
        List<User> userList = userMapper.findAll();
        for (User user1 : userList) {
            System.out.println(MessageFormat.format("用户ID：{0},用户名：{1} 用户密码:{2}", user1.getId(), user1.getUsername(), user1.getPassword()));
        }
    }

    @Test
    public void testfindByName() {
        List<User> userList = userMapper.findByName("username");
        for (User user1 : userList) {
            System.out.println(MessageFormat.format("用户ID：{0},用户名：{1} 用户密码:{2}", user1.getId(), user1.getUsername(), user1.getPassword()));
        }
    }

    @Test
    public void testfindByPwd() {
        List<User> userList = userMapper.findByPwd("password");
        for (User user1 : userList) {
            System.out.println(MessageFormat.format("用户ID：{0},用户名：{1} 用户密码:{2}", user1.getId(), user1.getUsername(), user1.getPassword()));
        }
    }


    /**
     * 测试删除指定ID的记录
     */
    @Test
    public void testDeleteUser() {
        //返回值为影响的记录行数
        int i = userMapper.deleteUser(9);
        System.out.println(i);
    }

    /**
     * 测试获取用户记录条数
     */
    @Test
    public void getUserCount() {
        int userCount = userMapper.getUserCount();
        System.out.println(userCount);
    }

    /**
     * 测试使用map返回结果
     */
    @Test
    public void getUserCountAndSumId() {
        Map resultMap = userMapper.getUserCountAndSumId();
        Set<Map.Entry> set = resultMap.entrySet();
        for (Map.Entry entry : set) {
            System.out.println(entry.getKey() + "," + entry.getValue());
        }
    }

    /**
     * 批量添加用户
     */
    @Test
    public void testBatchAddUser() {
        List<User> userList = new ArrayList<User>();
        for (int i = 100; i < 110; i++) {
            User user = new User();
            user.setUsername("skyhorse" + i);
            user.setPassword("password" + i);
            userList.add(user);
        }
        //返回值为批量插入的记录条数
        int i = userMapper.batchInsert(userList);
        System.out.println(i);
    }

    /**
     * 测试批量更新用户，不像通常的更新，需要更新的值放置在用戶列表中
     */
    @Test
    public void testBatchUpdateUser() {
        List<User> userList = new ArrayList<User>();
        for (int i = 100; i < 110; i++) {
            User user = new User();
            user.setUsername("skyhorse" + i);
            user.setPassword("pwd" + i);
            userList.add(user);
        }
        int i = userMapper.batchUpdate(userList);
        System.out.println("批量程序返回的结果为:" + i + ",此结果不代表被更新的条数，所以在对账时需要更新后，再挑选已经更新的金额总和,进行账务核对");
    }

    /**
     * 测试批量删除
     */
    @Test
    public void testBatchDeleteUser() {
        List<Integer> integers = Arrays.asList(
                28, 29, 30, 31, 32, 33, 34, 35, 36, 37
        );
        int i = userMapper.batchDelete(integers);
        System.out.println("删除了" + i + "条记录!");
    }


}


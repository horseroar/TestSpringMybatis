package demo.mapper;

import org.springframework.stereotype.Repository;
import demo.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/8/16.
 */
@Repository
public interface UserMapper {
    public void insert(User user);
    public List<User> findAll();
    public List<User> findByName(String username);
    public List<User> findByPwd(String pwd);
    public int deleteUser(int id);
    public int getUserCount();
    public HashMap getUserCountAndSumId();
    public int batchInsert(List<User> userList);
    public int batchUpdate(List<User> userList);
    public int batchDelete(List<Integer> integers);
}

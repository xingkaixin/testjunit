package testdemo;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.xingkaixin.mapper.UserDao;
import com.xingkaixin.model.User;

public class UserDaoTest {
    
    public void userDaoTest() throws Exception
    {
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(reader);
        
        SqlSession session = factory.openSession();
        UserDao userDao = session.getMapper(UserDao.class);
        
        User user = new User();
        user.setUserName("hongye");
        user.setPassword("123456");
        user.setComment("��ע");
        
        userDao.insert(user);
        System.out.println("��¼������"+userDao.countAll());
        
        List<User> users = userDao.selectAll();
        Iterator<User> iter = users.iterator();
        while(iter.hasNext()){
            User u = iter.next();
            System.out.println("�û�����"+u.getUserName()+"���룺"+u.getPassword());
        }
        
        user.setComment("comment");
        userDao.update(user);
        User u = userDao.findByUserName("hongye");
        System.out.println(u.getComment());
        
        userDao.delete("hongye");
        System.out.println("��¼������"+userDao.countAll());
        
        session.commit();
        session.close();
    }
}
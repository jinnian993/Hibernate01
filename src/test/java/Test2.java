import com.yyf.po.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author yyfysf
 * @create 2019-11-21-9:58
 */
public class Test2 {
    SessionFactory sessionFactory;
    Session session;
    Transaction transaction;
    @org.junit.Before
    public void beFore() {
        //创建会话工厂
        sessionFactory = new Configuration().configure().buildSessionFactory();
        //会话
        session = sessionFactory.openSession();
        //事务
        transaction = session.beginTransaction();
    }
    @org.junit.Test
    public void get() {
        User user = session.get(User.class,1);
        System.out.println("user = " + user);
    }

    @org.junit.Test
    public void testInsert() {
        User user = new User();
        user.setId(3);
        user.setName("王五");
        user.setPassword("123");
        session.save(user);
    }

    @org.junit.Test
    public void testDelete() {
        //删除 先根据id查询是否存在对象  再去删除
        User user = session.get(User.class,3);
        if (user!=null){
            session.delete(user);
        }
    }

    /**
     * 新增或是修改
     * 根据  进行查询
     * 如果 查询到数据  那么执行 修改操作
     * 否则 执行添加操作
     */
    @org.junit.Test
    public void testSaveOrUpdate() {
        User user = new User();
        user.setId(3);
        user.setName("aaaaaaa");
        user.setPassword("123");
        session.saveOrUpdate(user);
    }



    @org.junit.After
    public void afTer() {
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}

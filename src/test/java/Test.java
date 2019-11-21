import com.yyf.po.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Test {
    @org.junit.Test
    public void Test() {
        //1.获取SessionFactory 会话工厂
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        //2生产会话 通过openssion 获取session对象
        Session session = sessionFactory.openSession();
        //3开启一个事务
        Transaction transaction = session.beginTransaction();

        //4.1执行查询(查询单条数据)  get(要查询的实体类型,参数)
        User user = session.get(User.class,1);
        System.out.println("user = " + user);
        /*transaction.commit();//提交事务
        session.close();//关闭session
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();*/
        //4.2执行查询 单条
        User load = session.load(User.class, 1);
        System.out.println("load = " + load);
        //4.3执行查询（查询单条数据） hql语句
        String hql1 = "from User where id=?";
        String hql2 = "from User where id=2";
        Query query = session.createQuery(hql1);
        query.setParameter(0,2);
        Object o = query.uniqueResult();//只针对于 已经知道只有一条语句时才能使用
        System.out.println("o = " + o);

        //5.查询全部
        Query from_user = session.createQuery("from com.yyf.po.User");
        List<User> list= from_user.list();
        for (User a:list){}
        System.out.println("list = " + list);

    }
}
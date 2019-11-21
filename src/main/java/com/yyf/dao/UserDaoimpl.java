package com.yyf.dao;

import com.yyf.po.User;
import com.yyf.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * @author yyfysf
 * @create 2019-11-21-11:02
 */
public class UserDaoimpl implements UserDao {

    public List<User> selectAll() {
//1.获取session
        Session session = HibernateUtils.getSession();
        //2.创建hql语句
        String hql = "from com.yyh.po.Student";
        //3.创建query对象
        Query query = session.createQuery(hql);
        //4.进行查询
        List<User> list = query.list();
        //5.关闭
        HibernateUtils.closeSession();
        return list;
    }
    public List<User> selectQueryAll() {
        //1.创建hql语句
        String hql = "from com.yyh.po.Student";
        //2.创建query对象
        Query query =HibernateUtils.getQuery(hql);
        //3.进行查询
        List<User> list = query.list();
        //4.关闭
        HibernateUtils.closeSession();
        return list;
    }
}

package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class MybatisUtil {
    private static final String RESOURCE = "mybatis-config.xml";
    private static SqlSessionFactory factory = null;
    private static ThreadLocal<SqlSession> tLocal = new ThreadLocal<SqlSession>();


    static {
        try {
            Reader reader = Resources.getResourceAsReader(RESOURCE);
            factory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static SqlSession getSession() {
        SqlSession session = tLocal.get();
        if (session == null) {
            session = factory.openSession();
            tLocal.set(session);
        }
        return session;
    }

    public static void closeSession() {
        SqlSession session = tLocal.get();
        tLocal.set(null);
        if (session != null) {
            session.close();
        }
    }
}

package kr.co.sist.aak.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

@Component
public class SpringMyBatis {

	private static SqlSessionFactory ssf; 

	static {
		org.apache.ibatis.logging.LogFactory.useLog4J2Logging();
		if (ssf == null) {
			try {
				Reader reader = Resources.getResourceAsReader("kr/co/sist/aak/mappers/mybatis-config.xml");
				ssf = new SqlSessionFactoryBuilder().build(reader);
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
		} 
	}

	public SqlSession getMyBatisHandler(boolean autoCommit) {
		return ssf.openSession(autoCommit);
	}
	
	public void closeHandler(SqlSession ss) {
		if(ss != null) {
			ss.close();
		}
	}
}


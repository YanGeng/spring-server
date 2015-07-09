package com.amos.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.amos.service.IHello;
import com.amos.service.NewsInfo;
import com.amos.service.NewsInfoMapper;
import com.amos.service.ShopInfo;
import com.amos.service.ShopInfoMapper;
/**
 * Servlet implementation class HelloServlet
 */
//@WebServlet(name="HelloServlet",urlPatterns={"/hello"})
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IHello hello;
	
	/**
	 * 获得MyBatis SqlSessionFactory
	 * SqlSessionFactory负责创建SqlSession，一旦创建成功，就可以用SqlSession实例来执行映射语句
	 * ，commit，rollback，close等方法。
	 * 
	 * @return
	 */
	private static SqlSessionFactory getSessionFactory() {
		SqlSessionFactory sessionFactory = null;
		String resource = "configuration.xml";
		try {
			sessionFactory = new SqlSessionFactoryBuilder().build(Resources
					//.getResourceAsStream(resource));
					.getResourceAsReader(resource));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sessionFactory;
	}

    /**
     * Default constructor. 
     */
    public HelloServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		SqlSession sqlSession = getSessionFactory().openSession();
		// ShopInfo shopInfo = sqlSession.selectOne("findByShopid", 50000);
		try {
			NewsInfoMapper userMapper = sqlSession
					.getMapper(NewsInfoMapper.class);

			// test select
			ArrayList<NewsInfo> newsInfos = userMapper.getAllNews();
			// System.out.println(user.getShopgrpid());
			// Integer shopgrpidInteger = user.getShopGroupID();

			// System.out.println(shopInfo.getShopid());
			// Change the value to json file
			JSONArray jsonArray = new JSONArray();
			
			for (int i = 0; i < newsInfos.size(); ++i) {
				Map map = new HashMap();
				map.put("title", newsInfos.get(i).getTitle());
				map.put("desc", newsInfos.get(i).getDesc());
				map.put("time", newsInfos.get(i).getTime());
				map.put("content_url", newsInfos.get(i).getContent_url());
				map.put("pic_url", newsInfos.get(i).getPic_url());

				JSONObject jsonObject = JSONObject.fromObject(map);
				System.out.println(jsonObject);
				
				jsonArray.add(jsonObject);
			}

			ApplicationContext applicationContext = WebApplicationContextUtils
					.getRequiredWebApplicationContext(this.getServletContext());
			hello = applicationContext.getBean(IHello.class);
			String sayHi = hello.sayHi();
			System.err.println("sayHi:" + sayHi);
//			response.setContentType("text/html;charset=utf-8");
//			response.setContentType("charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8"); 
			response.getWriter().write(jsonArray.toString());
					//"<h4>" + sayHi + "<br><br>" + jsonArray + "</h4>");
		} finally {
			sqlSession.close();
		}
		
		// Try to send a test email;
//		try {
//			sendMainTest();
//		} catch (EmailException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public void sendMainTest() throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName("mail.51ping.com");
		email.setSmtpPort(25);
		email.setAuthenticator(new DefaultAuthenticator("ad-data@dianping.com", "midas4DPMDS"));
		email.setSSLOnConnect(false);
		email.setFrom("ad-data@dianping.com");
		email.setSubject("Test email");
		email.setMsg("This is a test email ...");
		email.addTo("tony.geng@dianping.com"); //耿严 <tony.geng@dianping.com>
		email.send();
	}

}

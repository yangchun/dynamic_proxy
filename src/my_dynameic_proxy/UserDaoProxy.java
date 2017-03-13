package my_dynameic_proxy;
import java.lang.reflect.Method;

public class UserDaoProxy implements my_dynameic_proxy.IUserDao {
	public MyInvocationHandler h;
	public UserDaoProxy(my_dynameic_proxy.MyHandler h) {
		this.h = h;
	}

	public void sayHello() {
		try {
			Method method = my_dynameic_proxy.IUserDao.class.getMethod("sayHello");
			h.invoke(this, method);
		} catch(Exception e) {e.printStackTrace();}
	}
}
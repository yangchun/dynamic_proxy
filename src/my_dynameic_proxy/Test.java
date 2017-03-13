package my_dynameic_proxy;

public class Test {
	public static void main(String[] args) throws Exception {
		MyHandler myHandler=new MyHandler();
		IUserDao m = (IUserDao)myHandler.bind(new UserDaoImpl());
		m.sayHello();
	}
}

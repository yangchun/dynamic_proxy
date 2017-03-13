package my_dynameic_proxy;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyHandler implements MyInvocationHandler {
	
	private Object target;
	
	public Object bind(Object target) throws Exception{
		this.target=target;
		return MyProxy.newProxyInstance(target.getClass().getInterfaces()[0], this);
	}
	
	
	

	@Override
	public void invoke(Object o, Method m) {
		// TODO Auto-generated method stub
		System.out.println("代理开始");
		try {
			m.invoke(target, new Object[]{});
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("代理结束");
		

	}

}

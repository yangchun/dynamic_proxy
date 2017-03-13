package jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyTarget implements InvocationHandler{
	
	private Object target;
	public ProxyTarget(Object target){
	     this.target=target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
				System.out.println("������ķ���"+method.getName());
				System.out.println(method.invoke(target, args));
				System.out.println("������ķ���"+method.getName());
				return null;
	}

}

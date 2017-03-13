package my_dynameic_proxy;

import java.lang.reflect.Method;

public interface MyInvocationHandler {
	public void invoke(Object o, Method m);
}

package jdk;

import java.lang.reflect.Proxy;

public class Test {
public static void main(String[] args) {
	
	UserService userService=new UserServiceImpl();
	
	ProxyTarget h=new ProxyTarget(userService);
	
	UserService userServiceProxy=(UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), h);
	
	userServiceProxy.getName(2);
	
	
}
}

package cglib;

import jdk.UserService;
import jdk.UserServiceImpl;
import net.sf.cglib.proxy.Enhancer;

public class Test {
public static void main(String[] args) {
	 CglibProxy cglibProxy = new CglibProxy(); 
	 Enhancer enhancer = new Enhancer();  
     enhancer.setSuperclass(UserServiceImpl.class);  
     enhancer.setCallback(cglibProxy); 
     UserService o = (UserService)enhancer.create();  
     System.out.println(o.getName(1));
     
}
}

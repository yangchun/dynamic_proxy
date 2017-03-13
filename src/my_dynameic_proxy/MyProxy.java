package my_dynameic_proxy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class MyProxy {
	
	public static Object newProxyInstance(Class infac,MyInvocationHandler h) throws Exception, ClassNotFoundException{
		String rt="\r\n";
		String methodStr="";
		Method[] methods=infac.getDeclaredMethods();
		for(Method m:methods){
			methodStr+="	public void " + m.getName() + "() {" + rt + 
					"		try {" + rt + 
					"			Method method = " + infac.getName() + ".class.getMethod(\"" + m.getName() + "\");" + rt + 
					"			h.invoke(this, method);" + rt +  
					"		} catch(Exception e) {e.printStackTrace();}" + rt +  
					"	}" + rt;
		}
		String src =
				"package my_dynameic_proxy;" + rt +
				"import java.lang.reflect.Method;" + rt + rt +
		
				"public class UserDaoProxy implements " + infac.getName() + " {" + rt +
				"	public MyInvocationHandler h;" + rt +
				"	public UserDaoProxy("+h.getClass().getName()+" h) {" + rt +
				"		this.h = h;" + rt +
				"	}" + rt + rt +
				methodStr +
				"}";
		
		String fileName = "D:/java_workspace/dynamic_proxy/src/my_dynameic_proxy/UserDaoProxy.java";
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write(src);
		fw.flush();
		fw.close();
		
//		JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
//		StandardJavaFileManager fileMgr = jc.getStandardFileManager(null, null, null);
//		Iterable units = fileMgr.getJavaFileObjects(fileName);
//		CompilationTask t = jc.getTask(null, fileMgr, null, null, null, units);
//		t.call();
//		fileMgr.close();
		
		URL[] urls = new URL[] {new URL("file:/" + "D:/java_workspace/dynamic_proxy/bin/my_dynameic_proxy")};
		URLClassLoader loader = new URLClassLoader(urls);
		Class c = loader.loadClass("my_dynameic_proxy.UserDaoProxy");
		Constructor ctr = c.getConstructor(h.getClass());
		Object o = ctr.newInstance(h);
		return o;
		
	}
	

}

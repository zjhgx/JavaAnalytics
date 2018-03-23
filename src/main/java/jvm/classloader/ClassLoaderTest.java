package jvm.classloader;

public class ClassLoaderTest {
	public static void main(String[] args) {
        // TODO Auto-generated method stub

        ClassLoader cl = Test.class.getClassLoader();

        System.out.println("ClassLoader is:"+cl.toString());

    }
}

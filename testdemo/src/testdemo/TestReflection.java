package testdemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestReflection {
	private String username;
	private String password;
	private int[] age;

	public void setUserName(String username) {
		this.username = username;
	}

	private void setPassWord(String password) {
		this.password = password;
	}

	public static void test01() throws ClassNotFoundException {
		Class c1 = TestReflection.class;
		Class c2 = Class.forName("com.reflection.TestReflection");
		// ��ȡָ���İ���
		String package01 = c1.getPackage().getName();
		String package02 = c2.getPackage().getName();
		System.out.println("package01 = " + package01);
		System.out.println("package02 = " + package02);
		// ��ȡ������η�
		int mod = c1.getModifiers();
		String modifier = Modifier.toString(mod);
		System.out.println("modifier = " + modifier);
		// ��ȡָ�������ȫ�޶���
		String className = c1.getName();
		System.out.println("className = " + className);
		// ��ȡָ����ĸ���
		Class superClazz = c1.getSuperclass();
		String superClazzName = superClazz.getName();
		System.out.println("superClazzName = " + superClazzName);
		// ��ȡʵ�ֵĽӿ�
		Class[] interfaces = c1.getInterfaces();
		for (Class t : interfaces) {
			System.out.println("interfacesName = " + t.getName());
		}
		// ��ȡָ����ĳ�Ա����
		Field[] fields = c1.getDeclaredFields();
		for (Field field : fields) {
			modifier = Modifier.toString(field.getModifiers()); // ��ȡÿ���ֶεķ������η�
			Class type = field.getType(); // ��ȡ�ֶε�������������Ӧ��Class����
			String name = field.getName(); // ��ȡ�ֶ���
			if (type.isArray()) { // �����������������Ҫ�ر���
				String arrType = type.getComponentType().getName() + "[]";
				System.out.println("" + modifier + " " + arrType + " " + name + ";");
			} else {
				System.out.println("" + modifier + " " + type + " " + name + ";");
			}
		}
		// ��ȡ��Ĺ��췽��
		Constructor[] constructors = c1.getDeclaredConstructors();
		for (Constructor constructor : constructors) {
			String name = constructor.getName(); // ���췽����
			modifier = Modifier.toString(constructor.getModifiers()); // ��ȡ�������η�
			System.out.println("" + modifier + " " + name + "(");
			Class[] paramTypes = constructor.getParameterTypes(); // ��ȡ���췽���еĲ���
			for (int i = 0; i < paramTypes.length; i++) {
				if (i > 0) {
					System.out.print(",");
				}
				if (paramTypes[i].isArray()) {
					System.out.println(paramTypes[i].getComponentType().getName() + "[]");
				} else {
					System.out.print(paramTypes[i].getName());
				}
			}
			System.out.println(");");
		}
		// ��ȡ��Ա����
		Method[] methods = c1.getDeclaredMethods();
		for (Method method : methods) {
			modifier = Modifier.toString(method.getModifiers());
			Class returnType = method.getReturnType(); // ��ȡ�����ķ�������
			if (returnType.isArray()) {
				String arrType = returnType.getComponentType().getName() + "[]";
				System.out.print("" + modifier + " " + arrType + " " + method.getName()
				    + "(");
			} else {
				System.out.print("" + modifier + " " + returnType.getName() + " "
				    + method.getName() + "(");
			}
			Class[] paramTypes = method.getParameterTypes();
			for (int i = 0; i < paramTypes.length; i++) {
				if (i > 0) {
					System.out.print(",");
				}
				if (paramTypes[i].isArray()) {
					System.out.println(paramTypes[i].getComponentType().getName() + "[]");
				} else {
					System.out.print(paramTypes[i].getName());
				}
			}
			System.out.println(");");
		}
	}

	public static void test02() throws InstantiationException,
	    IllegalAccessException, SecurityException, NoSuchMethodException,
	    IllegalArgumentException, InvocationTargetException {
		// ������÷���������ͨ��Method���invoke����ʵ�ֶ�̬�����ĵ���
		// public Object invoke(Object obj, Object... args)
		// ��һ�������������
		// �ڶ�����������ִ�з����ϵĲ���
		// ������Ҫ�������ĳ��˽�з��������������˽�з�����Ӧ��Mehtod�������ȵ���setAccessible(true)
		Class c1 = TestReflection.class;
		TestReflection t1 = (TestReflection) c1.newInstance(); // ���÷�����������Ķ���
		System.out.println("username == " + t1.username);
		System.out.println("password == " + t1.password);
		Method method = c1.getDeclaredMethod("setUserName", String.class);
		method.invoke(t1, "Java�����ѧϰ");
		System.out.println("username == " + t1.username);
		method = c1.getDeclaredMethod("setPassWord", String.class);
		method.setAccessible(true);
		method.invoke(t1, "����ִ��ĳ��Private���εķ���");
		System.out.println("password == " + t1.password);
	}

	public static void main(String[] args) throws ClassNotFoundException,
	    SecurityException, IllegalArgumentException, InstantiationException,
	    IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		// test01();
		test02();
	}
}

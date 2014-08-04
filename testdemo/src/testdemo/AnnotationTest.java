package testdemo;

@MyAnnotation(metaAnnotation = @MetaAnnotation(birthday = "�ҵĳ�������Ϊ1988-2-18"), color = "red", array = {
    23, 26 })
public class AnnotationTest {

	public static void main(String[] args) {
		// �����AnnotationTest�Ƿ���@MyAnnotationע��
		if (AnnotationTest.class.isAnnotationPresent(MyAnnotation.class)) {
			// �����ھͻ�ȡע��
			MyAnnotation annotation = (MyAnnotation) AnnotationTest.class
			    .getAnnotation(MyAnnotation.class);
			System.out.println(annotation);
			// ��ȡע������
			System.out.println(annotation.color());
			System.out.println(annotation.value());
			// ����
			int[] arrs = annotation.array();
			for (int arr : arrs) {
				System.out.println(arr);
			}
			// ö��
			Gender gender = annotation.gender();
			System.out.println("�Ա�Ϊ��" + gender);
			// ��ȡע������
			MetaAnnotation meta = annotation.metaAnnotation();
			System.out.println(meta.birthday());
		}
	}
}

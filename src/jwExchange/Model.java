package jwExchange;

import java.util.Arrays;
import java.util.Stack;
public class Model {
	int user500in;// ����ڰ� �ִ� 500�� ����
	int user100out;// ����ڰ� ��ȯ�� 100�� ����
	int admin100 = 50;// �����ڰ� ä�� 100�� ���� //�ִ� 50��
	Stack<String> admin500 = new Stack<>();//����ڷ� ���� ���� 500�� ���� ��//�ִ� 10��
	String PASS = "admin123";//������ �н�����

	public Model(int user500in) {
		super();
		this.user500in = user500in;
	}
}

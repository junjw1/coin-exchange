package jwExchange;

import java.util.Arrays;
import java.util.Stack;
public class Model {
	int user500in;// 사용자가 넣는 500원 갯수
	int user100out;// 사용자가 교환한 100원 갯수
	int admin100 = 50;// 관리자가 채운 100원 갯수 //최대 50개
	Stack<String> admin500 = new Stack<>();//사용자로 부터 받은 500원 스택 통//최대 10개
	String PASS = "admin123";//관리자 패스워드

	public Model(int user500in) {
		super();
		this.user500in = user500in;
	}
}

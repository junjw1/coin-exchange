package jwExchange;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.PasswordView;

//UI 메인
class View extends JFrame {

	private Controller c; //컨트롤러

	private JPanel panelBig;

	private JPanel panelTitle;

	private JPanel panelUser;
	JTextField tfInCoin;
	JButton btnInCoin;
	JButton btnExchangeCoin;
	JButton btnCancel;
	JTextField tfStatus;

	private JPanel panelAdminView;
	JTextField tfAdmin100Coin;
	JTextField tfAdmin500Coin;

	JLabel labimg100;
	ImageIcon img100;
	JLabel labimg500;
	ImageIcon img500;

	private JPanel panelAdminOpen;
	JTextField tfPassStatus;
	JPasswordField tfPasswords;
	private JButton btnPassConfirm;
	JButton btnRefill;
	JButton btnGather;
	JButton btnAdminExit;

	private JPanel panelOutput;
	JTextField tfOutCoin;
	JButton btnTakeCoin;

	JLabel[] labimgOutCoin = new JLabel[50];
	ImageIcon icon;
	JPanel coins;
	ImageIcon img100out;

	public View(final Controller c) {
		this.c = c;
		setTitle("Coin Exchange");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setSize(450, 1025);
		setLocation(screenSize.width / 2 - 250, 0);
		Image imgIcon = kit.getImage("img/icon.png");
		setIconImage(imgIcon);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Big panel
		panelBig = new JPanel();
		panelBig.setLayout(new GridLayout(4, 0));

		// title panel
		panelTitle = new JPanel();
		JLabel Title = new JLabel();
		ImageIcon imgTitle = new ImageIcon("img/main.png");
		Title.setIcon(imgTitle);
		panelTitle.add(Title);

		panelBig.add(panelTitle);

		// user panel
		panelUser = new JPanel();
		panelUser.setLayout(new GridLayout(2, 0));
		tfInCoin = new JTextField("0");
		Font f1=new Font("SansSerif",Font.BOLD,40);
		tfInCoin.setFont(f1);
		tfInCoin.setEditable(false);
		tfInCoin.setHorizontalAlignment(JTextField.CENTER);
		btnInCoin = new JButton();
		btnInCoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 500원 넣기
				c.in500_output();
				// + final
			}
		});
		ImageIcon imgInCoin = new ImageIcon("img/coin.png");// 500원 넣는 그림***(불변)
		btnInCoin.setIcon(imgInCoin);
		// swing button transparent
		btnInCoin.setOpaque(false);
		btnInCoin.setContentAreaFilled(false);
		btnInCoin.setBorderPainted(false);

		JPanel panelButtons = new JPanel(new GridLayout(0, 2));
		btnExchangeCoin = new JButton("교환하기");
		btnExchangeCoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// 교환하기!
				c.coin_exchange();
			}
		});
		btnCancel = new JButton("교환취소");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// 교환취소
				c.exchane_cancel();
			}
		});
		tfStatus = new JTextField(5);
		tfStatus.setText("교환가능");
		tfStatus.setFont(f1);
		tfStatus.setEditable(false);
		tfStatus.setHorizontalAlignment(JTextField.CENTER);
		panelButtons.add(btnExchangeCoin);
		panelButtons.add(btnCancel);

		panelUser.add(tfInCoin);
		panelUser.add(btnInCoin);
		panelUser.add(panelButtons);
		panelUser.add(tfStatus);

		panelBig.add(panelUser);

		// Admin TABs
		JTabbedPane tabAdmin = new JTabbedPane();
		// *p1수준의 시작
		// admin panel tab 1
		panelAdminView = new JPanel(new GridLayout(0, 2));

		tfAdmin100Coin = new JTextField(3);
		tfAdmin100Coin.setText("50");
		tfAdmin100Coin.setHorizontalAlignment(JTextField.CENTER);
		tfAdmin500Coin = new JTextField(3);
		tfAdmin500Coin.setHorizontalAlignment(JTextField.CENTER);
		tfAdmin500Coin.setText("0");

		// **p1.1수준
		JPanel pan11 = new JPanel();
		pan11.setLayout(new BoxLayout(pan11, BoxLayout.Y_AXIS));

		JPanel pan111 = new JPanel();
		JPanel pan112 = new JPanel();

		img100 = new ImageIcon("img/100full.png");
		labimg100 = new JLabel();
		labimg100.setIcon(img100);

		// ***p1.1.1수준
		pan111.add(labimg100);
		// ***p1.1.2수준
		pan112.add(new JLabel("100원"));
		pan112.add(tfAdmin100Coin);
		tfAdmin100Coin.getDocument().addDocumentListener(
				new DocumentListener() {
					@Override
					public void removeUpdate(DocumentEvent arg0) {
						// TODO Auto-generated method stub
					}
					@Override
					public void insertUpdate(DocumentEvent arg0) {
						c.amount_100();
					}
					@Override
					public void changedUpdate(DocumentEvent arg0) {
						// TODO Auto-generated method stub
					}
				});
		pan112.add(new JLabel("개"));

		pan11.add(pan111);
		pan11.add(pan112);

		panelAdminView.add(pan11);

		// **p1.2수준
		JPanel pan12 = new JPanel();
		pan12.setLayout(new BoxLayout(pan12, BoxLayout.Y_AXIS));

		JPanel pan121 = new JPanel();
		JPanel pan122 = new JPanel();

		img500 = new ImageIcon("img/500null.png");// 500원 동전 양 그림*** (가변)
		labimg500 = new JLabel();
		labimg500.setIcon(img500);

		// ***p1.2.1수준
		pan121.add(labimg500);
		// ***p1.2.2수준
		pan122.add(new JLabel("500원"));
		pan122.add(tfAdmin500Coin);
		tfAdmin500Coin.getDocument().addDocumentListener(
				new DocumentListener() {
					@Override
					public void removeUpdate(DocumentEvent arg0) {
						// TODO Auto-generated method stub
					}
					@Override
					public void insertUpdate(DocumentEvent arg0) {
						c.amount_500();
					}
					@Override
					public void changedUpdate(DocumentEvent arg0) {
						// TODO Auto-generated method stub
					}
				});
		pan122.add(new JLabel("개"));

		pan12.add(pan121);
		pan12.add(pan122);

		panelAdminView.add(pan12);

		// *p1수준의 끝

		// *p2 start
		// admin panel tab 2
		panelAdminOpen = new JPanel();
		panelAdminOpen
				.setLayout(new BoxLayout(panelAdminOpen, BoxLayout.Y_AXIS));

		// **p2.1
		JPanel pan21 = new JPanel();
		pan21.add(new JLabel("관리자 외 접근금지"));
		panelAdminOpen.add(pan21);

		tfPassStatus = new JTextField(15);
		tfPassStatus.setText("비밀번호 입력");
		tfPasswords = new JPasswordField(15);
		btnPassConfirm = new JButton("확인");
		btnPassConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// 비밀번호 확인하기
				c.admin_key();
			}
		});
		btnRefill = new JButton("백원 보충");
		btnRefill.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// 백원 보충하기
				c.coin_refill();
			}
		});
		btnRefill.setEnabled(false);
		btnGather = new JButton("오백원 수거");
		btnGather.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 오백원 수거하기
				c.coin_gather();
			}
		});
		btnGather.setEnabled(false);
		btnAdminExit = new JButton("관리자 나가기");
		btnAdminExit.setEnabled(false);
		btnAdminExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 관리자 나가기
				c.admin_exit();
			}
		});
		// **p2.2
		JPanel pan22 = new JPanel();
		pan22.add(tfPassStatus);
		pan22.add(tfPasswords);
		pan22.add(btnPassConfirm);

		panelAdminOpen.add(pan22);

		// **p2.3
		JPanel pan23 = new JPanel();// 디폴트 배치관리자는 플로우레이아웃
		pan23.add(btnRefill);
		pan23.add(btnGather);
		pan23.add(btnAdminExit);
		panelAdminOpen.add(pan23);

		tabAdmin.addTab("관리자", panelAdminView);
		tabAdmin.addTab("열  기", panelAdminOpen);
		panelBig.add(tabAdmin);
		// *p2 end

		// output panel
		panelOutput = new JPanel(new GridLayout(2, 0));
		tfOutCoin = new JTextField(5);
		tfOutCoin.setHorizontalAlignment(JTextField.CENTER);
		tfOutCoin.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				btnTakeCoin.setEnabled(false);

			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				btnTakeCoin.setEnabled(true);
			}

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		btnTakeCoin = new JButton("동전 들고가기");
		btnTakeCoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 100원 들고가기
				c.take_coin();
			}
		});

		btnTakeCoin.setEnabled(false);
		coins = new JPanel(new GridLayout(0, 10));
		//상단 배열 선언 한 것은 여기서 객체 생성
		for (int i = 0; i < 50; i++) {
			labimgOutCoin[i] = new JLabel();
		}
		img100out = new ImageIcon("img/out100_30x30.png");
		panelOutput.add(coins);

		JPanel panelOneHundred = new JPanel();
		panelOneHundred.add(new JLabel("백원"));
		panelOneHundred.add(tfOutCoin);
		panelOneHundred.add(new JLabel("개"));
		panelOneHundred.add(btnTakeCoin);

		panelOutput.add(panelOneHundred);

		panelBig.add(panelOutput);

		this.add(panelBig);

		setVisible(true);

		c.connect_view(this);
	}
}

public class ViewMain {
	public static void main(String[] args) {
		//프로그램 첫 개시는 500원 통은 0원 100원 통은 full
		Model m = new Model(0);
		//모델 클래스의 객체를 컨트롤러로 연결
		Controller c = new Controller(m);
		//뷰클래스의 객체 생성 시 컨트롤로와 연결
		View v = new View(c);
	}

}

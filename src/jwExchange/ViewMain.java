package jwExchange;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.PasswordView;

//UI ����
class View extends JFrame {

	private Controller c; //��Ʈ�ѷ�

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
				// 500�� �ֱ�
				c.in500_output();
				// + final
			}
		});
		ImageIcon imgInCoin = new ImageIcon("img/coin.png");// 500�� �ִ� �׸�***(�Һ�)
		btnInCoin.setIcon(imgInCoin);
		// swing button transparent
		btnInCoin.setOpaque(false);
		btnInCoin.setContentAreaFilled(false);
		btnInCoin.setBorderPainted(false);

		JPanel panelButtons = new JPanel(new GridLayout(0, 2));
		btnExchangeCoin = new JButton("��ȯ�ϱ�");
		btnExchangeCoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// ��ȯ�ϱ�!
				c.coin_exchange();
			}
		});
		btnCancel = new JButton("��ȯ���");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// ��ȯ���
				c.exchane_cancel();
			}
		});
		tfStatus = new JTextField(5);
		tfStatus.setText("��ȯ����");
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
		// *p1������ ����
		// admin panel tab 1
		panelAdminView = new JPanel(new GridLayout(0, 2));

		tfAdmin100Coin = new JTextField(3);
		tfAdmin100Coin.setText("50");
		tfAdmin100Coin.setHorizontalAlignment(JTextField.CENTER);
		tfAdmin500Coin = new JTextField(3);
		tfAdmin500Coin.setHorizontalAlignment(JTextField.CENTER);
		tfAdmin500Coin.setText("0");

		// **p1.1����
		JPanel pan11 = new JPanel();
		pan11.setLayout(new BoxLayout(pan11, BoxLayout.Y_AXIS));

		JPanel pan111 = new JPanel();
		JPanel pan112 = new JPanel();

		img100 = new ImageIcon("img/100full.png");
		labimg100 = new JLabel();
		labimg100.setIcon(img100);

		// ***p1.1.1����
		pan111.add(labimg100);
		// ***p1.1.2����
		pan112.add(new JLabel("100��"));
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
		pan112.add(new JLabel("��"));

		pan11.add(pan111);
		pan11.add(pan112);

		panelAdminView.add(pan11);

		// **p1.2����
		JPanel pan12 = new JPanel();
		pan12.setLayout(new BoxLayout(pan12, BoxLayout.Y_AXIS));

		JPanel pan121 = new JPanel();
		JPanel pan122 = new JPanel();

		img500 = new ImageIcon("img/500null.png");// 500�� ���� �� �׸�*** (����)
		labimg500 = new JLabel();
		labimg500.setIcon(img500);

		// ***p1.2.1����
		pan121.add(labimg500);
		// ***p1.2.2����
		pan122.add(new JLabel("500��"));
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
		pan122.add(new JLabel("��"));

		pan12.add(pan121);
		pan12.add(pan122);

		panelAdminView.add(pan12);

		// *p1������ ��

		// *p2 start
		// admin panel tab 2
		panelAdminOpen = new JPanel();
		panelAdminOpen
				.setLayout(new BoxLayout(panelAdminOpen, BoxLayout.Y_AXIS));

		// **p2.1
		JPanel pan21 = new JPanel();
		pan21.add(new JLabel("������ �� ���ٱ���"));
		panelAdminOpen.add(pan21);

		tfPassStatus = new JTextField(15);
		tfPassStatus.setText("��й�ȣ �Է�");
		tfPasswords = new JPasswordField(15);
		btnPassConfirm = new JButton("Ȯ��");
		btnPassConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// ��й�ȣ Ȯ���ϱ�
				c.admin_key();
			}
		});
		btnRefill = new JButton("��� ����");
		btnRefill.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// ��� �����ϱ�
				c.coin_refill();
			}
		});
		btnRefill.setEnabled(false);
		btnGather = new JButton("����� ����");
		btnGather.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ����� �����ϱ�
				c.coin_gather();
			}
		});
		btnGather.setEnabled(false);
		btnAdminExit = new JButton("������ ������");
		btnAdminExit.setEnabled(false);
		btnAdminExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ������ ������
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
		JPanel pan23 = new JPanel();// ����Ʈ ��ġ�����ڴ� �÷ο췹�̾ƿ�
		pan23.add(btnRefill);
		pan23.add(btnGather);
		pan23.add(btnAdminExit);
		panelAdminOpen.add(pan23);

		tabAdmin.addTab("������", panelAdminView);
		tabAdmin.addTab("��  ��", panelAdminOpen);
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
		btnTakeCoin = new JButton("���� �����");
		btnTakeCoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 100�� �����
				c.take_coin();
			}
		});

		btnTakeCoin.setEnabled(false);
		coins = new JPanel(new GridLayout(0, 10));
		//��� �迭 ���� �� ���� ���⼭ ��ü ����
		for (int i = 0; i < 50; i++) {
			labimgOutCoin[i] = new JLabel();
		}
		img100out = new ImageIcon("img/out100_30x30.png");
		panelOutput.add(coins);

		JPanel panelOneHundred = new JPanel();
		panelOneHundred.add(new JLabel("���"));
		panelOneHundred.add(tfOutCoin);
		panelOneHundred.add(new JLabel("��"));
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
		//���α׷� ù ���ô� 500�� ���� 0�� 100�� ���� full
		Model m = new Model(0);
		//�� Ŭ������ ��ü�� ��Ʈ�ѷ��� ����
		Controller c = new Controller(m);
		//��Ŭ������ ��ü ���� �� ��Ʈ�ѷο� ����
		View v = new View(c);
	}

}

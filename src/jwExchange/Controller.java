package jwExchange;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

//���
public class Controller {
	private View v;
	private Model m;

	public Controller(Model m) {
		this.m = m;
	}

	public void connect_view(View v) {
		this.v = v;
	}

	/*
	 * ��
	 */
	// 500�� ��
	public void in500_output() {
		m.user500in = m.user500in + 1;
		v.tfInCoin.setText(Integer.toString(m.user500in * 500));
		if (m.user500in * 500 > m.admin100 * 100) {
			v.tfStatus.setText("��ȯ�Ұ�");
			v.btnExchangeCoin.setEnabled(false);
		}
	}

	// 500�� ��ȯ ���
	public void exchane_cancel() {
		m.user500in = 0;
		v.tfInCoin.setText(Integer.toString(0));
		v.tfStatus.setText("��ȯ����");
		v.btnExchangeCoin.setEnabled(true);

	}

	// 100�� �����
	public void take_coin() {

		v.tfOutCoin.setText("");
		v.btnExchangeCoin.setEnabled(true);
		v.btnCancel.setEnabled(true);
		for (int i = 0; i < 50; i++) {
			v.labimgOutCoin[i].setIcon(null);
		}
	}

	// <��ȯ�ϱ�>
	public void coin_exchange() {
		v.tfInCoin.setText(Integer.toString(0));
		for (int i = 0; i < m.user500in; i++) {
			System.out.println("(500)");
			m.admin500.push("(500)");
			m.admin100 = m.admin100 - 5;
		}
		v.tfAdmin500Coin.setText(Integer.toString(m.admin500.size()));
		v.tfAdmin100Coin.setText(Integer.toString(m.admin100));
		v.tfOutCoin.setText(Integer.toString(m.user500in * 5));
		m.user500in = 0;
		v.btnExchangeCoin.setEnabled(false);
		v.btnCancel.setEnabled(false);

		for (int i = 0; i < Integer.parseInt(v.tfOutCoin.getText()); i++) {
			v.labimgOutCoin[i].setIcon(v.img100out);// �������� ���̺� �����
			v.coins.add(v.labimgOutCoin[i]);// ���̺��� �гο� ���̱�
		}
	}

	/*
	 * ������
	 */
	// ��й�ȣ �Է�
	public void admin_key() {
		if (v.tfPasswords.getText().equals(m.PASS)) {
			v.tfPassStatus.setText("��й�ȣ ��ġ - ������ ����");
			v.btnRefill.setEnabled(true);
			v.btnGather.setEnabled(true);
			v.btnAdminExit.setEnabled(true);
		} else {
			v.tfPassStatus.setText("��й�ȣ ����ġ");
			v.tfPasswords.setText("");
		}
	}

	// 500�� ȸ��pop
	public void coin_gather() {
		while (!m.admin500.isEmpty()) {
			System.err.println(m.admin500.pop());
			v.tfAdmin500Coin.setText(Integer.toString(m.admin500.size()));
			exchange_possible();
		}
	}

	// ������ ��� ���
	public void admin_exit() {
		v.tfPassStatus.setText("������ ��� ����");
		v.tfPasswords.setText("");
		v.btnRefill.setEnabled(false);
		v.btnGather.setEnabled(false);
		v.btnAdminExit.setEnabled(false);
	}

	// 100�� ����
	public void coin_refill() {
		m.admin100 = 50;
		v.tfAdmin100Coin.setText(Integer.toString(m.admin100));
		exchange_possible();
	}

	// ���ǿ� �´ٸ� ���¸޼���&�����ֱ��ư Ȱ��ȭ
	public void exchange_possible() {
		if (m.admin100 > 0 && m.admin500.size() < 10) {
			v.btnInCoin.setEnabled(true);
			v.tfStatus.setText("��ȯ����");
		}
	}

	// ������ 100�� ��
	public void amount_100() {

		if (m.admin100 == 50) {
			ImageIcon im = new ImageIcon("img/100full.png");
			v.labimg100.setIcon(im);
			v.btnTakeCoin.setEnabled(true);
			v.btnExchangeCoin.setEnabled(true);
			v.btnCancel.setEnabled(true);
		} else if (m.admin100 < 50 && m.admin100 >= 50 * 0.7) {
			ImageIcon im = new ImageIcon("img/100drop.png");
			v.labimg100.setIcon(im);
		} else if (m.admin100 < 50 * 0.7 && m.admin100 >= 50 * 0.4) {
			ImageIcon im = new ImageIcon("img/100half.png");
			v.labimg100.setIcon(im);
		} else if (m.admin100 < 50 * 0.4 && m.admin100 > 0) {
			ImageIcon im = new ImageIcon("img/100small.png");
			v.labimg100.setIcon(im);
		} else if (m.admin100 == 0) {
			ImageIcon im = new ImageIcon("img/100null.png");
			v.labimg100.setIcon(im);
			v.btnExchangeCoin.setEnabled(false);
			v.btnInCoin.setEnabled(false);
			v.tfStatus.setText("��ȯ�Ұ�");
		}
	}

	// ������ 500�� ��
	public void amount_500() {

		if (m.admin500.size() >= 10) {
			ImageIcon im = new ImageIcon("img/500full.png");
			v.labimg500.setIcon(im);
			v.btnExchangeCoin.setEnabled(false);
			v.btnInCoin.setEnabled(false);
			v.tfStatus.setText("��ȯ�Ұ�");
		} else if (m.admin500.size() < 10 && m.admin500.size() >= 10 * 0.7) {
			ImageIcon im = new ImageIcon("img/500almost.png");
			v.labimg500.setIcon(im);
		} else if (m.admin500.size() < 10 * 0.7
				&& m.admin500.size() >= 10 * 0.4) {
			ImageIcon im = new ImageIcon("img/500half.png");
			v.labimg500.setIcon(im);
		} else if (m.admin500.size() < 10 * 0.4 && m.admin500.size() > 0) {
			ImageIcon im = new ImageIcon("img/500add.png");
			v.labimg500.setIcon(im);
		} else if (m.admin500.size() == 0) {
			ImageIcon im = new ImageIcon("img/500null.png");
			v.labimg500.setIcon(im);
		}

	}
}

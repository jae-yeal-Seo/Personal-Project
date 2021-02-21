package ch05_2.oop;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Your_Alarcity extends JFrame implements KeyListener,ActionListener,MouseListener{
	private JPanel p1,p2,p3;
	private CardLayout cards;
	private Timer exit = new Timer();
//	���������� �ʿ��� �ʵ�
	private JButton button1;
	private Random ran = new Random();
	private int[] check = new int[50];
	private int counter= 0;
	private JLabel label;
	private JTextField tf;
	private JLabel result;
	private JLabel plusnews;
	private JLabel[] labels = {new JLabel("������"),new JLabel("������"),new JLabel("�������̽�"),new JLabel("���ٽ�"),new JLabel("��Ű��"), 
			new JLabel("���� �޼ҵ�"),new JLabel("�޼ҵ�"),new JLabel("Ŭ����"),new JLabel("�ݺ���"),new JLabel("���ǹ�"),
			new JLabel("����Ʈ �޼ҵ�"),new JLabel("ĸ��ȭ"),new JLabel("�ڹ�"),new JLabel("���α׷���"),new JLabel("���"),
			new JLabel("����������"),new JLabel("����������"),new JLabel("�θ� Ŭ����"),new JLabel("�ڽ�Ŭ����"),new JLabel("�߻�ȭ"),
			new JLabel("������"),new JLabel("�����޼ҵ�"),new JLabel("�׷��� ����� �������̽�"),new JLabel("�迭"),new JLabel("ArrayList")
			,new JLabel("���׵�迭"),new JLabel("��ü"),new JLabel("�ʵ�"),new JLabel("��ü ���� ���α׷���"),new JLabel("���� �޸�")
			,new JLabel("������ ����"),new JLabel("�ڹ� ������"),new JLabel("��Ŭ����"),new JLabel("�޼ҵ� �����ε�"),new JLabel("�޼ҵ� �������̵�")
			,new JLabel("������ �����ε�"),new JLabel("���� Ŭ����"),new JLabel("������"),new JLabel("���� ��ư"),new JLabel("�ؽ�Ʈ �ʵ�")
			,new JLabel("�޺� �ڽ�"),new JLabel("�����̴�"),new JLabel("�����"),new JLabel("�ܾ�"),new JLabel("�α�")
			,new JLabel("���� ��Ʈ��"),new JLabel("����ȭ"),new JLabel("��Ƽ������"),new JLabel("���ϵ�ī��"),new JLabel("���׸�")
	};
//	ù��° ����, ���� ����� ���� �ʵ�
	private JLabel[] labels2 = {new JLabel("O"),new JLabel("O"),new JLabel("O"),new JLabel("O"),new JLabel("O"),
			new JLabel("O"),new JLabel("O"),new JLabel("O"),new JLabel("O"),new JLabel("O"),
			new JLabel("O"),new JLabel("O"),new JLabel("O"),new JLabel("O"),new JLabel("O"),
			new JLabel("O"),new JLabel("O"),new JLabel("O"),new JLabel("O"),new JLabel("O"),
			new JLabel("O"),new JLabel("O"),new JLabel("O"),new JLabel("O"),new JLabel("O"),
			new JLabel("O"),new JLabel("O"),new JLabel("O"),new JLabel("O"),new JLabel("O"),
	};
	private int counter2 = 0;
	private int totalScore=0;
	private JButton button2;
	private JLabel label2;
//	�ι�° ����, ���� ����� ���� �ʵ�
	
	Your_Alarcity(){
		cards = new CardLayout();
		setLayout(cards);
//		��ü����
		button1 = new JButton("��ư�� Ŭ���ϸ� �����մϴ�.");
		button1.setFont(new Font("",Font.BOLD,20));
		button1.setBackground(Color.black);
		button1.setForeground(Color.white);
		button1.setBounds(80,200,600,60);
		button1.addActionListener(this);
		p1 = new JPanel();
		p1.setLayout(null);
		p1.add(button1);
		add(p1);
//		ù��° ���
		for(int i=0;i<50;i++) {
			check[i]=0;
		}
		p2 = new JPanel();
		p2.setLayout(null);
		label = new JLabel("���ڵ��� ���� ġ����! 20�� �帳�ϴ�!");
		label.setFont(new Font("",Font.BOLD,20));
		label.setBounds(230,0,360,25);
		label.setBackground(Color.red);
		label.setOpaque(true);
		p2.add(label);
		int rannum = 0;
		for(int i=0;i<30;i++) {
			while(true){
				rannum = ran.nextInt(50);
				if(check[rannum]==0) {
					check[rannum]=1;
					break;
				}
			}
			int x = (int)(Math.random()*680);
			int y = (int)(Math.random()*450+25);

			labels[rannum].setBounds(x,y,150,15);
			p2.add(labels[rannum]);
		}
		tf = new JTextField();
		tf.setBounds(140,530,500,25);
		tf.setBackground(Color.black);
		tf.setForeground(Color.white);
		tf.addKeyListener(this);
		p2.add(tf);
		add(p2);
//		�ι�° ���
		TimerTask work = new TimerTask() {
			@Override
			public void run() {
				label.setVisible(false);
				tf.setVisible(false);
				for(int i=0;i<50;i++) {
					labels[i].setVisible(false);
				}
				result = new JLabel(counter+"���� ���߼̽��ϴ�!("+counter*100+"��)");
				plusnews = new JLabel("��ư�� ������ ���ο� ������ �����մϴ�");
				totalScore = counter*100;
				result.setFont(new Font("",Font.BOLD,30));
				plusnews.setFont(new Font("",Font.BOLD,30));
				p2.add(result);
				p2.add(plusnews);
				result.setBounds(200,190,800,50);
				plusnews.setBounds(120,250,800,50);
				button2.setFont(new Font("",Font.BOLD,25));
				button2.setBounds(190,320,400,50);
			}
		};
		exit.schedule(work,20000);
		button2 = new JButton("���� ������ �����մϴ�.");
		button2.addActionListener(this);
		p2.add(button2);
//		����° ���
		p3 = new JPanel();
		p3.setLayout(null);
		label2 = new JLabel("���� ������ Ŭ���ϼ���! 10�� �帳�ϴ�!");
		label2.setFont(new Font("",Font.BOLD,20));
		label2.setBackground(Color.red);
		label2.setOpaque(true);
		label2.setForeground(Color.white);
		label2.setBounds(200,0,370,20);
		p3.add(label2);
		add(p3);
		for(int i=0;i<30;i++) {
			int x = (int) (Math.random()*800);
			int y = (int) (Math.random()*450+100);
			labels2[i].setBounds(x,y,20,20);
			p3.add(labels2[i]);
			labels2[i].addMouseListener(this);
		}
//		�׹�° ���
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
		
	}
	public static void main(String[] args) {
		new Your_Alarcity();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1) {
			cards.next(Your_Alarcity.this.getContentPane());
		}
		else if(e.getSource()==button2) {
			cards.next(Your_Alarcity.this.getContentPane());
			TimerTask fourthGameEnd = new TimerTask() {
				@Override
				public void run() {
					for(int i=0;i<30;i++) {
						label2.setVisible(false);
						labels2[i].setVisible(false);
					}
					label = new JLabel("�ι�° ������ ������"+counter2*100+"���Դϴ�!");
					label.setFont(new Font("",Font.BOLD,40));
					label.setBounds(70,220,800,40);
					label2 = new JLabel("����"+(counter*100+counter2*100)+"��!");
					label2.setFont(new Font("",Font.BOLD,40));
					label2.setBounds(280,260,800,40);
					p3.add(label);
					p3.add(label2);
				}
			};
			exit.schedule(fourthGameEnd, 10000);
		}
	}
//	button1 -> ù��° ���� ������ ���� ��ư  
//	button2 -> �ι�° ����, ������� ����


	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			int i=0;
			while(true) {
				if(labels[i].getText().equals(tf.getText())) {
					labels[i].setVisible(false);
					tf.setText("");
					counter++;
					break;
				}
				i++;
			}
		}
	}
//	VK_ENTER -> Ÿ�� �Է� �Ϸ� ���� ��
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
//	KeyListener�� �޼ҵ��
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {
		for(int i=0;i<50;i++) {
			if(e.getSource()==labels2[i]) {
				counter2++;
				labels2[i].setVisible(false);
			}
		}
	}
//	���� �� Ŭ������ ��
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
//	MouseListener�� �޼ҵ��
}
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class YourAlarcityPanel extends JPanel implements ActionListener,KeyListener{
	private Random ran = new Random();
	private JLabel label = new JLabel();
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
	private JButton button;
	private int[] check = new int[50];
	private JTextField tf = new JTextField();
	private Timer exit = new Timer();
	private Timer second = new Timer();
	private int counter=0;
	private JLabel result;
	private int totalScore=0;
	private JLabel plusnews;
	
	private BufferedImage img = null;
	


	YourAlarcityPanel() {


		for(int i=0;i<50;i++) {
			check[i]=0;	
		}

		
		button = new JButton("��ư�� ������ �����մϴ�.");
		button.setFont(new Font("",Font.BOLD,20));
		setLayout(null);
		button.setBounds(230,230,400,60);
		button.setBackground(Color.black);
		button.setForeground(Color.white);
		add(button);
		button.addActionListener(this);
		

	}
//	���� ȭ�� ����



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			
			if(e.getSource()==button) {
				button.setVisible(false);
				label.setText("���ڵ��� ���� ġ����! 20�� �帳�ϴ�!");
				label.setFont(new Font("",Font.BOLD,20));
				label.setBounds(260,0,360,25);
				label.setBackground(Color.red);
				label.setOpaque(true);
				add(label);
				

				int rannum=0;

				for(int i=0;i<30;i++) {
					while(true){
						
						rannum = ran.nextInt(50);
						if(check[rannum]==0) {
							check[rannum]=1;
							break;
						}
					}
					this.updateUI();
					int x = (int)(Math.random()*720);
					int y = (int)(Math.random()*600+25);

					labels[rannum].setBounds(x,y,150,15);
					add(labels[rannum]);
				
				}
				add(tf);
				tf.setBackground(Color.black);
				tf.setOpaque(true);
				tf.setBounds(230,630,400,28);
				tf.setForeground(Color.white);
				tf.addKeyListener(this);
				
				TimerTask work = new TimerTask() {
					@Override
					public void run() {
						
						label.setVisible(false);
						tf.setVisible(false);
						for(int i=0;i<50;i++) {
							labels[i].setVisible(false);
						}
						result = new JLabel(counter+"���� ���߼̽��ϴ�!("+counter*100+"��)");
						plusnews = new JLabel("5�� �ڿ� ���ο� ������ �����մϴ�!");
						totalScore = counter*100;
						result.setFont(new Font("",Font.BOLD,30));
						plusnews.setFont(new Font("",Font.BOLD,30));
						add(result);
						add(plusnews);
						result.setBounds(220,220,800,50);
						plusnews.setBounds(150,280,800,50);
						setVisible(true);
					}
					
				};
				exit.schedule(work,20000);
				
				TimerTask secondWork = new TimerTask() {
					public void run() {
					SecondGame();
					}
				};
				second.schedule(secondWork, 25000);
			}
			
		}
	}
//	ù��° ����

	void SecondGame() {
		result.setVisible(false);
		plusnews.setVisible(false);
		label = new JLabel("�ִ��� ���� ���� Ŭ���ϼ���! 10�� �帳�ϴ�!");
		label.setFont(new Font("",Font.BOLD,20));
		label.setBounds(200,0,425,30);
		label.setBackground(Color.red);
		label.setOpaque(true);
		add(label);
		repaint();
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		int x = (int)(Math.random()*800);
		int y = (int)(Math.random()*700);
		g.fillOval(x, y, 30, 30);
		g.setColor(Color.blue);
	}
//	�ι�° ����
	
//	�׸��׸���

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
//	Enter�� ������ ���� ����
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	
}

public class YourAlarcity extends JFrame{
	public YourAlarcity() {
		add(new YourAlarcityPanel());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900,700);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new YourAlarcity();
	}
}
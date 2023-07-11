package ch25_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIMain2 extends JFrame {

	private JPanel mainCardPane;
	private CardLayout mainCardLayout; //cardLayout 만들기
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMain2 frame = new GUIMain2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public GUIMain2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		
		/* <<<mainCardPane>>> */
		mainCardPane = new JPanel();
		mainCardLayout = new CardLayout(0,0); //cardLayout 쓰려면 setLayout() 안에 new card.. 하지 말고 변수 따로 생성하기
		
		mainCardPane.setBorder(new EmptyBorder(5, 5, 5, 5));//신경 안써도됨
		mainCardPane.setLayout(mainCardLayout);//
		//변수 안에 넣었기 때문에 다른 메소드들을 쓸 수 있음.

		setContentPane(mainCardPane); //프레임 안에 메인 패널을 넣음 그 메인 패널로 mainCardPane을 넣음
		
		
		/* <<<subPanel1>>> */
		JPanel subPanel1 = new JPanel(); //cardPane에 subpanel을 추가
		mainCardPane.add(subPanel1, "subPanel1");
		subPanel1.setLayout(null);
		//버튼 생성
		JButton SubPanel2showBtn = new JButton("2 페이지"); //3->2페이지로 갈때도 이 버튼 쓰면 됨
		SubPanel2showBtn.setBounds(315, 121, 97, 23);
		subPanel1.add(SubPanel2showBtn); //서브패널에 버튼을 추가
		
		
		SubPanel2showBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCardLayout.show(mainCardPane, "subPanel2"); //mainCardPane 안에 있는 것들 중에서 subpanel2를 보여준다는 의미
			}
		});
		
	
		/* <<< subPanel2 >>> */
		JPanel subPanel2 = new JPanel();
		mainCardPane.add(subPanel2, "subPanel2");
		subPanel2.setLayout(null);
		
		JButton subPanel1showBtn = new JButton("1 페이지");
		subPanel1showBtn.setBounds(12, 113, 97, 23);
		subPanel2.add(subPanel1showBtn);
		
		JButton subpanel3showBtn = new JButton("3 페이지");
		subpanel3showBtn.setBounds(315, 113, 97, 23);
		subPanel2.add(subpanel3showBtn);
		
		subPanel1showBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCardLayout.show(mainCardPane, "subPanel1");
			}
		});
		
		subpanel3showBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCardLayout.show(mainCardPane, "subPanel3");
			}
		});
		
		/* <<< subPanel3 >>> */
		JPanel subPanel3 = new JPanel();
		mainCardPane.add(subPanel3, "subPanel3");
		subPanel3.setLayout(null);
		
		JButton subPanel2ShowBtn2 = new JButton("2 페이지");
		subPanel2ShowBtn2.setBounds(12, 118, 97, 23);
		subPanel3.add(subPanel2ShowBtn2);
		
		subPanel2ShowBtn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCardLayout.show(mainCardPane, "subPanel2");
			}
		});
		
		
		
	}

}

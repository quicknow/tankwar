package com.tankwar;


import java.awt.*;

import javax.swing.*;

public class TestDraw extends JFrame{
	MyPanel mp = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestDraw tjl1 = new TestDraw();
	}
	
	public TestDraw(){

		mp = new MyPanel();	
		
		this.add(mp);
		this.setVisible(true);		
		this.setLocation(300, 200);
		this.setSize(300, 200);
		this.setTitle("HelloWorld");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MyPanel extends JPanel{
	
	//ע�⣬new ��MyPanelʵ��ʱ ���Ѿ�ִ���˻��Ķ���,����JFrame�Ϳ����ˡ�
	public void paint(Graphics g){
		super.paint(g);
		//g.drawRect(10, 10, 30, 30);
		
		//��ͼƬ
		//Image im = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/11.jpg"));
		//g.drawImage(im, 10, 10, 100, 150,this);
		
		//������
		g.setColor(Color.BLUE);
		//��������
		g.setFont(new Font("����",Font.BOLD,30));
		g.drawString("��������",60, 60);
	}
}


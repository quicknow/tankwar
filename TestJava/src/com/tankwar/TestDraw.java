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
	
	//注意，new 出MyPanel实例时 就已经执行了画的动作,加入JFrame就可以了。
	public void paint(Graphics g){
		super.paint(g);
		//g.drawRect(10, 10, 30, 30);
		
		//画图片
		//Image im = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/11.jpg"));
		//g.drawImage(im, 10, 10, 100, 150,this);
		
		//画文字
		g.setColor(Color.BLUE);
		//设置字体
		g.setFont(new Font("隶书",Font.BOLD,30));
		g.drawString("自由万岁",60, 60);
	}
}


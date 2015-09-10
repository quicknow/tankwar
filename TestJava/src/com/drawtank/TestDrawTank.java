package com.drawtank;

import java.awt.*;

import javax.swing.*;

public class TestDrawTank extends JFrame{
	MyPanel mp = null;	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestDrawTank tjl1 = new TestDrawTank();
	}
	
	public TestDrawTank(){
	
		mp = new MyPanel();			
		//注意，new 出MyPanel实例时 就已经执行了画的动作,加入JFrame就可以了
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
	Hero hero = null;
	
	public MyPanel(){
		hero = new Hero(10,10);
		
		
	}
	
	
	public void paint(Graphics g){
		super.paint(g);
		//g.drawRect(10, 10, 30, 30);
		
		//画图片
		//Image im = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/11.jpg"));
		//g.drawImage(im, 10, 10, 100, 150,this);
		
		//画文字
		//g.setColor(Color.BLUE);
		//设置字体
		//g.setFont(new Font("隶书",Font.BOLD,30));
		//g.drawString("自由万岁",60, 60);
		
		//画出我的坦克
		
		g.fillRect(0, 0, 400, 300);//确定区域为400 300 背景为黑色值
		
		//使用画坦克方法画出坦克
		this.drawTank(hero.getX(), hero.getY(), g, 0, 0);
		
	}
	
	public void drawTank(int x,int y,Graphics g,int direct,int type){
		
		switch(type){
		case 0:
			g.setColor(Color.YELLOW); //0 定义为英雄 颜色设置成黄色
			break;
		case 1:
			g.setColor(Color.CYAN); //1定义为敌人 颜色设置成CYAN色
			break;
		}
		
		switch(direct){
		case 0: //0定位为向上
			g.fill3DRect(x, y, 5, 30,false); //画出左边矩形		
			g.fill3DRect(x+15, y, 5, 30,false); //画出右边矩形
			g.fill3DRect(x+5, y+5, 10, 20,false);//画出中间矩形	
			g.fillOval(x+5, y+9, 10, 10); //画出中间圆
			g.drawLine(x+10, y+15, x+10, y);
		
		}
		
		
	}
	
}


class Tank{
	int x=0;
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	int y=0;
	
	
	public Tank(int x,int y){
		this.x=x;
		this.y=y;		
	}
	
}

class Hero extends Tank{
	
	public Hero(int x,int y){
	//调用父类的构造函数来初始化子类的成员变量
		super(x,y);
	}
	
}




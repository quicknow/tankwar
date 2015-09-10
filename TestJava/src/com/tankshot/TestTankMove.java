package com.tankshot;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import java.util.*;

public class TestTankMove extends JFrame{
	MyPanel mp = null;	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestTankMove tjl1 = new TestTankMove();
	}
	
	public TestTankMove(){
	
		mp = new MyPanel();			
		//注意，new 出MyPanel实例时 就已经执行了画的动作,加入JFrame就可以了
		this.add(mp);
		
		//启动画布的线程
		Thread t = new Thread(mp);
		t.start();
		//注册监听
		this.addKeyListener(mp);
		
		this.setVisible(true);		
		this.setLocation(300, 200);
		this.setSize(400, 300);
		this.setTitle("HelloWorld");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


//我的画布
class MyPanel extends JPanel implements KeyListener,Runnable{
	Hero hero = null;
	
	//定义敌人的坦克集合
	Vector<EnemyTank> ets = new Vector();
	int enemysize = 3;
	
	
	
	public MyPanel(){
		hero = new Hero(10,100);
		
		for(int i=0;i<enemysize;i++){
			//创建一辆敌人的坦克
			EnemyTank et = new EnemyTank((i+1)*50,0);
			et.setColor(1);
			et.setDirect(2);
			ets.add(et);
		}
		
	}
	
	
	public void paint(Graphics g){
		super.paint(g);

		
		//画出我的坦克		
		g.fillRect(0, 0, 400, 300);//确定区域为400 300 背景为黑色值
		
		//使用画坦克方法画出坦克
		this.drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
		
		//造出多颗子弹
		for(int i=0;i<hero.ss.size();i++){
			Shot myshot = hero.ss.get(i);
			if(myshot!=null&&myshot.islive==true){
				g.draw3DRect(myshot.x, myshot.y, 1, 1, false);
			}
			
			//如果集合中的子弹死亡了，则从集合中删除
			if(myshot.islive==false){
				hero.ss.remove(i);
			}
		}	
		
		//画出敌人的坦克
		for(int i=0;i<ets.size();i++){
			this.drawTank(ets.get(i).getX(), ets.get(i).getY(), g, ets.get(i).getDirect(), 1);
			
		}
		
	}
	
	
	public void drawTank(int x,int y,Graphics g,int direct,int type){
		
		switch(type){
		case 0:
			g.setColor(Color.YELLOW); //0 定义为英雄 颜色设置成黄色
			break;
		case 1:
			g.setColor(Color.BLUE); //1定义为敌人 颜色设置成CYAN色
			break;
		}
		
		switch(direct){
		case 0: //0定位为向上
			g.fill3DRect(x, y, 5, 30,false); //画出左边矩形		
			g.fill3DRect(x+15, y, 5, 30,false); //画出右边矩形
			g.fill3DRect(x+5, y+5, 10, 20,false);//画出中间矩形	
			g.fillOval(x+5, y+9, 10, 10); //画出中间圆
			g.drawLine(x+10, y+15, x+10, y);
			break;
			
		case 1: //定义1为向右
			g.fill3DRect(x, y, 30, 5,false); //画出上部矩形		
			g.fill3DRect(x, y+15, 30, 5,false); //画出下部矩形
			g.fill3DRect(x+5, y+5, 20, 10,false);//画出中间矩形	
			g.fillOval(x+10, y+5, 10, 10); //画出中间圆
			g.drawLine(x+15, y+10, x+30, y+10);
			break;
		case 2://向下
			g.fill3DRect(x, y, 5, 30,false); //画出左边矩形		
			g.fill3DRect(x+15, y, 5, 30,false); //画出右边矩形
			g.fill3DRect(x+5, y+5, 10, 20,false);//画出中间矩形	
			g.fillOval(x+5, y+9, 10, 10); //画出中间圆
			g.drawLine(x+10, y+15, x+10, y+30);
			break;
		
		case 3:
			g.fill3DRect(x, y, 30, 5,false); //画出上部矩形		
			g.fill3DRect(x, y+15, 30, 5,false); //画出下部矩形
			g.fill3DRect(x+5, y+5, 20, 10,false);//画出中间矩形	
			g.fillOval(x+10, y+5, 10, 10); //画出中间圆
			g.drawLine(x+15, y+10, x, y+10);		
			break;
		}
		
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override //a表示向左，w表示向上，d表示右，s表示向下
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_W){
			//设置坦克的方向
			this.hero.setDirect(0);	
			this.hero.moveUp();
			
		} else if(e.getKeyCode()==KeyEvent.VK_D){
			this.hero.setDirect(1);	
			this.hero.moveRight();
			
		}else if(e.getKeyCode()==KeyEvent.VK_S){
			this.hero.setDirect(2);	
			this.hero.moveDown();
			
		}else if(e.getKeyCode()==KeyEvent.VK_A){
			
			this.hero.setDirect(3);	
			this.hero.moveLeft();
		}	
		
		if(e.getKeyCode()==KeyEvent.VK_J) {
			if(hero.ss.size()<5){
				this.hero.shotEnemy();
			}	
		}
		
		this.repaint();
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this.repaint();
		}
	}
	
	
	
}



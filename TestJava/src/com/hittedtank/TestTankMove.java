package com.hittedtank;

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
	Image image1 =null;
	Image image2 =null;
	Image image3 =null;
	
	//定义敌人的坦克集合
	Vector<EnemyTank> ets = new Vector();
	int enemysize = 3;	
	
	
	//创建一个炸弹集合
	Vector<Bomb> bombs = new Vector();
	
	public MyPanel(){
		hero = new Hero(10,100);
		//heros.add(hero);
		image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.jpg"));
		image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.jpg"));
		image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.jpg"));
		
		for(int i=0;i<enemysize;i++){
			//创建一辆敌人的坦克
			EnemyTank et = new EnemyTank((i+1)*50,0);
			et.setColor(1);
			et.setDirect(2);
			ets.add(et);
			
			Thread t =new Thread(et);
			t.start();
		}
		
	}
	
	
	public void paint(Graphics g){
		super.paint(g);
				
		
		//画出我的坦克		
		g.fillRect(0, 0, 400, 300);//确定区域为400 300 背景为黑色值
		
		//使用画坦克方法画出坦克
		if(hero.islive==true) {
			this.drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
			} 
		
		//画出英雄的多颗子弹
		for(int i=0;i<hero.ss.size();i++){
			Shot myshot = hero.ss.get(i);
			if(myshot.islive==true){
				g.draw3DRect(myshot.x, myshot.y, 1, 1, false);
			}
			
			//如果集合中的子弹死亡了，则从集合中删除
			if(myshot.islive==false){
				hero.ss.remove(i);
			}
		}	
		
		//画出敌人的坦克 和 子弹
		for(int i=0;i<ets.size();i++){
			EnemyTank et = ets.get(i);
			if(et.islive!=false) {
				this.drawTank(et.getX(), et.getY(), g, et.getDirect(), 1);
			}
			
			//画出敌人每辆坦克发射的子弹
			for(int j=0;j<et.Enemyshots.size();j++){
				Shot s = et.Enemyshots.get(j);
				if(s.islive==true){
					g.draw3DRect(s.x, s.y, 1, 1, false);
				}else{et.Enemyshots.remove(s);}
				
				
			}
		}
		
		//画出炸弹
		for(int i=0;i<bombs.size();i++){
			Bomb b = bombs.get(i);
			if(b.life>6){
				g.drawImage(image1, b.x, b.y, 30, 30,this);
				//System.out.println("第一次炸弹爆炸");
			}else if(b.life>3){
				g.drawImage(image2, b.x, b.y, 30, 30,this);
				//System.out.println("第二次炸弹爆炸了");
			}else if(b.life>0){
				g.drawImage(image3, b.x, b.y, 30, 30,this);
				//System.out.println("第三次炸弹爆炸了");
			}
			b.lifedown();
			
			if(b.life<=0){
				b.islive=false;
				bombs.remove(b);
			}
			
		}
		
		//判断英雄的子弹是否击中敌人
		for(int i=0;i<hero.ss.size();i++){
			Shot s = hero.ss.get(i);
			for(int j=0;j<ets.size();j++){
				 EnemyTank et =ets.get(j);
				 this.is_hittedtank(s, et);
				 
				 if(s.islive==false){
					 hero.ss.remove(s);
				 }
				 
				 if(et.islive==false){
					 ets.remove(et);
				 }
			}
		}
		
		//判断敌人的子弹是否击中英雄
		for(int i=0;i<ets.size();i++){
			EnemyTank et = ets.get(i);
			for(int j=0;j<et.Enemyshots.size();j++){
				Shot s = et.Enemyshots.get(j);
				this.is_hittedtank(s, hero);
				
				 if(s.islive==false){
					 et.Enemyshots.remove(s);
				 }
				 
				
				 
				 
			}
		}
		
		
		
	}
	
	//判断子弹是否击中敌人的坦克方法
	public void is_hittedtank(Shot s,Tank et){
		if(et.islive==true&&s.islive==true){
			switch(et.direct){
				case 0:
				case 2:
					if((s.x>et.x)&&(s.x<(et.x+20))&&(s.y>et.y)&&(s.y<(et.y+30))){
						s.islive=false;
						et.islive=false;
						Bomb bomb = new Bomb(et.x,et.y);//每击中敌人的坦克则产生一颗炸弹
						bombs.add(bomb);
					}
				break;
				
				case 1:
				case 3:	
					if(s.x>et.x&&s.y>et.y&&s.y<et.y+20&&s.x<et.x+30){
						s.islive=false;
						et.islive=false;
						Bomb bomb = new Bomb(et.x,et.y);//每击中敌人的坦克则产生一颗炸弹
						bombs.add(bomb); //加入到炸弹集合中
				}
				break;		
			}
		
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
			if(this.hero.y>0&&this.hero.islive==true){
				this.hero.moveUp();
			}
			
		} else if(e.getKeyCode()==KeyEvent.VK_D&&this.hero.islive==true){
			this.hero.setDirect(1);	
			if(this.hero.x<363){
				this.hero.moveRight();
				//System.out.println(this.hero.x);
			}
			
		}else if(e.getKeyCode()==KeyEvent.VK_S&&this.hero.islive==true){
			this.hero.setDirect(2);
			if(this.hero.y<242){
			this.hero.moveDown();
			//System.out.println(this.hero.y);
			
			}
			
		}else if(e.getKeyCode()==KeyEvent.VK_A&&this.hero.islive==true){
			
			this.hero.setDirect(3);	
			if(this.hero.x>0){
				this.hero.moveLeft();
			}
		}	
		
		if(e.getKeyCode()==KeyEvent.VK_J&&this.hero.islive==true) {
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



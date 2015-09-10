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
		//ע�⣬new ��MyPanelʵ��ʱ ���Ѿ�ִ���˻��Ķ���,����JFrame�Ϳ�����
		this.add(mp);
		
		
		
		//�����������߳�
		Thread t = new Thread(mp);
		t.start();
		//ע�����
		this.addKeyListener(mp);
		
		this.setVisible(true);		
		this.setLocation(300, 200);
		this.setSize(400, 300);
		this.setTitle("HelloWorld");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


//�ҵĻ���
class MyPanel extends JPanel implements KeyListener,Runnable{
	Hero hero = null;
	Image image1 =null;
	Image image2 =null;
	Image image3 =null;
	
	//������˵�̹�˼���
	Vector<EnemyTank> ets = new Vector();
	int enemysize = 3;	
	
	
	//����һ��ը������
	Vector<Bomb> bombs = new Vector();
	
	public MyPanel(){
		hero = new Hero(10,100);
		//heros.add(hero);
		image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.jpg"));
		image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.jpg"));
		image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.jpg"));
		
		for(int i=0;i<enemysize;i++){
			//����һ�����˵�̹��
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
				
		
		//�����ҵ�̹��		
		g.fillRect(0, 0, 400, 300);//ȷ������Ϊ400 300 ����Ϊ��ɫֵ
		
		//ʹ�û�̹�˷�������̹��
		if(hero.islive==true) {
			this.drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
			} 
		
		//����Ӣ�۵Ķ���ӵ�
		for(int i=0;i<hero.ss.size();i++){
			Shot myshot = hero.ss.get(i);
			if(myshot.islive==true){
				g.draw3DRect(myshot.x, myshot.y, 1, 1, false);
			}
			
			//��������е��ӵ������ˣ���Ӽ�����ɾ��
			if(myshot.islive==false){
				hero.ss.remove(i);
			}
		}	
		
		//�������˵�̹�� �� �ӵ�
		for(int i=0;i<ets.size();i++){
			EnemyTank et = ets.get(i);
			if(et.islive!=false) {
				this.drawTank(et.getX(), et.getY(), g, et.getDirect(), 1);
			}
			
			//��������ÿ��̹�˷�����ӵ�
			for(int j=0;j<et.Enemyshots.size();j++){
				Shot s = et.Enemyshots.get(j);
				if(s.islive==true){
					g.draw3DRect(s.x, s.y, 1, 1, false);
				}else{et.Enemyshots.remove(s);}
				
				
			}
		}
		
		//����ը��
		for(int i=0;i<bombs.size();i++){
			Bomb b = bombs.get(i);
			if(b.life>6){
				g.drawImage(image1, b.x, b.y, 30, 30,this);
				//System.out.println("��һ��ը����ը");
			}else if(b.life>3){
				g.drawImage(image2, b.x, b.y, 30, 30,this);
				//System.out.println("�ڶ���ը����ը��");
			}else if(b.life>0){
				g.drawImage(image3, b.x, b.y, 30, 30,this);
				//System.out.println("������ը����ը��");
			}
			b.lifedown();
			
			if(b.life<=0){
				b.islive=false;
				bombs.remove(b);
			}
			
		}
		
		//�ж�Ӣ�۵��ӵ��Ƿ���е���
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
		
		//�жϵ��˵��ӵ��Ƿ����Ӣ��
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
	
	//�ж��ӵ��Ƿ���е��˵�̹�˷���
	public void is_hittedtank(Shot s,Tank et){
		if(et.islive==true&&s.islive==true){
			switch(et.direct){
				case 0:
				case 2:
					if((s.x>et.x)&&(s.x<(et.x+20))&&(s.y>et.y)&&(s.y<(et.y+30))){
						s.islive=false;
						et.islive=false;
						Bomb bomb = new Bomb(et.x,et.y);//ÿ���е��˵�̹�������һ��ը��
						bombs.add(bomb);
					}
				break;
				
				case 1:
				case 3:	
					if(s.x>et.x&&s.y>et.y&&s.y<et.y+20&&s.x<et.x+30){
						s.islive=false;
						et.islive=false;
						Bomb bomb = new Bomb(et.x,et.y);//ÿ���е��˵�̹�������һ��ը��
						bombs.add(bomb); //���뵽ը��������
				}
				break;		
			}
		
		}
		
	}
	
	
	
	public void drawTank(int x,int y,Graphics g,int direct,int type){
		
		switch(type){
		case 0:
			g.setColor(Color.YELLOW); //0 ����ΪӢ�� ��ɫ���óɻ�ɫ
			break;
		case 1:
			g.setColor(Color.BLUE); //1����Ϊ���� ��ɫ���ó�CYANɫ
			break;
		}
		
		switch(direct){
		case 0: //0��λΪ����
			g.fill3DRect(x, y, 5, 30,false); //������߾���		
			g.fill3DRect(x+15, y, 5, 30,false); //�����ұ߾���
			g.fill3DRect(x+5, y+5, 10, 20,false);//�����м����	
			g.fillOval(x+5, y+9, 10, 10); //�����м�Բ
			g.drawLine(x+10, y+15, x+10, y);
			break;
			
		case 1: //����1Ϊ����
			g.fill3DRect(x, y, 30, 5,false); //�����ϲ�����		
			g.fill3DRect(x, y+15, 30, 5,false); //�����²�����
			g.fill3DRect(x+5, y+5, 20, 10,false);//�����м����	
			g.fillOval(x+10, y+5, 10, 10); //�����м�Բ
			g.drawLine(x+15, y+10, x+30, y+10);
			break;
		case 2://����
			g.fill3DRect(x, y, 5, 30,false); //������߾���		
			g.fill3DRect(x+15, y, 5, 30,false); //�����ұ߾���
			g.fill3DRect(x+5, y+5, 10, 20,false);//�����м����	
			g.fillOval(x+5, y+9, 10, 10); //�����м�Բ
			g.drawLine(x+10, y+15, x+10, y+30);
			break;
		
		case 3:
			g.fill3DRect(x, y, 30, 5,false); //�����ϲ�����		
			g.fill3DRect(x, y+15, 30, 5,false); //�����²�����
			g.fill3DRect(x+5, y+5, 20, 10,false);//�����м����	
			g.fillOval(x+10, y+5, 10, 10); //�����м�Բ
			g.drawLine(x+15, y+10, x, y+10);		
			break;
		}
		
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override //a��ʾ����w��ʾ���ϣ�d��ʾ�ң�s��ʾ����
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_W){
			//����̹�˵ķ���
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



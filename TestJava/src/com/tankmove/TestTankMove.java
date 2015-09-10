package com.tankmove;

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
		
		//ע�����
		this.addKeyListener(mp);
		
		this.setVisible(true);		
		this.setLocation(300, 200);
		this.setSize(300, 200);
		this.setTitle("HelloWorld");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


//�ҵĻ���
class MyPanel extends JPanel implements KeyListener{
	Hero hero = null;
	
	//������˵�̹�˼���
	Vector<EnemyTank> ets = new Vector();
	int enemysize = 3;
	
	
	
	public MyPanel(){
		hero = new Hero(10,100);
		
		for(int i=0;i<enemysize;i++){
			//����һ�����˵�̹��
			EnemyTank et = new EnemyTank((i+1)*50,0);
			et.setColor(1);
			et.setDirect(2);
			ets.add(et);
		}
		
	}
	
	
	public void paint(Graphics g){
		super.paint(g);

		
		//�����ҵ�̹��		
		g.fillRect(0, 0, 400, 300);//ȷ������Ϊ400 300 ����Ϊ��ɫֵ
		
		//ʹ�û�̹�˷�������̹��
		this.drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
		
		//�������˵�̹��
		for(int i=0;i<ets.size();i++){
			this.drawTank(ets.get(i).getX(), ets.get(i).getY(), g, ets.get(i).getDirect(), 1);
			
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
		
		this.repaint();
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}



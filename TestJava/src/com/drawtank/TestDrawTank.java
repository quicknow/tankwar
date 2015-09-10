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
		//ע�⣬new ��MyPanelʵ��ʱ ���Ѿ�ִ���˻��Ķ���,����JFrame�Ϳ�����
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
		
		//��ͼƬ
		//Image im = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/11.jpg"));
		//g.drawImage(im, 10, 10, 100, 150,this);
		
		//������
		//g.setColor(Color.BLUE);
		//��������
		//g.setFont(new Font("����",Font.BOLD,30));
		//g.drawString("��������",60, 60);
		
		//�����ҵ�̹��
		
		g.fillRect(0, 0, 400, 300);//ȷ������Ϊ400 300 ����Ϊ��ɫֵ
		
		//ʹ�û�̹�˷�������̹��
		this.drawTank(hero.getX(), hero.getY(), g, 0, 0);
		
	}
	
	public void drawTank(int x,int y,Graphics g,int direct,int type){
		
		switch(type){
		case 0:
			g.setColor(Color.YELLOW); //0 ����ΪӢ�� ��ɫ���óɻ�ɫ
			break;
		case 1:
			g.setColor(Color.CYAN); //1����Ϊ���� ��ɫ���ó�CYANɫ
			break;
		}
		
		switch(direct){
		case 0: //0��λΪ����
			g.fill3DRect(x, y, 5, 30,false); //������߾���		
			g.fill3DRect(x+15, y, 5, 30,false); //�����ұ߾���
			g.fill3DRect(x+5, y+5, 10, 20,false);//�����м����	
			g.fillOval(x+5, y+9, 10, 10); //�����м�Բ
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
	//���ø���Ĺ��캯������ʼ������ĳ�Ա����
		super(x,y);
	}
	
}




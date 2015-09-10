package com.tankshot;

import java.util.Vector;


//̹����
class Tank{
	//̹�˺�����
	int x=0;
	//̹��������
	int y=0;
	
	//̹����ɫ
	int color;
	
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	//̹�˷���,0��ʾ���ϣ�1����ʾ���ң�2����ʾ���£�3��ʾ����
	int direct=0;
	
	//̹�˵��ٶȣ�Ĭ��Ϊ1
	int speed=1;


	public Tank(int x,int y){
		this.x=x;
		this.y=y;		
	}
	
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
	
	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}
	
	//��ȡ�ٶ�
	public int getSpeed() {
		return speed;
	}

	//�����ٶ�
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}

class Hero extends Tank{
	
	//�ӵ�������
	Shot s = null;
	Vector<Shot> ss = new Vector();
	
	public Hero(int x,int y){
	//���ø���Ĺ��캯������ʼ������ĳ�Ա����
		super(x,y);
	}
	
	//���
	public void shotEnemy(){
		
		switch(this.direct) {
		case 0:
			s = new Shot(x+10,y,0);
			ss.add(s);
			break;
		case 1:
			s = new Shot(x+30,y+10,1);
			ss.add(s);
			break;
		case 2:
			s = new Shot(x+10,y+30,2);
			ss.add(s);
			break;
		case 3:
			s= new Shot(x,y+10,3);
			ss.add(s);
			break;
		}
		
		//�����ӵ��߳�
		Thread t = new Thread(s);
		t.start();
	}
	
	//̹�����Ͽ��ķ���
	public void moveUp(){
		
		y-=speed;
	}
	
	public void moveRight(){
		
		x+=speed;
	}
	
	public void moveDown(){
		
		y+=speed;
	}
	
	public void moveLeft(){
		
		x-=speed;
	}
	
}

class EnemyTank extends Tank{
	
	public EnemyTank(int x, int y){
		
		super(x,y);
	}
}

class Shot implements Runnable{
	int x;
	int y;
	int direct;
	int speed=3;
	boolean islive=true;
	
	public Shot(int x,int y,int direct){
		
		this.x=x;
		this.y=y;
		this.direct=direct;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			switch(direct){
			case 0:
				y-=speed;
				break;
			case 1:
				x+=speed;
				break;
			case 2:
				y+=speed;
				break;
			case 3:
				x-=speed;
				break;			
			}
			
			if(x<0||y>300||x>400||y<0){
				this.islive=false;
				break;
			}
			
			System.out.println("�ӵ��������ǣ�x="+x+"y="+y);
		}
	}
}



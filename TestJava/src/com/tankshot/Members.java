package com.tankshot;

import java.util.Vector;


//坦克类
class Tank{
	//坦克横坐标
	int x=0;
	//坦克纵坐标
	int y=0;
	
	//坦克颜色
	int color;
	
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	//坦克方向,0表示向上，1，表示向右，2，表示向下，3表示向左
	int direct=0;
	
	//坦克的速度，默认为1
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
	
	//获取速度
	public int getSpeed() {
		return speed;
	}

	//设置速度
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}

class Hero extends Tank{
	
	//子弹集合类
	Shot s = null;
	Vector<Shot> ss = new Vector();
	
	public Hero(int x,int y){
	//调用父类的构造函数来初始化子类的成员变量
		super(x,y);
	}
	
	//射击
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
		
		//启动子弹线程
		Thread t = new Thread(s);
		t.start();
	}
	
	//坦克向上开的方法
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
			
			System.out.println("子弹的坐标是：x="+x+"y="+y);
		}
	}
}



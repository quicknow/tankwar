package com.tankmove;


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
	
	public Hero(int x,int y){
	//调用父类的构造函数来初始化子类的成员变量
		super(x,y);
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



package com.tankmove;


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
	
	public Hero(int x,int y){
	//���ø���Ĺ��캯������ʼ������ĳ�Ա����
		super(x,y);
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



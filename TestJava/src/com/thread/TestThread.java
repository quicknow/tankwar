package com.thread;

public class TestThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat = new Cat();
		
		cat.start(); //运行线程
	}

}

class Cat extends Thread{
	int times =0;
	public void run(){
		while(true) {
		
			try {
				Thread.sleep(1000); //每休眠一秒运行一次
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			times++;
			System.out.println("线程中的动作"+times);
			if(times==10){
				break; //打印10次后，退出循环线程
			}
		}	
		
	}
}

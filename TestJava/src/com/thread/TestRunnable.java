package com.thread;

public class TestRunnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog = new Dog();		
		
		Thread t = new Thread(dog);
		t.start();
	}

}

class Dog implements Runnable{
	int times=0;
	public void run(){
		while(true){
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			times++;
			System.out.println("线程中运行内容"+times);
			
			if(times==10){
				break;
			}
		}
		
	}
	
	
}

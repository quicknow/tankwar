package com.thread;

public class TestThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat = new Cat();
		
		cat.start(); //�����߳�
	}

}

class Cat extends Thread{
	int times =0;
	public void run(){
		while(true) {
		
			try {
				Thread.sleep(1000); //ÿ����һ������һ��
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			times++;
			System.out.println("�߳��еĶ���"+times);
			if(times==10){
				break; //��ӡ10�κ��˳�ѭ���߳�
			}
		}	
		
	}
}

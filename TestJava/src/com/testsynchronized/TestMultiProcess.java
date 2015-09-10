package com.testsynchronized;


//����˵�����߳�����Ĺ������⣬δ����ʱ��һ��Ʊ�ᱻ����û�����
public class TestMultiProcess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicketWindow tkw = new TicketWindow();
		Thread t1 = new Thread(tkw);
		Thread t2 = new Thread(tkw);
		Thread t3 = new Thread(tkw);
		t1.start();
		t2.start();
		t3.start();
	}

}




class TicketWindow implements Runnable{
	private int tickets = 2000;

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
			
			if(tickets>0){
				
				System.out.println("�������۵�"+tickets+"��Ʊ");
			}
			
			tickets--;
		}
		
	}
	
}

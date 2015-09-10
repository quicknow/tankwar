package com.testsynchronized;



//����˵�����߳�����Ĺ������⣬δ����ʱ��һ��Ʊ�ᱻ����û�����
public class TestSynchronized {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicketWindow2 tkw2 = new TicketWindow2();
		Thread t1 = new Thread(tkw2);
		Thread t2 = new Thread(tkw2);
		Thread t3 = new Thread(tkw2);
		t1.start();
		t2.start();
		t3.start();
	}

}




class TicketWindow2 implements Runnable{
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
				
				//ͬ������˼���ǽ�������������һ��ԭ��
				synchronized (this) {					
				
					if(tickets>0){
						
						System.out.println("�������۵�"+tickets+"��Ʊ");
					}else{
						break;
					}	
				
					tickets--;
				}	
				
			}
			
		}
		
	
	
	
	
}

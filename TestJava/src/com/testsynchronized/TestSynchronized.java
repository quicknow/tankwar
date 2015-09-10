package com.testsynchronized;



//举例说明多线程引起的共享问题，未加锁时，一张票会被多个用户购买
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
				
				//同步的意思就是将下面两不做成一个原子
				synchronized (this) {					
				
					if(tickets>0){
						
						System.out.println("正在销售第"+tickets+"张票");
					}else{
						break;
					}	
				
					tickets--;
				}	
				
			}
			
		}
		
	
	
	
	
}

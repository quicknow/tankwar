package com.event; 


import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class TestMoveBall extends JFrame{
	MyPanel mp = null;
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		TestMoveBall tjl1 = new TestMoveBall();
	}
	
	public TestMoveBall(){

		mp = new MyPanel();	
		
		//ע�����  ���̲������¼�Դ������ͨ��JFrame�����ģ�����ʹ����ע�ᵽ����
		this.addKeyListener(mp);
		
		this.add(mp);
		this.setVisible(true);		
		this.setLocation(300, 200);
		this.setSize(300, 200);
		//this.setTitle("HelloWorld");
		//this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

//������ʵ�ּ����ӿڣ���Ϊ�ǻ����ϼ�����������Ϣ��Ȼ�������Ϣ����ڻ�������ʾС�����λ��
class MyPanel extends JPanel implements java.awt.event.KeyListener{
	int x=0;
	int y=0;
	
	//ע�⣬new ��MyPanelʵ��ʱ ���Ѿ�ִ���˻��Ķ���,����JFrame�Ϳ����ˡ�
	public void paint(Graphics g){
		super.paint(g);
	    g.fillOval(x, y, 10, 10);
	}

	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			//System.out.println("���¼�������"+e.getKeyCode());
			y++;			
		} else if(e.getKeyCode()==KeyEvent.VK_UP){
			y--;
		} else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			x--;
		} else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			x++;
		}
		
		this.repaint(); //�����ػ������ʾ�µ�λ��
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

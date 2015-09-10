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
		
		//注册监听  键盘操作的事件源最终是通过JFrame发生的，所以使用他注册到画布
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

//画布上实现监听接口，因为是画布上监听到键盘消息，然后根据消息情况在画布上显示小球的新位置
class MyPanel extends JPanel implements java.awt.event.KeyListener{
	int x=0;
	int y=0;
	
	//注意，new 出MyPanel实例时 就已经执行了画的动作,加入JFrame就可以了。
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
			//System.out.println("向下键被按下"+e.getKeyCode());
			y++;			
		} else if(e.getKeyCode()==KeyEvent.VK_UP){
			y--;
		} else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			x--;
		} else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			x++;
		}
		
		this.repaint(); //必须重绘才能显示新的位置
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

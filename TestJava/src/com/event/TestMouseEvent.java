package com.event; 

import java.awt.*;
import java.awt.event.*;

//import java.awt.event.MouseEvent;
import javax.swing.*;



public class TestMouseEvent extends JFrame{
	MyPanel2 mp2 = null;
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		TestMouseEvent tjl1 = new TestMouseEvent();
	}
	
	public TestMouseEvent(){

		mp2 = new MyPanel2();			
		
		//注册监听  键盘操作的事件源最终是通过JFrame发生的，所以使用他注册到画布
		this.addMouseListener(mp2);	
		this.addWindowListener(mp2);
		
		this.add(mp2);
		this.setVisible(true);		
		this.setLocation(300, 200);
		this.setSize(300, 200);
		//this.setTitle("HelloWorld");
		//this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.repaint();
	}

}

//画布上实现监听接口，因为是画布上监听到键盘消息，然后根据消息情况在画布上显示小球的新位置
class MyPanel2 extends JPanel implements MouseListener,WindowListener{
	
	//注意，new 出MyPanel实例时 就已经执行了画的动作,加入JFrame就可以了。
	/*public void paint(Graphics g){
		super.paint(g);	 
	}*/

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("鼠标的位置是："+"x="+e.getX()+" "+"y="+e.getY());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowDeiconified");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowDeactivated");
	}

	

}

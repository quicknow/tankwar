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
		
		//ע�����  ���̲������¼�Դ������ͨ��JFrame�����ģ�����ʹ����ע�ᵽ����
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

//������ʵ�ּ����ӿڣ���Ϊ�ǻ����ϼ�����������Ϣ��Ȼ�������Ϣ����ڻ�������ʾС�����λ��
class MyPanel2 extends JPanel implements MouseListener,WindowListener{
	
	//ע�⣬new ��MyPanelʵ��ʱ ���Ѿ�ִ���˻��Ķ���,����JFrame�Ϳ����ˡ�
	/*public void paint(Graphics g){
		super.paint(g);	 
	}*/

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("����λ���ǣ�"+"x="+e.getX()+" "+"y="+e.getY());
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

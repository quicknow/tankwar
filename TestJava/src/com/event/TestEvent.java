package com.event;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class TestEvent extends JFrame implements ActionListener{
	JPanel jp=null;
	JButton jb1=null;
	JButton jb2=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestEvent tjl1 = new TestEvent();
		
		
	}
	
	public TestEvent(){
		
		jp = new JPanel();
		jb1 = new JButton("��ɫ");
		jb2 = new JButton("��ɫ");
		
		this.add(jb1,BorderLayout.NORTH);
		this.add(jb2,BorderLayout.SOUTH);
		//JPanel���뵽JFrame
		this.add(jp);
		jp.setBackground(Color.BLACK);
		
		
		//ע�����
		jb1.addActionListener(this);
		jb1.setActionCommand("��ɫ");
		
		jb2.addActionListener(this);
		jb2.setActionCommand("��ɫ");
		
		this.setVisible(true);		
		this.setLocation(300, 200);
		this.setSize(300, 200);
		this.setTitle("HelloWorld");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override//��д��������
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("��ɫ")){
			System.out.println("�����˺�ɫ��ť");
			jp.setBackground(Color.BLACK);
		} else if(e.getActionCommand().equals("��ɫ")){
			System.out.println("�����˺�ɫ��ť");
			jp.setBackground(Color.RED);
		} else {
			System.out.println("��֪��ʲô��ɫ");
		}
	}

}

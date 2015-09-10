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
		jb1 = new JButton("黑色");
		jb2 = new JButton("红色");
		
		this.add(jb1,BorderLayout.NORTH);
		this.add(jb2,BorderLayout.SOUTH);
		//JPanel加入到JFrame
		this.add(jp);
		jp.setBackground(Color.BLACK);
		
		
		//注册监听
		jb1.addActionListener(this);
		jb1.setActionCommand("黑色");
		
		jb2.addActionListener(this);
		jb2.setActionCommand("红色");
		
		this.setVisible(true);		
		this.setLocation(300, 200);
		this.setSize(300, 200);
		this.setTitle("HelloWorld");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override//重写监听方法
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("黑色")){
			System.out.println("你点击了黑色按钮");
			jp.setBackground(Color.BLACK);
		} else if(e.getActionCommand().equals("红色")){
			System.out.println("你点击了红色按钮");
			jp.setBackground(Color.RED);
		} else {
			System.out.println("不知道什么颜色");
		}
	}

}

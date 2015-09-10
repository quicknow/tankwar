package com.swing;

import java.awt.*;
import javax.swing.*;

public class TestJCheckbox extends JFrame{
	JPanel jp1,jp2,jp3;
	JLabel jl1,jl2;
	JCheckBox jcb1,jcb2,jcb3;
	JButton jb1,jb2;
	JRadioButton jrb1,jrb2;
	ButtonGroup bg1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestJCheckbox tjb = new TestJCheckbox();
	}
	
	public TestJCheckbox(){
		jl1 = new JLabel("你喜欢的运动");
		jl2 = new JLabel("你的性别");
		
		jcb1 = new JCheckBox("足球");
		jcb2 = new JCheckBox("篮球");
		jcb3 = new JCheckBox("网球");
		
		jrb1 = new JRadioButton("男");
		jrb2 = new JRadioButton("女");
		bg1 = new ButtonGroup();		
		bg1.add(jrb1);
		bg1.add(jrb2);
		
		jb1 = new JButton("注册用户");
		jb2 = new JButton("取消注册");
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp1.add(jl1);
		jp1.add(jcb1);
		jp1.add(jcb2);
		jp1.add(jcb3);
		
		jp2.add(jl2);
		jp2.add(jrb1);
		jp2.add(jrb2);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		//JPanel加入到JFrame
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		this.setLayout(new GridLayout(3,1));
		this.setVisible(true);		
		this.setLocation(300, 200);
		this.setSize(300, 200);
		this.setTitle("HelloWorld");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

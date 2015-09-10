package com.swing;

import java.awt.*;
import javax.swing.*;

public class TestJList extends JFrame{
	JPanel jp1,jp2;
	JLabel jl1,jl2;
	
	JComboBox jcb1;
	JList jlt1;
	JScrollPane jsp1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestJList tjl1 = new TestJList();
	}
	
	public TestJList(){
		jl1 = new JLabel("籍贯");
		jl2 = new JLabel("喜欢去的地方");
		
		String[]jb={"江西","广东","四川","北京"};		
		jcb1 = new JComboBox(jb);	
		
		String[]jl={"火星","土星","木星","水星"};
		jlt1 = new JList(jl);
		jlt1.setVisibleRowCount(2);
		jsp1= new JScrollPane(jlt1);
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		
		jp1.add(jl1);
		jp1.add(jcb1);
		
		
		//组件加到JPanel中
		jp2.add(jl2);
		jp2.add(jsp1);	
		
		//JPanel加入到JFrame
		this.add(jp1);
		this.add(jp2);	
		
		this.setLayout(new GridLayout(2,1));
		this.setVisible(true);		
		this.setLocation(300, 200);
		this.setSize(300, 200);
		this.setTitle("HelloWorld");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

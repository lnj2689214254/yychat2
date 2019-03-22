package com.yychatclient.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class FriendList extends JFrame implements ActionListener,MouseListener{//��������
    CardLayout cardLayout;//��Ƭ����
	//�����������ñ���
	JPanel  myFriendPanel;//��һ��
	JButton  myFriendJButton;
	
	JScrollPane myFriendJScrollPane;
	JPanel myFriendListJPanel;
	static final int FRIENDCOUNT=51;
	JLabel[]myfriendJLabel=new JLabel[FRIENDCOUNT];//��������
	//myfriendJLabel[0]...myfriendJLabel[50] ÿһ���������ñ���
	
	
	JPanel  myStrangerBlackListJPanel;
	JButton  myStrangerJButton;
	JButton  blackListJButton;
	
	JPanel  myStrangerPanel;//�ڶ���
	
	JPanel myFriendStrangerPanel;
	JButton  myFriendJButton1;
	JButton  myStrangerJButton1;
	
	JScrollPane myFriendJScrollPane1;
	JPanel myFriendListJPanel1;
	static final int FRIENDCOUNT1=21;
	JLabel[]myfriendJLabel1=new JLabel[FRIENDCOUNT1];
	
	JButton  blackListJButton1;
	
	String userName;
	
	public FriendList(String userName){
		this.userName=userName;//�ֲ���������Ա������ֵ
		//��һ�ſ�Ƭ����������
		myFriendPanel=new JPanel(new BorderLayout());//�߽粼��
		
		myFriendJButton=new JButton("�ҵĺ���"); 
		myFriendPanel.add(myFriendJButton,"North"); 
		
		//�в�
		/*JScrollPane myFriendJScrollPane;
		JPanel myFriendListJPanel;
		static final int FRIENDCOUNT=51;
		JLabel[]myfriendJLabel;*/
		myFriendListJPanel=new JPanel(new GridLayout(FRIENDCOUNT-1,1));
		for(int i=1;i<FRIENDCOUNT;i++){
			myfriendJLabel[i]=new JLabel(i+"",new ImageIcon("images/qq.gif"),JLabel.LEFT);//"1"
			myfriendJLabel[i].addMouseListener(this);//������������
			myFriendListJPanel.add(myfriendJLabel[i]);
			}
		//myFriendJScrollPane =new JScrollPane();
		//myFriendJScrollPane.add(myFriendListJPanel);
		myFriendJScrollPane =new JScrollPane(myFriendListJPanel);
		myFriendPanel.add(myFriendJScrollPane);
		
		
		myStrangerBlackListJPanel=new JPanel(new GridLayout(2,1));//���񲼾�
		myStrangerJButton=new JButton("�ҵ�İ����");
		myStrangerJButton.addActionListener(this);//�¼�������
		blackListJButton=new  JButton("������");
		myStrangerBlackListJPanel.add(myStrangerJButton);
		myStrangerBlackListJPanel.add(blackListJButton);
		myFriendPanel.add(myStrangerBlackListJPanel,"South");
		
		//��һ�ſ�Ƭ
		myStrangerPanel = new JPanel(new BorderLayout()); 
		
		myFriendStrangerPanel = new JPanel(new GridLayout(2,1));
		myFriendJButton1=new JButton("�ҵĺ���");
		myFriendJButton1.addActionListener(this);//�¼�������
		myStrangerJButton1=new JButton("�ҵ�İ����"); 
		myFriendStrangerPanel.add(myFriendJButton1);
		myFriendStrangerPanel.add(myStrangerJButton1);
		myStrangerPanel.add(myFriendStrangerPanel,"North");
		
		myFriendListJPanel1=new JPanel(new GridLayout(FRIENDCOUNT1-1,1));
		for(int i=1;i<FRIENDCOUNT1;i++){
			myfriendJLabel1[i]=new JLabel(i+"",new ImageIcon("images/qq.gif"),JLabel.LEFT);//"1"
			myfriendJLabel1[i].addMouseListener(this);//������������
			myFriendListJPanel1.add(myfriendJLabel1[i]);
		}
		myFriendJScrollPane1 =new JScrollPane(myFriendListJPanel1);
		myStrangerPanel.add(myFriendJScrollPane1);
		
		
		
		blackListJButton1=new  JButton("������");
		myStrangerPanel.add(blackListJButton1,"South");
		
		cardLayout=new CardLayout();
		this.setLayout(cardLayout);
		this.add(myFriendPanel,"1");
	    this.add(myStrangerPanel,"2");
	    
	    this.setSize(150,500);
	    this.setTitle(this.userName+"�ĺ����б�");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
        this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		//FriendList  friendList=new FriendList();

	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==myStrangerJButton){
			cardLayout.show(this.getContentPane(), "2");
			 
		 }
		if(arg0.getSource()==myFriendJButton1){
			cardLayout.show(this.getContentPane(), "1");
			 
		 }
		  
		 }


	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()==2){
			JLabel jlbl=(JLabel)e.getSource();
			String receiver=jlbl.getText();
			new FriendChat(this.userName,receiver);
		}
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		JLabel jLabel=(JLabel)e.getSource();
		jLabel.setForeground(Color.red);
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		JLabel jLabel=(JLabel)e.getSource();
		jLabel.setForeground(Color.black);
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
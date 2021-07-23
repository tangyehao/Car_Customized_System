package cn.com.views.Systemview;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import cn.com.utils.Center;



public class BtnContractView extends JDialog {

	private JPanel pnlMain;
	private JPanel pnlN;
	private JPanel pnlC;
	private JTextArea taxView;
	//JScollPane�Դ���������ֻ��ѹ��һ���ؼ���
	private JScrollPane snpView;
	private JMenuBar mubMain;
	private JMenu munFile;
	private JMenuItem muiOpen;
	private JMenuItem muiSave;
	private JMenuItem muiExit;
	
	private JButton btnAdd;
	private JButton btnSave;
	private JButton btnExit;
	private boolean flag;
	
	
	public BtnContractView(Frame f,String title,Boolean bool) {
		/*�����ı�������һ����
		1.BorderLayOut ȡ�м�
		2.GridLayOut Ĭ��һ��һ��*/
		flag = false;
		this.setResizable(false);
		pnlMain = new JPanel();
		pnlN = new JPanel(null);
		pnlC = new JPanel(null);
		taxView = new JTextArea();
		snpView = new JScrollPane(taxView);
		
		mubMain = new JMenuBar();
		munFile = new JMenu("�ļ�");
		muiOpen = new JMenuItem("��");
		muiSave = new JMenuItem("����");
		muiExit = new JMenuItem("�˳�");
		
		btnAdd = new JButton(){
			protected void paintComponent(Graphics g){
				Image img = new ImageIcon("images/Add.png").getImage();
				g.drawImage(img, 0, 0,60,65,this);
			}
		};
		btnSave = new JButton("����");
		btnExit = new JButton("�˳�");
		
		
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setSize(1000, 750);
		pnlN.setBorder(BorderFactory.createRaisedBevelBorder());
		pnlN.setPreferredSize(new Dimension(1000, 100));
		pnlC.setPreferredSize(new Dimension(1000, 650));
		
		snpView.setBounds(0, 0, 1000, 650);
		btnAdd.setBounds(10, 10, 80, 80);
		btnSave.setBounds(130, 10, 80, 80);
		btnExit.setBounds(250, 10, 80, 80);
		btnAdd.setFont(new Font("����",Font.BOLD,18));
		btnSave.setFont(new Font("����",Font.BOLD,18));
		btnExit.setFont(new Font("����",Font.BOLD,18));
		
		setMenu();
		
		taxView.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				flag = true;
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				flag = true;
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				flag = true;
			}
		});
		
		muiOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				open(e);
			}
		});
		
		muiSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				saveFile();
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				open(e);
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				saveFile();
			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				muiExit(e);
			}
		});
		
		//this.setIconImage(new ImageIcon("images/title.png").getImage());
		this.setTitle("��ͬ���� ");
		
		taxView.setFont(new Font("����",Font.BOLD,25));
		
		pnlN.add(btnAdd);
		pnlN.add(btnSave);
		pnlN.add(btnExit);
		pnlC.add(snpView);
		pnlMain.add(pnlN);
		pnlMain.add(pnlC);
		//pnlMain.add(snpView);
		this.add(pnlMain);
		this.setVisible(true);
		
		Center.centerByWindow(this);
	}

	protected void muiExit(ActionEvent e) {
		// TODO Auto-generated method stub
		int result = JOptionPane.showConfirmDialog(this, "�Ƿ�ȷ���˳�", "��ʾ", JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}

	protected void open(ActionEvent e) {
		// TODO Auto-generated method stub
		if(flag) {
			int result = JOptionPane.showConfirmDialog(this, "�����Ѿ��ı䣬�Ƿ񱣴�", "��ʾ", JOptionPane.YES_NO_CANCEL_OPTION);
			if(result == JOptionPane.YES_OPTION) {
				saveFile();
				openFile();
			}else if(result == JOptionPane.NO_OPTION) {
				openFile();
			}
		}else {
			openFile();
		}
		
	}

	private void saveFile() {
		// TODO Auto-generated method stub
		 FileDialog fd = new FileDialog(this, "����", FileDialog.SAVE);
		 fd.setVisible(true);
		 String absPath = fd.getDirectory() +fd.getFile();
		 BufferedWriter bw = null;
		    try {
		        //�ַ���������������췽�������ַ�����������·��
		        bw = new BufferedWriter(new FileWriter(absPath));
		        String str = this.taxView.getText();
		        bw.write(str);
		    }catch (IOException obj){
		        obj.getMessage();
		    }finally {
		    	if(bw != null) {
		    		try {
						bw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	}
		    }
}


	private void openFile() {
		// TODO Auto-generated method stub
		FileDialog fd = new FileDialog(this, "��", FileDialog.LOAD);
		//FileDialog fd = new FileDialog(this, "��", FileDialog.SAVE);
		fd.setVisible(true);
		String dir = fd.getDirectory();//���ѡ����ļ�·��
		if(dir != null) {
			this.taxView.setText("");
			String name = fd.getFile();
			File file = new File(dir+name);
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(file));
				String line = null;
				while((line = br.readLine()) != null) {
					this.taxView.append(line+"\n");
				}
				this.setTitle(name);
				this.flag = false;
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				if(br != null) {
					try {
						br.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
	}
}
	
	

	private void setMenu() {
		// TODO Auto-generated method stub
		mubMain.add(munFile);
		munFile.add(muiOpen);
		munFile.add(muiSave);
		munFile.add(muiExit);
		this.setJMenuBar(mubMain);
	}
	

}

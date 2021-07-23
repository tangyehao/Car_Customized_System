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
	//JScollPane自带滚动条（只能压入一个控件）
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
		/*设置文本域和面板一样大
		1.BorderLayOut 取中间
		2.GridLayOut 默认一行一列*/
		flag = false;
		this.setResizable(false);
		pnlMain = new JPanel();
		pnlN = new JPanel(null);
		pnlC = new JPanel(null);
		taxView = new JTextArea();
		snpView = new JScrollPane(taxView);
		
		mubMain = new JMenuBar();
		munFile = new JMenu("文件");
		muiOpen = new JMenuItem("打开");
		muiSave = new JMenuItem("保存");
		muiExit = new JMenuItem("退出");
		
		btnAdd = new JButton(){
			protected void paintComponent(Graphics g){
				Image img = new ImageIcon("images/Add.png").getImage();
				g.drawImage(img, 0, 0,60,65,this);
			}
		};
		btnSave = new JButton("保存");
		btnExit = new JButton("退出");
		
		
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
		btnAdd.setFont(new Font("宋体",Font.BOLD,18));
		btnSave.setFont(new Font("宋体",Font.BOLD,18));
		btnExit.setFont(new Font("宋体",Font.BOLD,18));
		
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
		this.setTitle("合同管理 ");
		
		taxView.setFont(new Font("宋体",Font.BOLD,25));
		
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
		int result = JOptionPane.showConfirmDialog(this, "是否确定退出", "提示", JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}

	protected void open(ActionEvent e) {
		// TODO Auto-generated method stub
		if(flag) {
			int result = JOptionPane.showConfirmDialog(this, "内容已经改变，是否保存", "提示", JOptionPane.YES_NO_CANCEL_OPTION);
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
		 FileDialog fd = new FileDialog(this, "保存", FileDialog.SAVE);
		 fd.setVisible(true);
		 String absPath = fd.getDirectory() +fd.getFile();
		 BufferedWriter bw = null;
		    try {
		        //字符缓冲输出流，构造方法传入字符输出流绑定输出路径
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
		FileDialog fd = new FileDialog(this, "打开", FileDialog.LOAD);
		//FileDialog fd = new FileDialog(this, "打开", FileDialog.SAVE);
		fd.setVisible(true);
		String dir = fd.getDirectory();//获得选择的文件路径
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

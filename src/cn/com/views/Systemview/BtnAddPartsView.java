package cn.com.views.Systemview;

import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.com.beans.Parts;
import cn.com.beans.Modle;
import cn.com.beans.Parts;
import cn.com.beans.User;
import cn.com.listeners.CloseView_ActionListener;
import cn.com.services.impl.ModleInfoServiceImpl;
import cn.com.services.impl.PartsInfoServiceImpl;
import cn.com.utils.Center;
import cn.com.utils.Utils;


public class BtnAddPartsView extends JDialog{
	private JPanel pnlMain;
	
	private JLabel lblModleId;
	private JLabel lblName;
	private JLabel lblColor;
	private JLabel lblNote;
	
	private JTextField txtName;
	private JTextField txtNote;
	
	private JButton btnSave;
	private JButton btnExit;
	
	private Parts pb;
	private BtnPartsView bpd;
	
	


	private PartsInfoServiceImpl service;
	private ModleInfoServiceImpl mService;

	private JComboBox<String> cbxParts;

	private DefaultComboBoxModel<String> cbmParts;
	
	private JComboBox<String> cbxcolor;

	private DefaultComboBoxModel<String> cbmcolor;




	public JTextField getTxtName() {
		return txtName;
	}

	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}



	public JTextField getTxtNote() {
		return txtNote;
	}

	public void setTxtNote(JTextField txtNote) {
		this.txtNote = txtNote;
	}

	public BtnAddPartsView(Frame f,String title,boolean bool) {
		// TODO Auto-generated constructor stub
		super(f,title,bool);
		mService = new ModleInfoServiceImpl();
		
		pnlMain = new JPanel(null);
		
		cbxParts = new JComboBox<String>();

		cbmParts = new DefaultComboBoxModel<String>();
		cbxcolor = new JComboBox<String>();
		cbmcolor = new DefaultComboBoxModel<String>();
		
		lblModleId = new JLabel("配件型号：");
		lblName = new JLabel("配件名称：");
		lblColor = new JLabel("配件颜色：");
		lblNote = new JLabel("备    注：");

		

		txtName = new JTextField();
		txtNote = new JTextField();

		
		btnSave = new JButton("保存");
		btnExit = new JButton("退出");
		
		service = new PartsInfoServiceImpl();
	
		
		init();
		
	}

	private void init() {
		// TODO Auto-generated method stub
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(550, 400);
		
		lblModleId.setBounds(10, 10, 100, 25);
		lblName.setBounds(280, 10, 100, 25);
		lblColor.setBounds(10, 45, 100, 25);
		lblNote.setBounds(280, 45, 100, 25);


		
		cbxParts.setBounds(110, 10, 160, 25);
		txtName.setBounds(370, 10, 160, 25);
		cbxcolor.setBounds(110, 45, 160, 25);
		txtNote.setBounds(370, 45, 160, 25);


		
		btnSave.setBounds(150, 300, 100, 50);
		btnExit.setBounds(300, 300, 100, 50);
		

		lblModleId.setFont(new Font("宋体",Font.BOLD,18));
		lblName.setFont(new Font("宋体",Font.BOLD,18));
		lblColor.setFont(new Font("宋体",Font.BOLD,18));
		lblNote.setFont(new Font("宋体",Font.BOLD,18));
		
		btnSave.setFont(new Font("宋体",Font.BOLD,18));
		btnExit.setFont(new Font("宋体",Font.BOLD,18));
		
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BtnSave(e);
			}
		});
		btnExit.addActionListener(new CloseView_ActionListener(this));
		
		
		Center.centerByWindow(this);
		

		pnlMain.add(lblModleId);
		pnlMain.add(lblName);
		pnlMain.add(lblColor);
		pnlMain.add(lblNote);
		pnlMain.add(cbxParts);
		pnlMain.add(txtName);
		pnlMain.add(cbxcolor);
		pnlMain.add(txtNote);

		pnlMain.add(btnSave);
		pnlMain.add(btnExit);	
		setModle();
		this.add(pnlMain);
		this.setVisible(true);
		
		
	}

	protected void BtnSave(ActionEvent e) {
		// TODO Auto-generated method stub
		service = new PartsInfoServiceImpl();
		pb = new Parts();
		
		int mid = this.cbxParts.getSelectedIndex()+1;
		String mName = this.getTxtName().getText().trim();
		if(mName.equals("")){
			JOptionPane.showMessageDialog(this, "配件名字不能为空", "提示", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		pb.setpModle(mid);
		pb.setpName(mName);
		pb.setpColour((String)cbxcolor.getSelectedItem());
		pb.setpNote(this.getTxtNote().getText().trim());
		

		if(service.addPartsInfoService(pb)) {
			List<Parts> list = service.getAllPartsInfoService();
			bpd = new BtnPartsView(new Frame(), "配件增加", true);
			JOptionPane.showMessageDialog(this, "配件添加成功", "提示", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}else {
				JOptionPane.showMessageDialog(this, "此配件编号已存在，添加失败", "错误", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}
	private void setModle() {
		// TODO Auto-generated method stub
		
		cbxParts.setModel(cbmParts);
		List<Modle> listF = new ArrayList<Modle>();
		listF = mService.modleExport();
		for(Modle f:listF){
			cbmParts.addElement(f.getmID()+"");
		}
		
		cbxcolor.setModel(cbmcolor);

		cbmcolor.addElement(Utils.COLOR_GREEN);
		cbmcolor.addElement(Utils.COLOR_RED);
		cbmcolor.addElement(Utils.COLOR_YELLOW);
	}
	
	
}

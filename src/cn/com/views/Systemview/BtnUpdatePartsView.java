package cn.com.views.Systemview;

import java.awt.Dialog;
import java.awt.Font;
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

import cn.com.beans.Modle;
import cn.com.beans.Parts;
import cn.com.listeners.CloseView_ActionListener;
import cn.com.services.PartsInfoServiceInf;
import cn.com.services.impl.PartsInfoServiceImpl;
import cn.com.utils.Center;
import cn.com.utils.Utils;


public class BtnUpdatePartsView extends JDialog {
	private JPanel pnlMain;
	
	private JLabel lblPartsId;
	private JLabel lblName;
	private JLabel lblColor;
	private JLabel lblNote;
	
	private JTextField txtPartsId;
	private JTextField txtName;
	private JTextField txtNote;
	
	
	private JButton btnSave;
	private JButton btnExit;
	
	private JComboBox<String> cbxcolor;

	private DefaultComboBoxModel<String> cbmcolor;
	
	private Parts parts;
	private BtnPartsView bpd;
	private PartsInfoServiceInf service;
	
	public BtnUpdatePartsView(Dialog owner, String title, boolean model, Parts pb) {
		// TODO Auto-generated constructor stub
		super(owner,title,model);
		
		cbxcolor = new JComboBox<String>();
		cbmcolor = new DefaultComboBoxModel<String>();
		bpd = (BtnPartsView)owner;
		this.parts = pb;
		pnlMain = new JPanel(null);
		
		lblPartsId = new JLabel("配件ID：");
		lblName = new JLabel("配件名称：");
		lblColor = new JLabel("配件颜色：");
		lblNote = new JLabel("备    注：");
		
		txtPartsId = new JTextField(pb.toString());
		txtName = new JTextField(pb.getpName());
		txtNote = new JTextField(pb.getpNote());
		
		txtPartsId.setEnabled(false);
		
		btnSave = new JButton("保存");
		btnExit = new JButton("退出");
		
		service = new PartsInfoServiceImpl();
		
		init();
		
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(350, 300);
		
		lblPartsId.setBounds(10, 10, 100, 25);
		lblName.setBounds(10, 45, 100, 25);
		lblNote.setBounds(10, 80, 100, 25);
		lblColor.setBounds(10, 115, 100, 25);
		
		txtPartsId.setBounds(110, 10, 200, 25);
		txtName.setBounds(110, 45, 200, 25);
		txtNote.setBounds(110, 80, 200, 25);
		cbxcolor.setBounds(110, 115, 200, 25);
		
		btnSave.setBounds(50, 200, 100, 50);
		btnExit.setBounds(200, 200, 100, 50);
		
		lblPartsId.setFont(new Font("宋体",Font.BOLD,18));
		lblName.setFont(new Font("宋体",Font.BOLD,18));
		lblColor.setFont(new Font("宋体",Font.BOLD,18));
		lblNote.setFont(new Font("宋体",Font.BOLD,18));
		
		btnSave.setFont(new Font("宋体",Font.BOLD,18));
		btnExit.setFont(new Font("宋体",Font.BOLD,18));
		
		Center.centerByWindow(this);
		
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UpdateParts(e);
			}
		});
		btnExit.addActionListener(new CloseView_ActionListener(this));
		
		pnlMain.add(lblPartsId);
		pnlMain.add(lblName);
		pnlMain.add(lblColor);
		pnlMain.add(lblNote);
		pnlMain.add(txtPartsId);
		pnlMain.add(txtName);
		pnlMain.add(cbxcolor);
		pnlMain.add(txtNote);

		pnlMain.add(btnSave);
		pnlMain.add(btnExit);	
		setModle();
		this.add(pnlMain);
		this.setVisible(true);
	}

	protected void UpdateParts(ActionEvent e) {
		// TODO Auto-generated method stub
		//int partsId = Integer.parseInt(this.txtPartsId.getText().trim());
		//int modleId = Integer.parseInt(this.txtModleId.getText().trim());
		String partsName = this.txtName.getText().trim();
		String partsColor = (String)this.cbxcolor.getSelectedItem();
		String partsNote = this.txtNote.getText().trim();
		
		Parts p = new Parts();
		p.setpID(parts.getpID());
		p.setpName(partsName);
		p.setpColour(partsColor);
		p.setpNote(partsNote);
		p.setpModle(parts.getpModle());
		if(service.upDatePartsInfoService(p)) {
			List<Parts> list = service.getAllPartsInfoService();
			bpd.setTableDate(list);
			this.dispose();
		}else {
			JOptionPane.showMessageDialog(this, "修改失败", "错误", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
	}
	private void setModle() {
		// TODO Auto-generated method stub
		
		
		cbxcolor.setModel(cbmcolor);
		cbmcolor.addElement(Utils.COLOR_GREEN);
		cbmcolor.addElement(Utils.COLOR_RED);
		cbmcolor.addElement(Utils.COLOR_YELLOW);
	}
}

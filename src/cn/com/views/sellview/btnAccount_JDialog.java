package cn.com.views.sellview;

import cn.com.utils.Center;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class btnAccount_JDialog extends JDialog {
    private JPanel pnlMain;
    private JPanel pnlN;
    private JPanel pnlC;
    private JPanel pnlS;


    //中心
    private JLabel lblMonth;
    private JLabel lblOne;
    private JLabel lblTwo;
    private JLabel lblThree;
    private JLabel lblFour;
    private JLabel lblCoustomerName;

    private JComboBox<Integer> cmbYearOne;
    private DefaultComboBoxModel<Integer> dcmYearOne;

    private JComboBox<Integer> cmbYearTwo;
    private DefaultComboBoxModel<Integer> dcmYearTwo;

    private JComboBox<Integer> cmbYearThree;
    private DefaultComboBoxModel<Integer> dcmYearThree;

    private JComboBox<Integer> cmbYearFour;
    private DefaultComboBoxModel<Integer> dcmYearFour;

    private JComboBox<String> cmbWare;
    private DefaultComboBoxModel<String> dcmWare;

    private JButton btnSearch;

    //南
    private JTable tabWare;
    private DefaultTableModel dtmWare;

    private JScrollPane snpView;

    public btnAccount_JDialog(Frame f, String title, boolean bool){
        super(f,title,bool);
        pnlMain = new JPanel();
        pnlN = new JPanel(null);
        pnlC = new JPanel(null);
        pnlS = new JPanel(null);


        //中心
        lblMonth = new JLabel("统计月份:");
        lblOne = new JLabel("年");
        lblTwo = new JLabel("月至");
        lblThree = new JLabel("年");
        lblFour = new JLabel("月");
        lblCoustomerName = new JLabel("客户名称");

        cmbYearOne = new JComboBox<Integer>();
        dcmYearOne = new DefaultComboBoxModel<Integer>();

        cmbYearTwo = new JComboBox<Integer>();
        dcmYearTwo = new DefaultComboBoxModel<Integer>();

        cmbYearThree = new JComboBox<Integer>();
        dcmYearThree = new DefaultComboBoxModel<Integer>();

        cmbYearFour = new JComboBox<Integer>();
        dcmYearFour = new DefaultComboBoxModel<Integer>();

        cmbWare = new JComboBox<String>();
        dcmWare = new DefaultComboBoxModel<String>();

        btnSearch = new JButton("查找");
        //南
        tabWare = new JTable();
        dtmWare = new DefaultTableModel();

        snpView = new JScrollPane(tabWare);

        init();
    }

    private void init() {
        // TODO Auto-generated method stub

        this.setResizable(false);
        this.setSize(1000, 650);
        pnlN.setBorder(BorderFactory.createRaisedBevelBorder());//分界线
        pnlC.setBorder(BorderFactory.createRaisedBevelBorder());

        pnlN.setPreferredSize(new Dimension(1000,75));//北面板大小
        pnlC.setPreferredSize(new Dimension(1000,55));
        pnlS.setPreferredSize(new Dimension(1000,510));

        Center.centerByWindow(this);


        setCmbDate();
        setCmbCustomerNameData();

        //中心
        pnlC.add(lblMonth);
        pnlC.add(lblOne);
        pnlC.add(lblTwo);
        pnlC.add(lblThree);
        pnlC.add(lblFour);
        pnlC.add(lblCoustomerName);


        lblMonth.setFont(new Font("宋体",Font.BOLD,14));
        lblOne.setFont(new Font("宋体",Font.BOLD,14));
        lblTwo.setFont(new Font("宋体",Font.BOLD,14));
        lblThree.setFont(new Font("宋体",Font.BOLD,14));
        lblFour.setFont(new Font("宋体",Font.BOLD,14));
        lblCoustomerName.setFont(new Font("宋体",Font.BOLD,14));

        pnlC.add(cmbYearOne);
        pnlC.add(cmbYearTwo);
        pnlC.add(cmbYearThree);
        pnlC.add(cmbYearFour);
        pnlC.add(cmbWare);
        pnlC.add(lblCoustomerName);

        pnlC.add(btnSearch);

        cmbYearOne.setFont(new Font("宋体",Font.BOLD,16));
        cmbYearTwo.setFont(new Font("宋体",Font.BOLD,16));
        cmbYearThree.setFont(new Font("宋体",Font.BOLD,16));
        cmbYearFour.setFont(new Font("宋体",Font.BOLD,16));
        cmbWare.setFont(new Font("宋体",Font.BOLD,16));
        lblCoustomerName.setFont(new Font("宋体",Font.BOLD,16));

        btnSearch.setFont(new Font("宋体",Font.BOLD,16));

        snpView.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        snpView.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //南
        pnlS.add(snpView);


        setTableDate();//表格数据

        //中心
        lblMonth.setBounds(30,3, 75, 45);
        cmbYearOne.setBounds(110, 10, 90, 30);
        lblOne.setBounds(205,3,25,45);//年
        cmbYearTwo.setBounds(235,10,60,30);
        lblTwo.setBounds(300,3,40,45);//月至
        cmbYearThree.setBounds(345,10,80,30);
        lblThree.setBounds(430,3,25,45);//年
        cmbYearFour.setBounds(460,10,60,30);
        lblFour.setBounds(525,3,25,45);//月
        lblCoustomerName.setBounds(650,10,75,30);
        cmbWare.setBounds(750,10,105,25);

        btnSearch.setBounds(900,8,50,35);

        snpView.setBounds(0, 0, 1000, 510);

        this.add(pnlMain);
        pnlMain.add(pnlN);
        pnlMain.add(pnlC);
        pnlMain.add(pnlS);
        this.setVisible(true);
    }
    private void setCmbCustomerNameData() {

    }

    private void setCmbDate() {
        // TODO Auto-generated method stub
        for(int i = 2004;i<=2021;i++){
            this.dcmYearOne.addElement(i);
            this.dcmYearThree.addElement(i);

        }

        this.cmbYearOne.setModel(dcmYearOne);
        this.cmbYearThree.setModel(dcmYearThree);

        for(int i = 1;i<=12;i++){
            this.dcmYearTwo.addElement(i);

            this.dcmYearFour.addElement(i);
        }

        this.cmbYearTwo.setModel(dcmYearTwo);
        this.cmbYearFour.setModel(dcmYearFour);

        this.cmbWare.setModel(dcmWare);
    }

    private void setTableDate() {
        // TODO Auto-generated method stub
        Vector<String> colNames = new Vector<String>();
        colNames.add("配件编号");
        colNames.add("配件名称");
        colNames.add("单位");
        colNames.add("销售数量");
        colNames.add("销售总金额");
        colNames.add("库存数量");
        colNames.add("规格型号");
        colNames.add("生产厂商");
        colNames.add("备注");

        Vector<Vector> datas = new Vector();
        dtmWare = new DefaultTableModel(datas,colNames);
        this.tabWare.setModel(dtmWare);
    }
}

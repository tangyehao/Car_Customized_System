package cn.com.views.sellview;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

//客户消费情况
public class btnAccount_CustomSituationPanel extends JPanel{
    private JPanel pnlMain;
    private JPanel pnlN;
    private JPanel pnlC;
    private JPanel pnlS;

    //北面板按钮控件
    private JButton btnSearch;

    private JButton btnQuit;

//    //中心面板控件
//    private JLabel lblWare;
//    private JLabel lblParts;

    private JTextField txtParts;

   // private JComboBox<String> cmbWare;
    private DefaultComboBoxModel<String> dcmWare;

    private JButton btnC_Search;

    //南
    private JTable tabWare;
    private DefaultTableModel dtmWare;

    private JScrollPane snpView;

    public btnAccount_CustomSituationPanel(){
        //北
        pnlMain = new JPanel();
        pnlN = new JPanel(null);
        pnlC = new JPanel(null);
        pnlS = new JPanel(null);

        btnSearch = new JButton("查找");

        btnQuit = new JButton();

//        //中心
//        lblWare = new JLabel("查询时间:");
//        lblParts = new JLabel("配件编号或名称:");

        txtParts = new JTextField();

      //  cmbWare = new JComboBox<String>();
        dcmWare = new DefaultComboBoxModel<String>();

        tabWare = new JTable();

        snpView = new JScrollPane(tabWare);

        btnC_Search = new JButton("查找");

    }

    public btnAccount_CustomSituationPanel(LayoutManager lm){

        super(lm);

        pnlMain = new JPanel();
        pnlN = new JPanel(null);
        pnlC = new JPanel(null);
        pnlS = new JPanel(null);

        btnSearch = new JButton("高级查询");

        btnQuit = new JButton("退出");

//        //中心
//        lblWare = new JLabel("仓库:");
//        lblParts = new JLabel("配件编号或名称:");

        txtParts = new JTextField();

   //     cmbWare = new JComboBox<String>();
        dcmWare = new DefaultComboBoxModel<String>();

        tabWare = new JTable();

        snpView = new JScrollPane(tabWare);//将表格压进滚动条的面板

        btnC_Search = new JButton("查找");


        init();
    }


    private void init() {
        // TODO Auto-generated method stub

        pnlN.setBorder(BorderFactory.createRaisedBevelBorder());//分界线
        pnlC.setBorder(BorderFactory.createRaisedBevelBorder());
        //pnlS.setBorder(BorderFactory.createRaisedBevelBorder());

        //pnlMain.setSize(1000, 550);
        pnlN.setPreferredSize(new Dimension(1000,75));//北面板大小
        pnlC.setPreferredSize(new Dimension(1000,55));
        pnlS.setPreferredSize(new Dimension(1000,510));

        pnlN.add(btnSearch);
        pnlN.add(btnQuit);

      //  pnlC.add(lblWare);
     //   pnlC.add(cmbWare);
       // pnlC.add(lblParts);
        pnlC.add(txtParts);
        pnlC.add(btnC_Search);

        pnlS.add(snpView);


        //北
        btnSearch.setFont(new Font("宋体",Font.BOLD,18));
        btnQuit.setFont(new Font("宋体",Font.BOLD,18));

        btnQuit.setBounds(150, 3, 60, 65);
        btnSearch.setBounds(30, 3, 100, 65);


        //cmbWare.setSelectedItem("所有仓库");

       // lblWare.setFont(new Font("宋体",Font.BOLD,16));
      //  cmbWare.setFont(new Font("宋体",Font.BOLD,16));
       // lblParts.setFont(new Font("宋体",Font.BOLD,16));
        txtParts.setFont(new Font("宋体",Font.BOLD,16));
        btnC_Search.setFont(new Font("宋体",Font.BOLD,16));
       // btnC_Search.setBackground(Color.BLUE);//按钮背景色

       // lblWare.setBounds(30,3, 45, 45);
     //   cmbWare.setBounds(80, 10, 100, 30);
       // lblParts.setBounds(220,3, 130, 45);
        txtParts.setBounds(355,10,150,30);
        btnC_Search.setBounds(525, 10, 50, 30);

        snpView.setBounds(0,0, 1000, 500);

        setTableDate();//表格数据

        pnlN.add(btnSearch);
        pnlN.add(btnQuit);

        pnlMain.add(pnlN);
        pnlMain.add(pnlC);
        pnlMain.add(pnlS);


        this.add(pnlMain);
        this.setVisible(true);
    }

    private void setTableDate() {
        // TODO Auto-generated method stub
        Vector<String> colNames = new Vector<String>();
        colNames.add("配件编号");
        colNames.add("配件名称");
        colNames.add("禁用");
        colNames.add("库存量");
        colNames.add("销售总数");
        colNames.add("上次进价");
        colNames.add("成本均价");
        colNames.add("预设售价");
        colNames.add("库存总值");
        colNames.add("所在货架");
        colNames.add("单位");
        colNames.add("规格型号");
        colNames.add("颜色");

        Vector<Vector> datas = new Vector();
        dtmWare = new DefaultTableModel(datas,colNames);
        this.tabWare.setModel(dtmWare);
    }

}

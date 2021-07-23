package cn.com.views.sellview;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

//�ͻ��������
public class btnAccount_CustomSituationPanel extends JPanel{
    private JPanel pnlMain;
    private JPanel pnlN;
    private JPanel pnlC;
    private JPanel pnlS;

    //����尴ť�ؼ�
    private JButton btnSearch;

    private JButton btnQuit;

//    //�������ؼ�
//    private JLabel lblWare;
//    private JLabel lblParts;

    private JTextField txtParts;

   // private JComboBox<String> cmbWare;
    private DefaultComboBoxModel<String> dcmWare;

    private JButton btnC_Search;

    //��
    private JTable tabWare;
    private DefaultTableModel dtmWare;

    private JScrollPane snpView;

    public btnAccount_CustomSituationPanel(){
        //��
        pnlMain = new JPanel();
        pnlN = new JPanel(null);
        pnlC = new JPanel(null);
        pnlS = new JPanel(null);

        btnSearch = new JButton("����");

        btnQuit = new JButton();

//        //����
//        lblWare = new JLabel("��ѯʱ��:");
//        lblParts = new JLabel("�����Ż�����:");

        txtParts = new JTextField();

      //  cmbWare = new JComboBox<String>();
        dcmWare = new DefaultComboBoxModel<String>();

        tabWare = new JTable();

        snpView = new JScrollPane(tabWare);

        btnC_Search = new JButton("����");

    }

    public btnAccount_CustomSituationPanel(LayoutManager lm){

        super(lm);

        pnlMain = new JPanel();
        pnlN = new JPanel(null);
        pnlC = new JPanel(null);
        pnlS = new JPanel(null);

        btnSearch = new JButton("�߼���ѯ");

        btnQuit = new JButton("�˳�");

//        //����
//        lblWare = new JLabel("�ֿ�:");
//        lblParts = new JLabel("�����Ż�����:");

        txtParts = new JTextField();

   //     cmbWare = new JComboBox<String>();
        dcmWare = new DefaultComboBoxModel<String>();

        tabWare = new JTable();

        snpView = new JScrollPane(tabWare);//�����ѹ�������������

        btnC_Search = new JButton("����");


        init();
    }


    private void init() {
        // TODO Auto-generated method stub

        pnlN.setBorder(BorderFactory.createRaisedBevelBorder());//�ֽ���
        pnlC.setBorder(BorderFactory.createRaisedBevelBorder());
        //pnlS.setBorder(BorderFactory.createRaisedBevelBorder());

        //pnlMain.setSize(1000, 550);
        pnlN.setPreferredSize(new Dimension(1000,75));//������С
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


        //��
        btnSearch.setFont(new Font("����",Font.BOLD,18));
        btnQuit.setFont(new Font("����",Font.BOLD,18));

        btnQuit.setBounds(150, 3, 60, 65);
        btnSearch.setBounds(30, 3, 100, 65);


        //cmbWare.setSelectedItem("���вֿ�");

       // lblWare.setFont(new Font("����",Font.BOLD,16));
      //  cmbWare.setFont(new Font("����",Font.BOLD,16));
       // lblParts.setFont(new Font("����",Font.BOLD,16));
        txtParts.setFont(new Font("����",Font.BOLD,16));
        btnC_Search.setFont(new Font("����",Font.BOLD,16));
       // btnC_Search.setBackground(Color.BLUE);//��ť����ɫ

       // lblWare.setBounds(30,3, 45, 45);
     //   cmbWare.setBounds(80, 10, 100, 30);
       // lblParts.setBounds(220,3, 130, 45);
        txtParts.setBounds(355,10,150,30);
        btnC_Search.setBounds(525, 10, 50, 30);

        snpView.setBounds(0,0, 1000, 500);

        setTableDate();//�������

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
        colNames.add("������");
        colNames.add("�������");
        colNames.add("����");
        colNames.add("�����");
        colNames.add("��������");
        colNames.add("�ϴν���");
        colNames.add("�ɱ�����");
        colNames.add("Ԥ���ۼ�");
        colNames.add("�����ֵ");
        colNames.add("���ڻ���");
        colNames.add("��λ");
        colNames.add("����ͺ�");
        colNames.add("��ɫ");

        Vector<Vector> datas = new Vector();
        dtmWare = new DefaultTableModel(datas,colNames);
        this.tabWare.setModel(dtmWare);
    }

}

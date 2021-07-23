package cn.com.views.statistic;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import cn.com.services.BuyManagerServiceInf;
import cn.com.services.StoreStateServiceInf;
import cn.com.services.impl.BuyManagerServiceImp;
import cn.com.services.impl.StoreManagerServiceImp;
import cn.com.utils.Center;
import com.eltima.components.ui.DatePicker;

import cn.com.beans.Bill;
import cn.com.beans.Inventory;
import cn.com.dto.PurchaseDto;
import cn.com.dto.StoreStateDto;




public class BusinessAnalysis_View extends JDialog{
	
	private JLabel jlfinace;
	private JLabel jlsellCostTotalPrice;
	private JLabel jlsellProfitTotalPrice;
	private JLabel jlsellProfitRate;
	private JLabel jlsellCostTotalPriceValue;
	private JLabel jlsellProfitTotalPriceValue;
	private JLabel jlsellProfitRateValue;
	private JPanel jpFinace;
	private JLabel jlPicture;
	
	
	private  JLabel jlSellMsg;
	private  JLabel jlSellProductTotalNumber;
	private  JLabel jlSellBillNumber;
	private  JLabel jlSellProductTotalPrice;
	private  JLabel jlSellBackProductTotalNumber;
	private  JLabel jlSellBackBillNumber;
	private  JLabel jlSellBackProductTotalPrice;
	
	private  JLabel jlSellMsgValue;
	private  JLabel jlSellProductTotalNumberValue;
	private  JLabel jlSellBillNumberValue;
	private  JLabel jlSellProductTotalPriceValue;
	private  JLabel jlSellBackProductTotalNumberValue;
	private  JLabel jlSellBackBillNumberValue;
	private  JLabel jlSellBackProductTotalPriceValue;
	
	
	private StoreStateServiceInf storeService;
	private JLabel jlstoreTotalNumber;
	private JLabel jlstoreTotalNumberValue;
	private JLabel jlstoreStatue;
	private JLabel jlstoreTotalPrice;
	private JLabel jlstoreTotalPriceValue;
	
	private PurchaseDto purchase;
	private JPanel pnlTop;
	private JPanel pnllow;
	private JPanel pnlMain;
	private JLabel lbStatisticTime;
	private JButton btnGetTime;
	final DatePicker datepickstart;
	final DatePicker datepickEnd;
	private JButton btnGetEndTime;
	private JLabel jlzhi;
	private JButton btnStatistic;
	private String  timeEnd;
	private String  timeStart;
	private String  timeNow;
	private JLabel jlTitle;
	private JLabel jlS_ETime;
	private JLabel jlNowTime;
	private Date date;
	private SimpleDateFormat sdf;
	private SimpleDateFormat dateFormat;
	
	
	private JTabblePanel jp;
	private  JPanel pBuy;
	private  JPanel pSell;
	private  JPanel pStore;
	private  JPanel pictureStatistic;
	
	private JLabel jlMsg;
	private JLabel jlBuyNumber ;
	private JLabel jlBuyBillNumber;
	private JLabel jlBuyMoney;
	private JLabel jlBackNumber ;
	private JLabel jlBackBillNumber;
	private JLabel jlBackMoney;
	
	private JLabel jlBuyNumberValue ;
	private JLabel jlBuyBillNumberValue;
	private JLabel jlBuyMoneyValue;
	private JLabel jlBackNumberValue ;
	private JLabel jlBackBillNumberValue;
	private BuyManagerServiceInf service;
	private JLabel jlBackMoneyValue;
	
	
	  private JScrollPane snpBuyView;
	  private JTable tabBuyView;
	  private DefaultTableModel dtmBuyView;
	  private Font  font;
	  private Map<String, Double> map;
	 

	public BusinessAnalysis_View(){
		
		 font = new Font("新宋体", Font.BOLD, 15);
		 map=new HashMap<String, Double>();
		
		jlPicture = new JLabel(new ImageIcon("C:/Users/lishan/Desktop/images/image2.png"));
		pictureStatistic = new JPanel(null);
		jlsellCostTotalPrice = new JLabel("销售成本:");
		jlsellProfitTotalPrice= new JLabel("利润:");
		jlsellProfitRate= new JLabel("毛利:");
		jlfinace = new JLabel("财务分析");
		jpFinace = new JPanel(null);
	    jlsellCostTotalPriceValue = new JLabel();
	    jlsellProfitTotalPriceValue= new JLabel();
		jlsellProfitRateValue= new JLabel();
		 jlSellMsg = new JLabel("销售详情");
		 jlSellProductTotalNumber= new JLabel("销售零件总数量");
		 jlSellBillNumber= new JLabel("销售总订单数");
		 jlSellProductTotalPrice= new JLabel("销售总金额");
		 jlSellBackProductTotalNumber= new JLabel("退货零件总数量");
		 jlSellBackBillNumber= new JLabel("退货总订单数");
		 jlSellBackProductTotalPrice= new JLabel("退货总金额");
			
		 jlSellProductTotalNumberValue= new JLabel();
		 jlSellBillNumberValue= new JLabel();
		 jlSellProductTotalPriceValue= new JLabel();
		 jlSellBackProductTotalNumberValue= new JLabel();
		 jlSellBackBillNumberValue= new JLabel();
		 jlSellBackProductTotalPriceValue= new JLabel();
		
		storeService = new StoreManagerServiceImp();
		
		jlstoreStatue = new JLabel("库存状况");
		jlstoreTotalNumber = new JLabel("库存总量");
		jlstoreTotalNumberValue = new JLabel();
		jlstoreTotalPrice = new JLabel("库存总价值");
		jlstoreTotalPriceValue = new JLabel();
		
	
		
		service = new BuyManagerServiceImp();
		tabBuyView = new JTable();
		
		snpBuyView = new JScrollPane();
		
		dtmBuyView = new DefaultTableModel();
		
		
		 purchase = new PurchaseDto();
		 jlBuyNumberValue  =new JLabel();
		 jlBuyBillNumberValue= new JLabel();
		 jlBuyMoneyValue= new JLabel();
		 jlBackNumberValue= new JLabel();
		 jlBackBillNumberValue= new JLabel();
		 jlBackMoneyValue= new JLabel();
		
		
		pBuy = new JPanel(null);
		pSell = new JPanel(null);
		pStore = new JPanel(null);
		jp = new JTabblePanel();
		jlMsg =new JLabel("采购详情");
		jlBuyNumber=new JLabel("采购数量:");
		jlBuyBillNumber=new JLabel("采购单数:");
		jlBuyMoney=new JLabel("采购金额:");
		jlBackNumber=new JLabel("退货单数:");
		jlBackBillNumber=new JLabel("退货数量:");
		jlBackMoney=new JLabel("退货金额 :");
		 //增加时间控件
		datepickstart = getDatePicker();
		datepickEnd = getDatePickerEnd();
        //增加按钮
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		 date = new Date();
		jlNowTime = new JLabel();
		jlS_ETime = new JLabel(); 
		jlTitle= new JLabel("营业分析"); 
		btnStatistic = new JButton("统计");
        btnGetTime = new JButton("获取起始时间");
        btnGetEndTime = new JButton("获取结束时间");
        jlzhi = new JLabel("至");
		pnlMain = new JPanel(null);
		pnlTop = new JPanel(null);
		pnllow = new JPanel(null);
		lbStatisticTime = new JLabel("统计时间:");
		init();
		
	}

	private void init() {

		Center.centerByWindow(this);
		this.setResizable(false);
		this.setResizable(false);
		timeEnd = sdf.format(datepickEnd.getValue());
	     timeStart = sdf.format(datepickstart.getValue());
	     timeNow = dateFormat.format(date);

		
			btnStatistic.addActionListener(new ActionListener() {
				
				
				@Override
				public void actionPerformed(ActionEvent e) {
					SetTimeData();
					setBuyPnlData(service.getBuyMangerByDateService(timeStart,timeEnd));
					setStoreState(storeService.getStoreStateByDateService(timeStart,timeEnd));
				}
			});
			
			
			
			jlPicture.setBounds(100, 100, 600, 250);
			jlsellCostTotalPrice.setBounds(40,280,150,50);
			jlsellProfitTotalPrice.setBounds(330,280 ,150,50);
			jlsellProfitRate.setBounds(330,100 ,150,50);
			jlfinace.setBounds(40,100 ,150,50);
			jlsellCostTotalPriceValue.setBounds(150,280,150,50);
		    jlsellProfitTotalPriceValue.setBounds(420,280 ,150,50);
			jlsellProfitRateValue.setBounds(420,100 ,150,50);
			
			
	
	
			jlstoreStatue.setBounds(60,100 ,60,50);
			jlstoreTotalNumber.setBounds(60,280 ,60,50);
			jlstoreTotalNumberValue.setBounds(125,280 ,60,50);
			jlstoreTotalPrice .setBounds(250,100 ,60,50);
			jlstoreTotalPriceValue.setBounds(315,100 ,150,50);
			
			
			
			
			
		
			jlSellMsg.setBounds(40,100 ,80,50);
			 jlSellProductTotalNumber.setBounds(20,280,100,50);
			 jlSellBillNumber.setBounds(230,100 ,80,50);
			 jlSellProductTotalPrice.setBounds(230,280 ,80,50);
			 jlSellBackProductTotalNumber.setBounds(390,100 ,120,50);
			 jlSellBackBillNumber.setBounds(420,280 ,80,50);
			 jlSellBackProductTotalPrice.setBounds(570,100 ,80,60);
				
			 jlSellProductTotalNumberValue.setBounds(125,280 ,60,50);
			 jlSellBillNumberValue.setBounds(315,100 ,60,50);
			 jlSellProductTotalPriceValue.setBounds(315,280 ,60,50);
			 jlSellBackProductTotalNumberValue.setBounds(505,100 ,60,50);
			 jlSellBackBillNumberValue.setBounds(505,280 ,60,50);
			 jlSellBackProductTotalPriceValue.setBounds(655,100 ,60,50);
			
			
			
			
			
		 jlBuyNumberValue.setBounds(125,280 ,60,50);
		 jlBuyBillNumberValue.setBounds(315,100 ,60,50);
		 jlBuyMoneyValue.setBounds(315,280 ,100,50);
		 jlBackNumberValue.setBounds(505,280 ,60,50);
		 jlBackBillNumberValue.setBounds(505,100 ,60,50);
		 jlBackMoneyValue.setBounds(655,100 ,100,50);
		
	 
		jp.setBounds(0,300,800,500);
		snpBuyView.setBounds(0,0,800,500);
		
		jlMsg.setBounds(60,100 ,100,50);
		jlBuyNumber.setBounds(60,280,60,50);
		jlBuyBillNumber.setBounds(250,100 ,60,50);
		jlBuyMoney.setBounds(250,280 ,60,50);
		jlBackNumber.setBounds(440,100 ,60,50);
		jlBackBillNumber.setBounds(440,280 ,60,50);
		jlBackMoney.setBounds(590,100 ,60,60);
		
		
		
		
	   
		jlS_ETime.setText("统计时间:"+timeStart+"至"+timeEnd);
		jlNowTime.setText("当前时间:"+timeNow);
		jlNowTime.setBounds(500,200 ,400,30);
		jlS_ETime.setBounds(50,200 ,400,30);
		
		
		
		
		jlTitle.setBounds(320, 150,200,30);
		btnStatistic.setBounds(400, 30,80,30);
		jlzhi.setBounds(240, 32, 30,20);
		btnGetTime.setBounds(130, 70, 100, 30);
		btnGetEndTime.setBounds(270, 70, 100, 30);
		pnlTop.setBounds(0, 0, 800, 200);
		pnllow.setBounds(0, 250, 800,550);
		lbStatisticTime.setBounds(30, 20,150, 40);
		
		jlMsg.setFont(new Font("宋体",Font.BOLD ,20) );
		jlfinace.setFont(new Font("宋体",Font.BOLD ,20) );
		jlsellCostTotalPrice .setFont(new Font("宋体",Font.BOLD ,15) );
		jlsellProfitTotalPrice.setFont(new Font("宋体",Font.BOLD ,15) );
		jlsellProfitRate.setFont(new Font("宋体",Font.BOLD ,15) );
		jlsellCostTotalPriceValue.setFont(new Font("宋体",Font.BOLD ,15) );
	    jlsellProfitTotalPriceValue.setFont(new Font("宋体",Font.BOLD ,15) );
		jlsellProfitRateValue.setFont(new Font("宋体",Font.BOLD ,15) );
		
		
		jlSellMsg.setFont(new Font("宋体",Font.BOLD ,15) );
		jlNowTime.setFont(new Font("宋体",Font.BOLD ,15) );
		jlS_ETime.setFont(new Font("宋体",Font.BOLD ,15) );
		jlTitle.setFont(new Font("宋体",Font.BOLD ,20) );
		btnStatistic.setFont(new Font("宋体",Font.BOLD ,20) );
		jlzhi.setFont(new Font("宋体",Font.BOLD ,20) );
		lbStatisticTime.setFont(new Font("宋体",Font.BOLD ,20) );
		
		
		
		//pBuy.add(snpBuyView);
		jp.add("采购详情",pBuy);
		jp.add("销售详情",pSell);
		jp.add("仓库详情",pStore);
		jp.add("财务分析",jpFinace);
		jp.add("图形统计",pictureStatistic);
		pnlMain.add(jp);
		
		pictureStatistic.add(jlPicture);
		
		
		jpFinace.add(jlsellCostTotalPrice);
		jpFinace.add(jlsellProfitTotalPrice);
		jpFinace.add(jlsellProfitRate);
		jpFinace.add(jlfinace);
		jpFinace.add(jlsellCostTotalPriceValue);
		jpFinace.add(jlsellProfitTotalPriceValue);
		jpFinace.add(jlsellProfitRateValue);

		
		
		
		pBuy.add(jlMsg);
		pBuy.add(jlBuyNumber);
		pBuy.add(jlBuyBillNumber);
		pBuy.add(jlBuyMoney);
		pBuy.add(jlBackNumber);
		pBuy.add(jlBackBillNumber);
		pBuy.add(jlBackMoney);
		pBuy.add(jlBuyNumberValue);
		pBuy.add(jlBuyBillNumberValue);
		pBuy.add(jlBuyMoneyValue);
		pBuy.add(jlBackNumberValue);
		pBuy.add(jlBackBillNumberValue);
		pBuy.add(jlBackMoneyValue);

		
		
		
		 pSell.add(jlSellMsg);
		 pSell.add(jlSellProductTotalNumber);
		 pSell.add(jlSellBillNumber);
		 pSell.add(jlSellProductTotalPrice);
		 pSell.add(jlSellBackProductTotalNumber);
		 pSell.add(jlSellBackBillNumber);
		 pSell.add(jlSellBackProductTotalPrice);
		 pSell.add(jlSellProductTotalNumberValue);
		 pSell.add(jlSellBillNumberValue);
		 pSell.add(jlSellProductTotalPriceValue);
		 pSell.add(jlSellBackProductTotalNumberValue);
		 pSell.add(jlSellBackBillNumberValue);
		 pSell.add(jlSellBackProductTotalPriceValue);
		pStore.add(jlstoreStatue);
		pStore.add(jlstoreTotalNumber);
		pStore.add(jlstoreTotalNumberValue);
		pStore.add(jlstoreTotalPrice);
		pStore.add(jlstoreTotalPriceValue);
		pnlMain.add(jlNowTime);
		pnlMain.add(jlTitle);
		pnlMain.add(jlS_ETime);
		
		pnlMain.add(btnStatistic);
		pnlMain.add(jlzhi);

		pnlMain.add(datepickstart);
		pnlMain.add(datepickEnd);
		pnlMain.add(pnlTop);
		pnlMain.add(pnllow);
		pnlTop.add(lbStatisticTime);
		
		
		 
		
		this.setTitle("营业分析");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.add(pnlMain);
		
		
		
		 
		this.setBounds(0, 0, 800, 800);
		this.setVisible(true);

	   
		
	}
	 protected void setStoreState(List<StoreStateDto> store) {
		 	int totalNumber = 0;
		 	Double totalPrice=0.0;
		 	if(!store.isEmpty()){
		 		for (StoreStateDto s : store) {
		 			totalNumber += s.getStoreNumber();
		 			totalPrice += s.getStoreNumber()*s.getStorePurchasePrice();
				}
		 		
		 		
		 		}
		 			
		 		
		 	
			jlstoreTotalNumberValue.setText(totalNumber+"件");
			
			jlstoreTotalPriceValue.setText(totalPrice+"元");
		
	}

	private void setBuyPnlData(List<PurchaseDto>purchase) {
		String path = "C:/Users/lishan/Desktop/images/image1.png";

		//jlPicture.setIcon(new ImageIcon(path));
		 int productNumber = 0;
		 int sellNumber =0;
		 int countPurchase =0;
		 int countBack =0;
		 Double priceProduct =0.0;
		 Double PriceBack =0.0;
		 Double productPrice =0.0;
		 Double PurchasetotalPrice =0.0;
		 Double BacktotalPrice =0.0;
		 
		 int sellProductNumber =0;
		 int sellBillNumber =0;
		 Double sellProductNumberPrice = 0.0;
		 int sellBackProductNumber =0;
		 int sellBackBillNumber =0;
		 Double sellBackNumberPrice = 0.0;
		 
		 
		 double  sellCostTotalPrice  =0.0;
	
		 double  sellProfitTotalPrice =0.0 ;
		 double  sellProfitRate = 0.0;
		 
	
			
			if(!purchase.isEmpty()){
				
				for (PurchaseDto p : purchase) {
					if(p.getPurchaseFlogDto()==1){
						PurchasetotalPrice = p.getPurchasePurchase_PriceDto()*p.getPurchaseProductNumberDto();
						productNumber+= p.getPurchaseProductNumberDto();
						countPurchase++;
						
						
						}else if(p.getPurchaseFlogDto()==2){ 
							BacktotalPrice = p.getPurchasePurchase_PriceDto()*p.getPurchaseProductNumberDto();
							sellNumber+=p.getPurchaseProductNumberDto();
							countBack++;
						}else if(p.getPurchaseFlogDto()==3){
							sellProductNumberPrice = p.getPurchaseSell_PriceDto()*p.getPurchaseProductNumberDto();
							sellBillNumber++;
							sellProductNumber = p.getPurchaseProductNumberDto();
						}else if(p.getPurchaseFlogDto()==4){
							sellBackProductNumber = p.getPurchaseProductNumberDto();
							sellBackNumberPrice = p.getPurchaseSell_PriceDto()*p.getPurchaseProductNumberDto();
							sellBackBillNumber++;
						}
					if(sellProductNumber==0){
						DecimalFormat df = new DecimalFormat("#.00");
						jlsellCostTotalPriceValue.setText(0+"元");

						jlsellProfitTotalPriceValue.setText(0+"元");

						jlsellProfitRateValue.setText(df.format(0)+"%");
					}else{
						sellCostTotalPrice +=  sellProductNumber*p.getPurchasePurchase_PriceDto();
						sellProfitTotalPrice+=(p.getPurchaseSell_PriceDto()*p.getPurchaseProductNumberDto()- p.getPurchasePurchase_PriceDto()*p.getPurchaseProductNumberDto());

						sellProfitRate =((double)((sellProfitTotalPrice)/(sellCostTotalPrice+sellProfitTotalPrice)))*100;
					}
					

					   DecimalFormat df = new DecimalFormat("#.00");
				
					 
					jlsellCostTotalPriceValue.setText(sellCostTotalPrice+"元");
					
					jlsellProfitTotalPriceValue.setText(sellProfitTotalPrice+"元");
	
					jlsellProfitRateValue.setText(df.format(sellProfitRate)+"%");
					
					p.setPurchaseBillNumberDto(countPurchase);
					p.setPurchaseProductNumberDto(productNumber);
					p.setPurchaseProductTotalDto(PurchasetotalPrice);
					p.setBackProductTotalPriceDto(BacktotalPrice);
					p.setBackProductNumberDto(sellNumber);
					p.setBackBillNumberDto(countBack);
					
					p.setSellBillNumber(sellProductNumber);
					p.setSellBillNumber(sellBillNumber);
					p.setSellTotalPrice(sellProductNumberPrice);
					p.setSellBackNumber(sellBackProductNumber);
					p.setSellBackBillNumber(sellBackBillNumber);
					p.setSellBackTotalPrice(sellBackNumberPrice);
					}
					

				
					
					for (PurchaseDto p : purchase) {
				
						
					jlBuyNumberValue.setText(p.getPurchaseProductNumberDto()+"件");
					
					jlBuyBillNumberValue.setText(p.getPurchaseBillNumberDto()+"条");
					
					jlBuyMoneyValue.setText(p.getPurchaseProductTotalDto()+"元");
					
					jlBackNumberValue.setText(p.getBackProductNumberDto()+"件");
			
					jlBackBillNumberValue.setText(p.getBackBillNumberDto()+"条");
					
					jlBackMoneyValue.setText(p.getBackProductTotalPriceDto()+"元");
					
					
					 jlSellProductTotalNumberValue.setText(sellProductNumber+"件");
					 jlSellBillNumberValue.setText(sellBillNumber+"条");
					 jlSellProductTotalPriceValue.setText(sellProductNumberPrice+"元");
					 jlSellBackProductTotalNumberValue.setText(sellBackProductNumber+"件");
					 jlSellBackBillNumberValue.setText(sellBackBillNumber+"条");
					 jlSellBackProductTotalPriceValue.setText(sellBackNumberPrice+"元");
					

					}
					
					map.put("成本", (double) sellCostTotalPrice);
					map.put("利润", (double) sellProfitTotalPrice);
					CharReport_BZT.createPort("量车定做-选定日期销售额详情", map, font,path);
					
					jlPicture.setIcon(new ImageIcon(path));
					
			}else{
				DecimalFormat df = new DecimalFormat("#.00");
				jlsellCostTotalPriceValue.setText(sellCostTotalPrice+"元");
				
				jlsellProfitTotalPriceValue.setText(sellProfitTotalPrice+"元");

				jlsellProfitRateValue.setText(df.format(sellProfitRate)+"%");
				jlBuyNumberValue.setText(0+"件");
				
				jlBuyBillNumberValue.setText(0+"条");
				
				jlBuyMoneyValue.setText(0.0+"元");
				
				jlBackNumberValue.setText(0+"件");
		
				jlBackBillNumberValue.setText(0+"条");
				
				jlBackMoneyValue.setText(0.0+"元");
				
				
				 jlSellProductTotalNumberValue.setText(sellProductNumber+"件");
				 jlSellBillNumberValue.setText(sellBillNumber+"条");
				 jlSellProductTotalPriceValue.setText(sellProductNumberPrice+"元");
				 jlSellBackProductTotalNumberValue.setText(sellBackProductNumber+"件");
				 jlSellBackBillNumberValue.setText(sellBackBillNumber+"条");
				 jlSellBackProductTotalPriceValue.setText(sellBackNumberPrice+"元");

				    map.put("成本", (double) sellCostTotalPrice);
					map.put("利润", (double) sellProfitTotalPrice);
					CharReport_BZT.createPort("量车定做-选定日期销售额详情", map, font,path);
					
					jlPicture.setIcon(new ImageIcon(path));
			}
			purchase.removeAll(purchase);
			

	 }

	protected void SetTimeData() {
		 
         timeEnd = sdf.format(datepickEnd.getValue());
         timeStart = sdf.format(datepickstart.getValue());
         jlS_ETime.setText("统计时间:"+timeStart+"至"+timeEnd);
         date = new Date();
         timeNow = dateFormat.format(date); 
         jlNowTime.setText("当前时间:"+timeNow);
	}
	private static DatePicker getDatePicker() {
	        final DatePicker datepick;
	       
	        // 格式
	        String DefaultFormat = "yyyy-MM-dd";
	        // 当前时间
	        Date date = new Date();
	        // 字体
	        Font font = new Font("Times New Roman", Font.BOLD, 14);
	        //时间控件的大小
	        Dimension dimension = new Dimension(100, 24);
	        //构造方法（初始时间，时间显示格式，字体，控件大小）
	        datepick = new DatePicker(date, DefaultFormat, font, dimension);
	      
	        datepick.setLocation(130, 30);//设置控件的位置
	        
	        
	        
	        
	        return datepick;
	    }
	 
	 private static DatePicker getDatePickerEnd() {
		 final DatePicker datepickEnd;
		 // 格式
	        String DefaultFormat = "yyyy-MM-dd";
	        // 当前时间
	        Date date = new Date();
	        // 字体
	        Font font = new Font("Times New Roman", Font.BOLD, 14);
	        //时间控件的大小
	        Dimension dimension = new Dimension(100, 24);
	        //构造方法（初始时间，时间显示格式，字体，控件大小）
	     
	        datepickEnd = new DatePicker(date, DefaultFormat, font, dimension);
	       
	        datepickEnd.setLocation(270, 30); 
	        return datepickEnd;
	 }
}

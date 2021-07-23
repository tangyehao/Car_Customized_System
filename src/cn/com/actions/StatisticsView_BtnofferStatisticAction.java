package cn.com.actions;



import cn.com.views.PnlStatisticsView;
import cn.com.views.statistic.Billreaserch_View;

import java.awt.*;


public class StatisticsView_BtnofferStatisticAction implements Action {
	private PnlStatisticsView ps ;

	public StatisticsView_BtnofferStatisticAction(){

	}
	@Override
	public void execute(Object e, Container w, Object... params) {
	
		new Billreaserch_View();
	}

}

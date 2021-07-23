package cn.com.actions;

import cn.com.views.statistic.BusinessAnalysis_View;

import java.awt.*;

public class StaticsView_BtnBussinessStatisticAction implements Action {

	@Override
	public void execute(Object e, Container w, Object... params) {
		new BusinessAnalysis_View();
		}

}

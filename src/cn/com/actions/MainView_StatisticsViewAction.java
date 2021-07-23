package cn.com.actions;

import cn.com.views.MainView;
import cn.com.views.StatostocsView;

import java.awt.*;

public  class MainView_StatisticsViewAction implements Action {
	@Override
	public void execute(Object e, Container c, Object... params) {
		new StatostocsView(new Frame(),"统计报表",true);
	}
}

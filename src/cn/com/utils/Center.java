package cn.com.utils;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

public class Center {
	private Center(){
		
	}

	public static void centerByWindow(Window w) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension size = tk.getScreenSize();
		int sw = (int)size.getWidth();
		int sh = (int)size.getHeight();
		int ww = w.getWidth();
		int wh = w.getHeight();
		w.setLocation((sw - ww)/2, (sh - wh)/2);
	}
}

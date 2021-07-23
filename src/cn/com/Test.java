package cn.com;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import cn.com.views.MainView;
import cn.com.views.loginview.LoginView;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

		new LoginView("量车定做");
		//new MainView();
	}

}

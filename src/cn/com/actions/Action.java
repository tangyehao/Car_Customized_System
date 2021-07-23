package cn.com.actions;

import java.awt.Container;
import java.awt.Window;
import java.util.EventObject;

public interface Action {
	void execute(Object e,Container c,Object...params);
}

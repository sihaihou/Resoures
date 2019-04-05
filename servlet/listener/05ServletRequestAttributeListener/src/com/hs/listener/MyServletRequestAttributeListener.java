package com.hs.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
/**
 * 分别向request域中添加、删除、修改时触发
 * @author Administrator
 *
 */
public class MyServletRequestAttributeListener implements ServletRequestAttributeListener {

    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
    	System.out.println("从request域中移除了一个属性--name=="+srae.getName());
    }
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
    	System.out.println("向request域中添加了一个属性--name=="+srae.getName()+"  value=="+srae.getValue());
    }
    
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    	System.out.println("从request域中修改了一个属性---name=="+srae.getName()+"  value=="+srae.getValue());
    }
	
}

package com.hs.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
/**
 * �ֱ���request������ӡ�ɾ�����޸�ʱ����
 * @author Administrator
 *
 */
public class MyServletRequestAttributeListener implements ServletRequestAttributeListener {

    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
    	System.out.println("��request�����Ƴ���һ������--name=="+srae.getName());
    }
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
    	System.out.println("��request���������һ������--name=="+srae.getName()+"  value=="+srae.getValue());
    }
    
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    	System.out.println("��request�����޸���һ������---name=="+srae.getName()+"  value=="+srae.getValue());
    }
	
}

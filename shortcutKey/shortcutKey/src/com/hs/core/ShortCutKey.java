package com.hs.core;
/**
 * 常用快捷键
 *   打印流: sys + alt+/
 *   main:  main + alt+/
 *   运行： ctrl+F11
 *   debug: F11
 *   重命名：选中—— alt+shift+r
 *   修改项目发布名： 
 *   新建：  ctrl+N
 *   对话框中进行的快捷键操作： alt+带下划线的字母
 * 	   窗口最大化与还原：  ctrl+M
 *   打开被选中的工程、包、文件等的属性窗口：alt+enter
 * 	   编辑窗口切换： ctrl+ pageUp/pageDown  或者  ctrl+E
 * 	   向上向下复制：  ctrl+alt+向上/向下箭头
 * 	   删除：选中那几行——ctrl+d
 *   行上下移动： 选中—— alt+向上/向下箭头
 *   插入行： shift+enter
 *   给出解决方法： ctrl+1
 * 	   给出提示：  alt+/
 *   撤销/恢复： ctrl+z/y
 *   单行注释：ctrl+/
 *   多行注释与撤销注释：ctrl+shift+/ 与   ctrl+shift+\
 *   空构造器： alt+shift+s——> C ——>enter 
 *   带参构造器：alt+shift——> O ——>enter 	
 *   setting/getting方法:alt+shift+s——>R——>tab——>enter——>tab+shift——>enter
 *   toString方法: alt+shift+S——>S——>enter 
 *   格式化代码：alt+shift+S——F
 *   对选中代码段进行surrount with： alt+shift+z——>带下滑线的字母
 *   将选中内容抽取为变量：alt+shift+L
 *   将选中内容抽取为方法：alt+shift+M
 *   将选中内容打印：alt+/——>向上箭头——>enter
 *   将局部变量转成员变量：光标放在局部变量上——>ctrl+1——>ConvertXXX
 *   向左/向右选择：shift+向左/向右箭头
 *   快速选择开头/结尾：shift+home/end
 *   快速选择:shift+向上/向下箭头
 *   查看继承实现关系：光标放在该类上——>ctrl+t
 *   查看类的结构：光标放在该类上——>ctrl+o
 *   查看类：  ctrl+鼠标点击类
 *   返回光标上次停留额位置: alt + 向左/向右箭头
 *   
 * @author sihaihou
 *
 */
public class ShortCutKey {
	private String name;
	public int getId() {
		return id;
	}

	public void setId(int id) {
//		this.id = id;
	}
	private int id;

	
	public static void main(String[] args) {
		Integer name = 4;
		System.out.println("111");
	}
	
}

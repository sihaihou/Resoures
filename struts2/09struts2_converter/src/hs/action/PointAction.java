package hs.action;

import com.opensymphony.xwork2.Action;

import hs.entity.Point;

public class PointAction {
	private Point point;
	public String execute(){
		System.out.println("("+point.getX()+","+point.getY()+")");
		return Action.SUCCESS;
	}

	
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}	
}

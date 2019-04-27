package hs.chainOfResp;
/**
 * 经理
 * @author Administrator
 */
public class Manager extends Leader{
	public Manager(String name) {
		super(name);
	}
	/**
	 * 当前对象处理方法
	 */
	@Override
	public void HandleReques(LeaveRequest request) {
		if(request.getLeaveDays()<10){
			System.out.println("员工"+request.getName()+"请假，天数："+request.getLeaveDays()+",理由:"+request.getReason());
			System.out.println("经理"+this.name+"给予"+request.getName()+"请假审批通过！");
		}else{
			if(null!=this.nextLeader){
				this.nextLeader.HandleReques(request);
			}
		}
	}	
}

package hs.chainOfResp;
/**
 * 主任
 * @author Administrator
 */
public class Director extends Leader{
	public Director(String name) {
		super(name);
	}
	@Override
	public void HandleReques(LeaveRequest request) {
		if(request.getLeaveDays()<3){
			System.out.println("员工"+request.getName()+"请假，天数："+request.getLeaveDays()+",理由:"+request.getReason());
			System.out.println("主任"+this.name+"给予"+request.getName()+"请假审批通过！");
		}else{
			if(null!=this.nextLeader){
				this.nextLeader.HandleReques(request);
			}
		}
	}	
}

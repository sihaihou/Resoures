package hs.chainOfResp;
/**
 * 总经理
 * @author Administrator
 */
public class GeneralManager extends Leader{
	public GeneralManager(String name) {
		super(name);
	}
	@Override
	public void HandleReques(LeaveRequest request) {
		if(request.getLeaveDays()<30){
			System.out.println("员工"+request.getName()+"请假，天数："+request.getLeaveDays()+",理由:"+request.getReason());
			System.out.println("总经理"+this.name+"给予"+request.getName()+"请假审批通过！");

		}else{
			System.out.println("此人可能想辞职，审批不通过！");
		}
	}	
}

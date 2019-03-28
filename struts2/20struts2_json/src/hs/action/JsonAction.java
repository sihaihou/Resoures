package hs.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

import hs.pojo.User;
import net.sf.json.JSONArray;

public class JsonAction {
	private JSONArray root;
	public String execute() throws IOException{
		List<User> list=new ArrayList<User>();
		list.add(new User("·ÉÑï","123456"));
		list.add(new User("Ðì·ç","654321"));
		root  = JSONArray.fromObject(list);
		System.out.println(root.toString());
 		return "success";
	}
	public JSONArray getRoot() {
		return root;
	}
	public void setRoot(JSONArray root) {
		this.root = root;
	}
}

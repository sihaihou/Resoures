package hs.action;

import java.util.List;

import com.opensymphony.xwork2.Action;
/**
 * 批量数据处理：数组处理 |List处理
 * @author 侯四海
 */
public class UserAction {
	private String name;
	private String[] hubbies;
	private List<String> games;
	public String execute(){
		System.out.println("name:"+name);
		System.out.print("hubbies:");
		for(int i = 0 ; i < hubbies.length; i++){
			System.out.print(hubbies[i]+"\t");
		}
		System.out.println();
		System.out.println("games:\t"+games);
		return Action.SUCCESS;
	}	
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getHubbies() {
		return hubbies;
	}
	public void setHubbies(String[] hubbies) {
		this.hubbies = hubbies;
	}
	public List<String> getGames() {
		return games;
	}
	public void setGames(List<String> games) {
		this.games = games;
	}	
}

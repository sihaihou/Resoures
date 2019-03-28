package hs.student;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
/**	
 * 		注入：
 * 		bean的作用域 ：
 * @author Administrator
 *
 */
public class Student {
	private String name;
	private Address addr;
	private String[] books;
	private List<String> hobbies;
	private Map<String,String> cards;
	private Set<String> games;
	private String wife;
	private Properties info;
	public void setName(String name) {
		this.name = name;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	public void setBooks(String[] books) {
		this.books = books;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	public void setCards(Map<String, String> cards) {
		this.cards = cards;
	}
	public void setGames(Set<String> games) {
		this.games = games;
	}
	public void setWife(String wife) {
		this.wife = wife;
	}
	public void setInfo(Properties info) {
		this.info = info;
	}
	public void show(){
		System.out.println("name:"+name+"    addr:"+addr.getAddress());
		System.out.println("所看的Books:");
		for(int i=0;i<books.length;i++){
			System.out.print(books[i]+"   ");
		}
		System.out.println();
		System.out.println("hobbies:"+hobbies);
		System.out.println("cards:"+cards);
		System.out.println("games:"+games);
		System.out.println("wife:"+wife);
		System.out.println("info:"+info);
	}	
}

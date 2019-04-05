package hs.pojo;

import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.ObjectMapper;
/**
 * 测试 Jackson
 * @author Administrator
 *
 */
public class Customer {
	private String no;
	private String name;
	
	public Customer(String no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	@JsonIgnore
	public void setName(String name) {
		this.name = name;
	}
	public String getBrithday() {
		return "1994-04-12";
	}
	public static void main(String[] args) throws Exception {
		/**
		 * 1,导入jar包
		 * 2，创建ObjectMapper对象
		 * 3，调用 ObjectMapper 对象的 writeValueAsString 方法，把一个对象或集合转换为JSON字符串。
		 * 4，注意：Jackson使用getter方法来定位JSON对象的属性。
		 * 5，可以通过添加注解 @JsonIgnore 来忽略getter定义的属性。
		 */
		ObjectMapper mapper = new ObjectMapper();
		Customer c = new Customer("张三", "1001");
		Customer c2 = new Customer("张三", "1002");
		List<Customer> list = Arrays.asList(c,c2);
		String jsonStr = mapper.writeValueAsString(list);
		System.err.println(jsonStr);
	}
}

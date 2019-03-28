package hs.pojo;

import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.ObjectMapper;
/**
 * ���� Jackson
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
		 * 1,����jar��
		 * 2������ObjectMapper����
		 * 3������ ObjectMapper ����� writeValueAsString ��������һ������򼯺�ת��ΪJSON�ַ�����
		 * 4��ע�⣺Jacksonʹ��getter��������λJSON��������ԡ�
		 * 5������ͨ�����ע�� @JsonIgnore ������getter��������ԡ�
		 */
		ObjectMapper mapper = new ObjectMapper();
		Customer c = new Customer("����", "1001");
		Customer c2 = new Customer("����", "1002");
		List<Customer> list = Arrays.asList(c,c2);
		String jsonStr = mapper.writeValueAsString(list);
		System.err.println(jsonStr);
	}
}

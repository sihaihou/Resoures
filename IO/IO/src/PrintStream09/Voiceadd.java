package PrintStream09;
/**
 * ������     ������������װ�����ģʽ
 * ������֮��Ĺ�ϵ��
 *  1������:�β�|�ֲ�����
 *  2������������
 *  	  �ۺϣ����� �����벿��    ��һ�µ���������     �� ������
 *  	  ��ϣ����� �����벿��   һ�µ���������     �� �������
 *  3���̳У��������ϵ
 *  4��ʵ�֣�  �ӿ���ʵ�����ϵ
 * @author Administrator
 */
public class Voiceadd {
	private Voice voice;
	public Voiceadd() {
		// TODO Auto-generated constructor stub
	}
	public Voiceadd(Voice voice) {
		super();
		this.voice = voice;
	}
	public void say(){
		System.out.println(voice.getVoice()*10);
	}
}

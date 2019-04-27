package PrintStream09;

public class VoiecApp04 {
	public static void main(String[] args) {
		Voice v=new Voice();
		v.say();
		Voiceadd va=new Voiceadd(v);
		va.say();
	}
}

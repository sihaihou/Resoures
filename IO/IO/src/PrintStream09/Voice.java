package PrintStream09;

public class Voice {
	private int voice=10;
	public Voice() {
		// TODO Auto-generated constructor stub
	}
	public Voice(int voice) {
		super();
		this.voice = voice;
	}
	public int getVoice() {
		return voice;
	}
	public void setVoice(int voice) {
		this.voice = voice;
	}
	public void say(){
		System.out.println(voice);
	}
}

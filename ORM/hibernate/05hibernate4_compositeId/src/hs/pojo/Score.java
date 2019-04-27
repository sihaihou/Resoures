package hs.pojo;

/**
 * 组合主键映射
 * @author Administrator
 *
 */
public class Score {
	private ScoreId scoreId;
	private double result;//成绩	
	public ScoreId getScoreId() {
		return scoreId;
	}
	public void setScoreId(ScoreId scoreId) {
		this.scoreId = scoreId;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}	
}

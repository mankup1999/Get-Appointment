package co.manku.main;

public class Application {
	
	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + ", content=" + content + ", status=" + status
				+ ", intent=" + intent + ", referId=" + referId + "]";
	}

	private int applicationId;
	private String content;
	private String status;
	private String intent;
	private int referId;

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIntent() {
		return intent;
	}

	public void setIntent(String intent) {
		this.intent = intent;
	}

	public int getReferId() {
		return referId;
	}

	public void setReferId(int referId) {
		this.referId = referId;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

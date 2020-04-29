package co.manku.main;

public class Reference {
	
	@Override
	public String toString() {
		return "Reference [referId=" + referId + ", referStatus=" + referStatus + ", applicationId=" + applicationId
				+ ", celebId=" + celebId + "]";
	}


	private int referId;
	private String referStatus;
	private int applicationId;
	private int celebId;
	

	public int getReferId() {
		return referId;
	}


	public void setReferId(int referId) {
		this.referId = referId;
	}


	public String getReferStatus() {
		return referStatus;
	}


	public void setReferStatus(String referStatus) {
		this.referStatus = referStatus;
	}


	public int getApplicationId() {
		return applicationId;
	}


	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}


	public int getCelebId() {
		return celebId;
	}


	public void setCelebId(int celebId) {
		this.celebId = celebId;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

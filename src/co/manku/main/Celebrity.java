package co.manku.main;

public class Celebrity {
	
	@Override
	public String toString() {
		return "Celebrity [celebId=" + celebId + ", verifyStatus=" + verifyStatus + ", name=" + name + ", email="
				+ email + ", mob=" + mob + ", photo=" + photo + ", officeAddress=" + officeAddress + ", enableMail="
				+ enableMail + ", enableMsg=" + enableMsg + ", needReferral=" + needReferral + ", isPaid=" + isPaid
				+ "]";
	}

	private int celebId;
	private String verifyStatus;
	private String name;
	private String email;
	private long mob;
	private String photo;
	private String officeAddress;
	private String enableMail;
	private String enableMsg;
	private String needReferral;
	private String isPaid;

	public int getCelebId() {
		return celebId;
	}

	public void setCelebId(int celebId) {
		this.celebId = celebId;
	}

	public String getVerifyStatus() {
		return verifyStatus;
	}

	public void setVerifyStatus(String verifyStatus) {
		this.verifyStatus = verifyStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMob() {
		return mob;
	}

	public void setMob(long mob) {
		this.mob = mob;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public String getEnableMail() {
		return enableMail;
	}

	public void setEnableMail(String enableMail) {
		this.enableMail = enableMail;
	}

	public String getEnableMsg() {
		return enableMsg;
	}

	public void setEnableMsg(String enableMsg) {
		this.enableMsg = enableMsg;
	}

	public String getNeedReferral() {
		return needReferral;
	}

	public void setNeedReferral(String needReferral) {
		this.needReferral = needReferral;
	}

	public String getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

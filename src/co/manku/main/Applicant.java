package co.manku.main;

public class Applicant {

	@Override
	public String toString() {
		return "Applicant [applicantId=" + applicantId + ", name=" + name + ", email=" + email + ", mob=" + mob
				+ ", photo=" + photo + ", address=" + address + "]";
	}


	private int applicantId;
	private String name;
	private String email;
	private long mob;
	private String photo;
	private String address;
	
	public int getApplicantId() {
		return applicantId;
	}


	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public static void main(String[] args) {
		
	}

}

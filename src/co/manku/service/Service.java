package co.manku.service;

import java.sql.ResultSet;
import java.util.ArrayList;

import co.manku.dao.DBConnection;
import co.manku.main.Applicant;
import co.manku.main.Application;
import co.manku.main.Celebrity;
import co.manku.main.Reference;

public class Service {
	
	public int isApplicantDetailsValid(String username,String password) {
		int applicantId=-1;
		String query="select ApplicantId from Applicant_Login where Username='"+username+"' and Password='"+password+"'";
		ResultSet res= DBConnection.processQuery(query);
		try {
			if(res.next())
				applicantId=res.getInt("ApplicantId");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			return applicantId;
		}
	}
	
	public Applicant getApplicant(int applicantId) {
		Applicant applicant=null;
		String query="select * from Applicant_Details where ApplicantId="+applicantId;
		ResultSet res= DBConnection.processQuery(query);
		try {
			if(res.next()) {
				applicant=new Applicant();
				applicant.setName(res.getString("Name"));
				applicant.setApplicantId(res.getInt("ApplicantId"));
				applicant.setEmail(res.getString("Email"));
				applicant.setMob(res.getLong("Mob"));
				applicant.setAddress(res.getString("Address"));
				applicant.setPhoto(res.getString("Photo"));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			return applicant;
		}
	}

	public ArrayList<Integer> isApplicationAvailable(int applicantId) {
		ArrayList<Integer> applications=null;
		String query="select ApplicationId from Applications where ApplicantId="+applicantId;
		ResultSet res= DBConnection.processQuery(query);
		try {
			if(res.next()) {
				applications=new ArrayList<Integer>();
				applications.add(res.getInt("ApplicationId"));
			}
			while(res.next()) {
				applications.add(res.getInt("ApplicationId"));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			return applications;
		}
	}

	public Application getApplicationDetails(int applicationId) {
		Application application=null;
		String query="select * from Application_Details where ApplicationId="+applicationId;
		ResultSet res= DBConnection.processQuery(query);
		try {
			if(res.next()) {
				application=new Application();
				application.setApplicationId(res.getInt("ApplicationId"));
				application.setContent(res.getString("Content"));
				application.setIntent(res.getString("Intent"));
				application.setReferId(res.getInt("ReferId"));
				application.setStatus(res.getString("Status"));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			return application;
		}
	}

	public ArrayList<Reference> isReferAvailable(int applicationId){
		ArrayList<Reference> refers=null;
		String query="select * from Refer_Details where ApplicationId="+applicationId;
		ResultSet res= DBConnection.processQuery(query);
		try {
			if(res.next()) {
				refers=new ArrayList<Reference>();
				Reference ref=new Reference();
				ref.setApplicationId(res.getInt("ApplicationId"));
				ref.setCelebId(res.getInt("CelebId"));
				ref.setReferId(res.getInt("ReferId"));
				ref.setReferStatus(res.getString("ReferStatus"));
				refers.add(ref);
			}
			while(res.next()) {
				Reference ref=new Reference();
				ref.setApplicationId(res.getInt("ApplicationId"));
				ref.setCelebId(res.getInt("CelebId"));
				ref.setReferId(res.getInt("ReferId"));
				ref.setReferStatus(res.getString("ReferStatus"));
				refers.add(ref);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			return refers;
		}
	}

	public int isCelebrityDetailsValid(String username,String password) {
		int celebId=-1;
		String query="select CelebId from Celeb_Login where Username='"+username+"' and Password='"+password+"'";
		ResultSet res= DBConnection.processQuery(query);
		try {
			if(res.next())
				celebId=res.getInt("CelebId");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			return celebId;
		}
	}
	
	public Celebrity getCelebrity(int celebId) {
		Celebrity celeb=null;
		String query="select * from Celeb_Details where CelebId="+celebId;
		ResultSet res= DBConnection.processQuery(query);
		try {
			if(res.next()) {
				celeb=new Celebrity();
				celeb.setCelebId(res.getInt("CelebId"));
				celeb.setEmail(res.getString("Email"));
				celeb.setEnableMail(res.getString("EnableMail"));
				celeb.setEnableMsg(res.getString("EnableMsg"));
				celeb.setIsPaid(res.getString("IsPaid"));
				celeb.setMob(res.getLong("Mob"));
				celeb.setName(res.getString("Name"));
				celeb.setNeedReferral(res.getString("NeedReferral"));
				celeb.setOfficeAddress(res.getString("OfficeAddress"));
				celeb.setPhoto(res.getString("Photo"));
				celeb.setVerifyStatus(res.getString("VerifyStatus"));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			return celeb;
		}
	}
	
	public ArrayList<String> getIntents(int celebId){
		ArrayList<String> intents=null;
		String query="select Intent from Celeb_Intent_Deatils where CelebId="+celebId;
		ResultSet res= DBConnection.processQuery(query);
		try {
			if(res.next()) {
				intents=new ArrayList<String>();
				intents.add(res.getString(1));
			}
			while(res.next()) {
				intents.add(res.getString(1));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			return intents;
		}
	}

	public ArrayList<String> getVideos(int celebId){
		ArrayList<String> videos=null;
		String query="select Video from Celeb_Video where CelebId="+celebId;
		ResultSet res= DBConnection.processQuery(query);
		try {
			if(res.next()) {
				videos=new ArrayList<String>();
				videos.add(res.getString(1));
			}
			while(res.next()) {
				videos.add(res.getString(1));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			return videos;
		}
	}
	
	public int insertApplicant(Applicant applicant) {
		int status=-1;
		int applicantId=applicant.getApplicantId();
		String name=applicant.getName();
		String email=applicant.getEmail();
		long mob=applicant.getMob();
		String address=applicant.getAddress();
		String photo=applicant.getPhoto();
		String query="insert into Applicant_Details(ApplicantId,Name,Email,Mob,Address,Photo)"
				+ "values ("+applicantId+",'"+name+"','"+email+"',"+mob+",'"+address+"','"+photo+"')";
		//System.out.println(query);
		status=DBConnection.update(query);
		return status;
	}
	public int insertCeleb(Celebrity celeb) {
		int status=-1;
		int celebId=celeb.getCelebId();
		String name=celeb.getName();
		String email=celeb.getEmail();
		long mob=celeb.getMob();
		String address=celeb.getOfficeAddress();
		String photo=celeb.getPhoto();
		String enableMail=celeb.getEnableMail();
		String enableMsg=celeb.getEnableMsg();
		String isPaid=celeb.getIsPaid();
		String needReferral=celeb.getNeedReferral();
		String verifyStatus=celeb.getVerifyStatus();
		String query="insert into Celeb_Details"
				+ "(CelebId,Name,Email,Mob,OfficeAddress,Photo,EnableMail,EnableMsg,IsPaid,NeedReferral,VerifyStatus)"
				+ "values"
				+ "("+celebId+",'"+name+"','"+email+"',"+mob+",'"+address+"',"+photo+","+enableMail+","
						+ enableMsg+","+isPaid+","+needReferral+","+verifyStatus
				+ ")";
		//System.out.println(query);
		status=DBConnection.update(query);
		return status;
	}
	
	public int insertApplicantLogin(String username,String password,int applicantId) {
		int status=-1;
		String query="insert into Applicant_Login(ApplicantId,Username,Password)"
				+ "values ("+applicantId+",'"+username+"','"+password+"')";
		//System.out.println(query);
		status=DBConnection.update(query);
		return status;
	}
	public int insertCelebLogin(String username,String password,int celebId) {
		int status=-1;
		String query="insert into Celeb_Login(CelebId,Username,Password)"
				+ "values ("+celebId+",'"+username+"','"+password+"')";
		//System.out.println(query);
		status=DBConnection.update(query);
		return status;
	}
	public int adminVerify(int celebId) {
		int status=-1;
		String query="insert into AdminVerification(CelebId)"
				+ "values ("+celebId+")";
		//System.out.println(query);
		status=DBConnection.update(query);
		return status;
	}
	
	public ArrayList<Integer> getAdminVerifyData(){
		ArrayList<Integer> res=null;
		String query="select * from AdminVerification";
		ResultSet result=DBConnection.processQuery(query);
		try {
			if(result.next()) {
				res=new ArrayList<Integer>();
				res.add(result.getInt("CelebId"));
			}
			while(result.next()) {
				res.add(result.getInt("CelebId"));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			return res;
		}
	}
	
	public int verifyStatus(int celebId) {
		int status=-1;
		String query="update Celeb_Details set VerifyStatus=1 where CelebId="+celebId;
		//System.out.println(query);
		status=DBConnection.update(query);
		return status;
	}
	
	public int deleteAdminVerify(int celebId) {
		int status=-1;
		String query="delete from AdminVerification where CelebId="+celebId;
		//System.out.println(query);
		status=DBConnection.update(query);
		return status;
	}
	
	public int getNewCelebId() {
		int id=105;
		String query="select max(CelebId) from Celeb_Details";
		ResultSet res=DBConnection.processQuery(query);
		try {
			if(res.next()) {
				id=res.getInt(1)+1;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			return id;
		}
	}
	public int getNewApplicantId() {
		int id=100;
		String query="select max(ApplicantId) from Applicant_Details";
		ResultSet res=DBConnection.processQuery(query);
		try {
			if(res.next()) {
				id=res.getInt(1)+1;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			return id;
		}
	}
	
	public ArrayList<Integer> getVerifiedCelebs(){
		ArrayList<Integer> celebs=null;
		String query="select CelebId from Celeb_Details where VerifyStatus=1";
		try {
			ResultSet res=DBConnection.processQuery(query);
			if(res.next()) {
				celebs=new ArrayList<Integer>();
				celebs.add(res.getInt(1));
			}
			while(res.next()) {
				celebs.add(res.getInt(1));
			}
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		finally {
			return celebs;
		}
	}
	
	public static void main(String[] args) {
		Service service=new Service();
		int id=service.isApplicantDetailsValid("root","password");
		Applicant applicant=service.getApplicant(123);
		ArrayList<Integer> applications=service.isApplicationAvailable(123);
		Application application=service.getApplicationDetails(123);
		ArrayList<Reference> refers=service.isReferAvailable(123);
		int celebId=service.isCelebrityDetailsValid("root", "password");
		Celebrity celeb=service.getCelebrity(123);
		ArrayList<String> intents=service.getIntents(123);
		ArrayList<String> videos=service.getVideos(123);
		/*System.out.println(id);
		System.out.println(applicant);
		System.out.println(applications);
		System.out.println(application);
		System.out.println(refers);
		System.out.println(celebId);
		System.out.println(celeb);
		System.out.println(intents);
		System.out.println(videos);*/
		
		//int status=service.insertApplicant(applicant);
		//System.out.println(status);
		//int status=service.insertApplicantLogin("XYZ", "XYZ", 101);
		//System.out.println(status);
		//System.out.println(service.insertCeleb(celeb));
		//System.out.println(service.adminVerify(101));
		//System.out.println(service.getAdminVerifyData());
		//System.out.println(service.verifyStatus(celebId));
		//System.out.println(service.deleteAdminVerify(celebId));
		//System.out.println(service.getNewCelebId());
		//System.out.println(service.getNewApplicantId());
	}

}

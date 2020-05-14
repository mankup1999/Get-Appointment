

function myCommon(){
	var name=document.getElementById("name").innerHTML;
	var email=document.getElementById("email").innerHTML;
	var mob=document.getElementById("mob").innerHTML;
	var username=document.getElementById("username").innerHTML;
	var password=document.getElementById("password").innerHTML;
	var conf_password=document.getElementById("conf_password").innerHTML;
	
	if(name.length==0 && email.length==0 && mob.length==0 && username.length==0 && password.length==0 &&
			conf_password.length==0)
		document.getElementById("submit_id").disabled=false;
	else
		document.getElementById("submit_id").disabled=true;
}

function myName(str){
	if(str.length==0){
		document.getElementById("name").innerHTML="";
		return;
	}
	else{
		var xmlhttp=new XMLHttpRequest();
		xmlhttp.onreadystatechange=function(){
			if(this.readyState==4 && this.status==200){
				document.getElementById("name").innerHTML=this.responseText;
				myCommon();
			}
		};
		
		xmlhttp.open("GET","http://localhost:8080/appointment/nameValidate?name="+str,true);
		xmlhttp.send();
	}
}

function myEmail(str){
	if(str.length==0){
		document.getElementById("email").innerHTML="";
		return;
	}
	else{
		var xmlhttp=new XMLHttpRequest();
		xmlhttp.onreadystatechange=function(){
			if(this.readyState==4 && this.status==200){
				document.getElementById("email").innerHTML=this.responseText;
				myCommon();
			}
		};
		
		xmlhttp.open("GET","http://localhost:8080/appointment/emailValidate?email="+str,true);
		xmlhttp.send();
	}
}

function myMob(str){
	if(str.length==0){
		document.getElementById("mob").innerHTML="";
		return;
	}
	else{
		var xmlhttp=new XMLHttpRequest();
		xmlhttp.onreadystatechange=function(){
			if(this.readyState==4 && this.status==200){
				document.getElementById("mob").innerHTML=this.responseText;
				myCommon();
			}
		};
		
		xmlhttp.open("GET","http://localhost:8080/appointment/mobileValidate?mob="+str,true);
		xmlhttp.send();
	}
}

function myUsername(str){
	if(str.length==0){
		document.getElementById("username").innerHTML="";
		return;
	}
	else{
		var xmlhttp=new XMLHttpRequest();
		xmlhttp.onreadystatechange=function(){
			if(this.readyState==4 && this.status==200){
				document.getElementById("username").innerHTML=this.responseText;
				myCommon();
			}
		};
		
		xmlhttp.open("GET","http://localhost:8080/appointment/usernameValidate?username="+str,true);
		xmlhttp.send();
		
	}
}

function myPassword(str){
	if(str.length==0){
		document.getElementById("password").innerHTML="";
		return;
	}
	else{
		    var xmlhttp=new XMLHttpRequest();
		    xmlhttp.onreadystatechange=function(){
			if(this.readyState==4 && this.status==200){
				document.getElementById("password").innerHTML=this.responseText;
				myCommon();
			}
		};
		
		xmlhttp.open("GET","http://localhost:8080/appointment/passwordValidate?password="+str,true);
		xmlhttp.send();
	}
}

function myConfPassword(str){
	if(str.length==0){
		document.getElementById("conf_password").innerHTML="";
		return;
	}
	else{
			var xmlhttp=new XMLHttpRequest();
			xmlhttp.onreadystatechange=function(){
			if(this.readyState==4 && this.status==200){
				document.getElementById("conf_password").innerHTML=this.responseText;
				myCommon();
			}
		};
		var y=document.getElementById("conf").value;
		xmlhttp.open("GET","http://localhost:8080/appointment/confPasswordValidate?conf_password="+str+"&password="+y,true);
		xmlhttp.send();
	}
}

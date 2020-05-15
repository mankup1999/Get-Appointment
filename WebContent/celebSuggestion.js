function searchCeleb(str){
		//alert(str);
		if(str.length==0){
			document.getElementById("suggestedCeleb").innerHTML="";
			return;
		}
		else{
			var xmlhttp=new XMLHttpRequest();
			xmlhttp.onreadystatechange=function(){
				if(this.readyState==4 && this.status==200){
					document.getElementById("suggestedCeleb").innerHTML=this.responseText;
				}
			};
			
			xmlhttp.open("GET","http://localhost:8080/appointment/suggestCelebs?q="+str,true);
			xmlhttp.send();
		}
	}
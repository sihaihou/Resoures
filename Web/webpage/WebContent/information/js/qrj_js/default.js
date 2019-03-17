var message_str="祝你情人节快乐!!!";
		var hellotext="祝你情人节快乐!!! ";
		function init(){
			var iWidth = window.screen.availWidth-20; 
			document.getElementById("Layer1").style.width=iWidth;
			if (navigator.appName == "Netscape"){
				document.getElementById("Layer1").style.display="none";
			}else{
				document.getElementById("Layer1").style.display="";
			}
		} 
		function hs(t){
			var obj = document.getElementById("hs"+t);
			if(t=='1'){
				wishselect1();
				obj.checked=true;
			}
			if(t=='2'){
				wishselect2();
				obj.checked=true;
			}
			if(t=='3'){
				wishselect3();
				obj.checked=true;
			}
			if(t=='4'){
				wishselect4();
				obj.checked=true;
			}
		}
		function show_student_time(){ 
			window.setTimeout("show_student_time()", 1000); 
			BirthDay=new Date("2017/12/24");//改成你的计时日期 
			today=new Date(); 
			timeold=(BirthDay.getTime()-today.getTime()); 
			sectimeold=timeold/1000 
			secondsold=Math.floor(sectimeold); 
			msPerDay=24*60*60*1000 
			e_daysold=timeold/msPerDay 
			daysold=Math.floor(e_daysold); 
			e_hrsold=(e_daysold-daysold)*24; 
			hrsold=Math.floor(e_hrsold); 
			e_minsold=(e_hrsold-hrsold)*60; 
			minsold=Math.floor((e_hrsold-hrsold)*60); 
			seconds=Math.floor((e_minsold-minsold)*60); 
			if(daysold <= 7){
				span_dt_dt.innerHTML="<font color=red>今离2017年“青人节”还有"+daysold+"天"+hrsold+"小时"+minsold+"分"+seconds+"秒</font>" ;
			}else{
				span_dt_dt.innerHTML="今离2017年“情人节”还有"+daysold+"天"+hrsold+"小时"+minsold+"分"+seconds+"秒" ;
			}
		} 
		show_student_time(); 	
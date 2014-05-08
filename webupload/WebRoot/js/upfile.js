function checkvalue(obj){
	var val = $(obj).val();
	if(val==""){
		$(obj).next().html("不能为空");
	}else{
			$(obj).next().html("");
	}
}

function checkissubmit(obj){
	var tmep=0;
	var str = $("#form1").serialize();
	var onearr=str.split("&");
	
	for(var i = 0;i<onearr.length;i++){
		var twoarr = onearr[i].split("=");
	
		for(var j=0;j<twoarr.length;j++){
			if(twoarr[j]==''){
				$(obj).prev().html("文本框不能为空");
				tmep++;
				break;
			}
		}
	}
	if(tmep==0){
		if(confirm("你确定要提交吗")){
		form1.submit();
		alert("提交成功");
		}
	}
	
	
}

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>上传文件</title>
		<meta http-equiv="Content-Type" content="charset=utf-8" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/upfile.css" media="all" />
	</head>
	<body >
		<div class="main">
			<div id="apDiv1">
				<form action="file_addUploadfile" method="post" name="form1" id="form1"
					class="form-horizontal" enctype="multipart/form-data">
					<font size="3px" color="blue">请选择文件：</font>
					<div class="input">
						<input type="text" id="tx" />
						<input size="30" type="file" name="myFile"
							onchange="tx.value=this.value"
							style="width: 290px; margin-left: -300px; filter: alpha(opacity =   0); opacity: 0;" />
					</div>

					<font size="3px" color="blue">版本号：</font>
					<div class="input">
						<input type="text" name="uf.versionNum" onblur="checkvalue(this)"/>
						<span></span>
					</div>
					<font size="3px" color="blue">作者：</font>
					<div class="input">
						<input type="text" name="uf.author" onblur="checkvalue(this)"/>
						<span></span>
					</div>
					<font size="3px" color="blue">文件类型：</font>
					

					<div class="input">
						<select name="uf.filetype" id="">
							<option value="sql">
								脚本
							</option>
							<option value="war">
								软件包
							</option>
						</select>
					</div>
					<div class="input">
						<div class="dailspan"> <font>2</font> </div>
						
						<input class="sub" type="button" onclick ="checkissubmit(this)" value="提交" />
					</div>
				</form>
			</div>
		</div>
	<script src="${pageContext.request.contextPath }/js/upfile.js"  language="javascript" charset="UTF-8" type="text/javascript"></script> 
	<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.min.js"   language="javascript" charset="UTF-8" type="text/javascript"></script> 

	
	</body>

</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<%@ include file="/common/common.jspf"%>
<title>My JSP</title>
</head>
<body>

	<form id="ff" method="post">
		<div>
			<label for="supId">供应商编号:</label> <input type="text" name="supId" />
		</div>
		<div>
			<label for="supName">供应商:</label> <input type="text" name="supName" />
		</div>
		<div>
			<label for="supLinkman">联系人:</label> <input type="text"
				name="supLinkman" />
		</div>
		<div>
			<label for="supPhone">联系电话:</label> <input type="text"
				name="supPhone" />
		</div>

		<div>
			<label for="supType">供应商类型：</label> 
			<select id="cc" class="easyui-combobox" name="supType" style="width:200px;">
				<c:forEach items="${applicationScope.sysParam.supType }" var="supType">
					<option value="${supType.key }">${supType.value }</option>
				</c:forEach>
			</select>
		</div>

		<div>
			<input id="btn" type="button" value="提交" />
		</div>
	</form>

	<script type="text/javascript">
		$(function() {
			var win = parent.$("iframe[title='供应商管理']").get(0).contentWindow; //返回ifram页面文档（window)
	
			$("[name='supName']").validatebox({
				required : true,
				missingMessage : '请填写供应商！'
			});
	
			//禁用验证
			$("#ff").form("disableValidation");
	
			$("#btn").click(function() {
				alert("点击了提交按钮！");
				$("#ff").form("enableValidation");
				if ($("#ff").form("validate")) {
					alert("validate!");
					$('#ff').form('submit', {
						url : '${proPath}/supplier/insert.action',
						onSubmit : function() {
							return true;
						},
						success : function(count) {
							//可以定义为对应消息框
							if (count > 0) {
								alert("成功");
							} else {
								alert("失败");
							}
	
							parent.$("#win").window("close");
							win.$("#dg").datagrid("reload");
						}
					});
	
				}
	
			});
	
		});
	</script>
</body>
</html>
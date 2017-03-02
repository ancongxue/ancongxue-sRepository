<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/common.jspf"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'supplier.jsp' starting page</title>
<script type="text/javascript">
	$(function() {

		$("#dg").datagrid({
			//从远程站点请求数据的url，一定是一个json格式的
			url : '${proPath}/supplier/selectPage.action',

			striped : true,
			fitColumns : true,
			idField : 'supId',
			rownumbers : true,
			loadMsg : "加载中，请稍等...",
			pagination : true,
			pageSize : 5,
			pageList : [ 2, 5, 10, 15 ],

			/* 	//注释掉，不然为null的将不会被搜索出来	
				//向远程站点请求数据时，额外发送的参数
					queryParams : {
						supName : '%%', //第一次请求时，还没有搜索，默认是空的
						supPhone : '%%'
					}, */

			toolbar : [ {
				iconCls : 'icon-add',
				text : '添加',
				handler : function() {
					parent.$('#win').window({    
					    width:600,    
					    height:400,    
					    modal:true,
					    content:"<iframe src='${proPath}/base/goURL/supplier/insert.action' height='100%' width='100%' frameborder='0px' ></iframe>"  
					}); 					
				}
			}, '-', {
				iconCls : 'icon-edit',
				text : '编辑',
				handler : function() {
					alert('编辑按钮');
					var rows = $('#dg').datagrid("getSelections");
					if ( rows.length != 1){
					alert('只能一次编辑一行！');
					return false;
					}
					parent.$('#win').window({
					 width:600,    
					    height:400,    
					    modal:true,
					    content:"<iframe src='${proPath}/base/goURL/supplier/update.action' height='100%' width='100%' frameborder='0px' ></iframe>"  
					})
					
				}
			}, '-', {
				iconCls : 'icon-remove',
				text : '删除',
				handler : function() {
					//1.获取所有选中的记录
					var rows = $('#dg').datagrid("getSelections");
					alert(rows.length);
					//2.如果有选中的记录
					if (rows.length > 0) {
						//3.从选中的记录中获取supId的值
						var ids = new Array();
						for (var i = 0; i < rows.length; i++) {
							alert(rows[i].supId);
							ids[i] = rows[i].supId;
						}

						//4.弹出窗口，问客户是否确定删除？
						parent.$.messager.confirm('确定', '你确定删除吗？',
							function(r) {
								if (r) {
									//5.确定，用ajax方式与后台交换数据
									$.ajax({
										//6.从后台api传来数据
										url : "${proPath}/supplier/deleteByPK.action",
										type : "POST",
										traditional : true,
										//7.向后台发送pks
										data : {
											pks : ids
										},
										dataType : 'json',
										success : function() {
											//8.成功，清空选项
											$('#dg').datagrid('clearSelections');
											//9.重新加载列表
											$('#dg').datagrid('reload');
										},
										error : function(XMLHttpRequest, textStatus, errorThrown) {
											$.messager.alert('删除错误', '请联系管理员！', 'error');
										},
									})
								}
							});


					} else {
						//如果什么都没选就提交了
						$.messager.show({
							title : '操作提示',
							msg : '请先选择要删除的记录。',
							timeout : 4000,
							showType : 'slide'
						});


					}


				}
			}, '-', {
				text : "<input type='text' id='supName' name='supName'/>" //定义两个搜索框
			}, '-', {
				text : "<input type='text' id='supPhone' name='supPhone'/>"
			} ],

			//定义列表
			columns : [ [
				{
					checkbox : true
				},
				{
					field : 'supId', //对应取json中哪个字段
					title : '编号', //展示的名字
					width : 100
				},
				{
					field : 'supName',
					title : '供应商名称',
					width : 100
				},
				{
					field : 'supPhone',
					title : '电话',
					width : 100
				},
			] ]
		});

		$('#supName').searchbox({
			searcher : function(value, name) {
				$('#dg').datagrid('load', {
					supName : '%' + value + '%'
				});
			},
			prompt : '请输入供应商名称'
		});

		//定义一个搜索框
		$('#supPhone').searchbox({
			//用户按下搜索键时，searcher函数被调用：value是用户输入的搜索关键字
			searcher : function(value, name) {
				//从服务器加载新数据
				$('#dg').datagrid('load', {
					supPhone : '%' + value + '%' //向服务器发送数据，这里的params将替换queryParams的属性
				});
			},
			prompt : '请输入供应商电话' //显示在输入框里的提示信息
		});

	});
</script>

</head>

<body>

	<table id="dg"></table>
</body>
</html>

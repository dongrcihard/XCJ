	Ext.onReady(function(){
		var loginForm = Ext.create('Ext.form.Panel',{
			title:'用户登录窗口',
			width : 230,
            frame : true,
            renderTo: Ext.get("loginWin"),
            defaultType: 'textfield',//设置表单字段的默认类型
            fieldDefaults:{//统一设置表单字段默认属性
				labelSeparator :'：',//分隔符
				labelWidth : 50,//标签宽度
				msgTarget : 'side',
				width : 200
			},
			items:[{
				fieldLabel:'用户名',
				name : 'userName',
				allowBlank : false,
				vtype:'email'
			},{
				fieldLabel:'密码',
				name : 'password',
				inputType : 'password',
				allowBlank : false
			}],
			buttons:[{
				text : '登陆',
                handler:function(){
                    loginForm.form.doAction('submit',{
                        url:'user.action',
                        method:'post',
                        success:function(form,action){
                            document.location="index.jsp";
                            Ext.Msg.alert("添加成功！",action.result.message);
                        },
                        failure:function(form,action){
                            Ext.Msg.alert("添加失败！",action.result.message);
                        }
                    });
                }

    },{
				text : '重置',
				handler : reset
			}]
		});
		//设定Panel居中显示
		function login(){//提交表单
			loginForm.form.doAction({
//				clientValidation:true,//进行客户端验证
				url : 'login.action',//请求的url地址
				method:'POST',//请求方式
				success:function(form,action){//加载成功的处理函数
					Ext.Msg.alert('提示','系统登陆成功');
				},
				failure:function(form,action){//加载失败的处理函数
					Ext.Msg.alert('提示','系统登陆失败，原因：'+action.failureType);
				}
			});
		}
		function reset(){//重置表单
			loginForm.form.reset();
		}
	});
/**
 * Created by dongxl on 14-4-12.
 */

Ext.onReady(function(){
    var loginForm = Ext.create('Ext.form.Panel',{
        title:'表单提交示例',
        width : 230,
        frame : true,
        fieldDefaults:{//统一设置表单字段默认属性
            labelSeparator :'：',//分隔符
            labelWidth : 50,//标签宽度
            msgTarget : 'side',
            width : 200
        },
        renderTo: Ext.getBody(),
        bodyPadding: 5,
        defaultType: 'textfield',//设置表单字段的默认类型
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
            handler : login
        },{
            text : '重置',
            handler : reset
        }]
    });
    loginForm.setX(400);
    //设定Panel居中显示
    //loginForm.center();
    function login(){//提交表单
        loginForm.getForm().submit({
            clientValidation:true,//进行客户端验证
            url : 'index.jsp',//请求的url地址
            method:'GET',//请求方式
            success:function(form,action){//加载成功的处理函数
                Ext.Msg.alert('提示','系统登陆成功');
            },
            failure:function(form,action){//加载失败的处理函数
                Ext.Msg.alert('提示','系统登陆失败，故障原因：'+action.failureType);
            }
        });
    }
    function reset(){//重置表单
        loginForm.form.reset();
    }
});
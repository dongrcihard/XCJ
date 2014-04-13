Ext.onReady(function () {

    Ext.form.Field.prototype.msgTarget = "side";
    /*创建窗口*/
    var form1 = Ext.create('Ext.form.Panel', {
        title: '用户登录窗口',
        width: 263,
        height: 140,
        frame: true,
//        labelWidth: 60,
        minButtonWidth: 60,
        buttonAlign: "center",
        renderTo: Ext.get("loginWin"),
//        defaults: {width: 180},
        items: [
            {
                xtype: 'textfield',
                fieldLabel: "用户名",
                id: "txtName",
                name: 'user.username',
                allowBlank: false,
                blankText: "用户名不能为空!"
            },
            {
                xtype: 'textfield',
                fieldLabel: "密码",
                allowBlank: false,
                blankText: "密码不能为空!",
                name: 'user.password',
                inputType: 'password'
            }
        ],
        buttons: [
            {
                text: "登录",
                type: 'submit',
                handler: function () {
                    if (form1.getForm().isValid()) {
                        Ext.MessageBox.show({
                            title: '请等待',
                            msg: '正在加载',
                            progressText: '',
                            width: 150,
                            progress: true,
                            closable: 'false',
                            animEl: 'loding'
                        });
                        var f = function (v) {
                            return function () {
                                var i = v / 11;
                                Ext.MessageBox.updateProgress(i, '');
                            }
                        };
                        for (var i = 1; i < 33; i++) {
                            setTimeout(f(i), i * 1500);
                        }
                        //提交到服务器操作
                        form1.form.doAction('submit', {
                            url: 'login.action',
                            method: 'post',
                            success: function (form, action) {
                                document.location = "index.jsp";
                                Ext.Msg.alert("登录成功！", action.result.message);
                            },
                            failure: function (form, action) {
                                Ext.Msg.alert("登录失败！", action.result.message);
                            }
                        });
                    }
                }},
            {
                text: "重置",
                handler: function () {
                    form1.getForm().reset();
                }
            }
        ]
    });
});
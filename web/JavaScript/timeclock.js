/**
 * Created by dongxl on 14-4-2.
 */
Ext.onReady(function () {
    var msgBox = Ext.MessageBox.show({
        title: '提示',
        msg: '动态跟新的信息文字',
        modal: true,
        buttons: Ext.Msg.OK,
        fn: function () {
            //停止定时任务
            Ext.TaskManager.stop(task);
        }
    });
    //Ext.TaskManager是一个功能类，用来定时执行程序，
    //在这里我们使用它来定时触发提示信息的更新。
    var task = {
        run: function () {
            CallAdsFuncs.getPLCVar(function (data) {
                msgBox.updateText(Ext.util.Format.date(new Date(), 'Y-m-d g:i:s A')
                    + " " + "MAIN.PLCVar: " + data);
            })
        },
        interval: 1000
    }
//    var task = {
//        run:function(){
//            msgBox.updateText(Ext.util.Format.date(new Date(),'Y-m-d g:i:s A'));
//        },
//        interval:1000
//    };
    /*function plcCb(data){
     Ext.MessageBox.alert("hello");

     //msgBox.updateText(data + Ext.util.Format.date(new Date(),'Y-m-d g:i:s A'));
     }*/
    /*function getPlcVar(){
     CallAdsFuncs.getPLCVar(function(data){
     Ext.MessageBox.alert(data + Ext.util.Format.date(new Date(),'Y-m-d g:i:s A'));
     });
     }*/
    Ext.TaskManager.start(task);
});

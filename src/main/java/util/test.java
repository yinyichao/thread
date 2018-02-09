package util;

import java.io.UnsupportedEncodingException;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class test {
	//DPSDK_OCX.DPSDK_OCXCtrl.1
	public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {
		//System.out.println(System.getProperty("java.library.path"));
		ComThread.InitSTA();// 启动线程
        // 注册表中取得注册MyOcx.dll的ProgId，或clsid。
        ActiveXComponent com = new ActiveXComponent("DPSDK_OCX.DPSDK_OCXCtrl.1");//在MyOcx中搜索ProgID = s 'MyOcx.MyDialog.1'
        // Dispatch对象看成是对Activex控件的一个操作
        Dispatch disp = com.getObject();
       
        // 假设DPSDK_LoadDGroupInfo是MyOcx.dll中的一个方法
        Variant v1 = Dispatch.call(disp, "DPSDK_Login","10.25.0.22","9000","system","123456");
        System.out.println(v1.getInt());
        Dispatch.call(disp, "DPSDK_LoadDGroupInfo");
        Thread.sleep(5000);
        Variant v2 = Dispatch.call(disp, "DPSDK_GetDGroupStr");
        System.out.println(v2);
        System.out.println("123");
        ComThread.Release();// 结束进程
	}
}

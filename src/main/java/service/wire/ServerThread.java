package service.wire;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

import pojo.TestWire;
import service.perimeter.TestWireService;
/**
 * 服务器线程处理类
 * @author yins
 *
 */
public class ServerThread extends Thread {
	// 和本线程相关的Socket
	Socket socket = null;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	// 线程执行的操作，响应客户端的请求
	public void run() {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;
		String [] infos = null;
		TestWire testWire = new TestWire();
		
		try {
			// 获取输入流，并读取客户端信息
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String info = null;
			while ((info = br.readLine()) != null) {// 循环读取客户端的信息
				infos = info.split(",");
				insert(infos);
			}
			
			socket.shutdownInput();// 关闭输入流
			// 获取输出流，响应客户端的请求
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.write("欢迎您！");
			pw.flush();// 调用flush()方法将缓冲输出
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭资源
			try {
				if (pw != null)
					pw.close();
				if (os != null)
					os.close();
				if (br != null)
					br.close();
				if (isr != null)
					isr.close();
				if (is != null)
					is.close();
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	public void insert(String [] infos) throws IOException{
		TestWire testWire = new TestWire();
		TestWireService testWireService = new TestWireService();
		testWire.setIn_time(new Date());
		testWire.setId(infos[1]);
		testWire.setStatus(Integer.parseInt(infos[2]));
		testWire.setHighvalue1(Long.parseLong(infos[3]));
		testWire.setHighvalue2(Long.parseLong(infos[4]));
		testWire.setLowvalue1(Long.parseLong(infos[5]));
		testWire.setLowvalue2(Long.parseLong(infos[6]));
		testWireService.insert(testWire);
		
	}
}

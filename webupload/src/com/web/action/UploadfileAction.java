package com.web.action;


import com.web.service.IUploadfileService;
import com.web.util.FileUtil;
import com.web.vo.Uploadfile;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

public class UploadfileAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IUploadfileService iUploadfileService;
	private Uploadfile uf;
	// myFile����������װ�ϴ����ļ�
	private File myFile;
	// myFileContentType����������װ�ϴ��ļ�������
	private String myFileContentType;
	// myFileFileName����������װ�ϴ��ļ����ļ���
	private String myFileFileName;

	public String addUploadfile() {
		StringBuffer sb = new StringBuffer();
		sb.append(uf.getVersionNum());
		sb.append(".");
		sb.append(uf.getFiletype());
		 ServletContext sc = ServletActionContext.getServletContext();
			String realPath = sc.getRealPath("/upload");
			String newfilePath = realPath + File.separatorChar +sb.toString();
//		String newfilePath = "E:\\Workspace4\\webupload\\WebRoot\\upload\\"
//				+ sb.toString();
		File dest = new File(newfilePath);
		try {
			FileUtil.copy(myFile, dest);
		} catch (Exception e) {
			e.printStackTrace();
		}// �ļ�������uploadĿ¼��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat wsdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		Uploadfile uobj = new Uploadfile();
		uobj.setFiletype(uf.getFiletype());
		uobj.setUpTime(sdf.format(d));
		uobj.setAuthor(uf.getAuthor());
		uobj.setVersionNum(uf.getVersionNum());
		//�����ϴ���¼
		iUploadfileService.addUploadfile(uobj);
		// ���͸�ͷ���
		StringBuffer wsb = new StringBuffer();
		wsb.append(uf.getVersionNum());
		wsb.append(",");
		wsb.append(uf.getFiletype());
		wsb.append(",");
		wsb.append(wsdf.format(d));
		Socket s;
		try {
			s = new Socket(InetAddress.getByName("192.168.2.104"), 6000);
			OutputStream os = s.getOutputStream();
			os.write(wsb.toString().getBytes("utf-8"));
			Thread.sleep(100);
			os.close();
			s.close();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}// "localhost" "127.0.0.1s"

		return SUCCESS;

	}

	public String spkilogin() {

		return SUCCESS;

	}

	public Uploadfile getUf() {
		return uf;
	}

	public void setUf(Uploadfile uf) {
		this.uf = uf;
	}

	public IUploadfileService getiUploadfileService() {
		return iUploadfileService;
	}

	public void setiUploadfileService(IUploadfileService iUploadfileService) {
		this.iUploadfileService = iUploadfileService;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

}

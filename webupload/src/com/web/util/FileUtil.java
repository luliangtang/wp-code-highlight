package com.web.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileUtil {

	public static void copy(File src, File dest) throws Exception {
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(dest);
		byte[] bbs = new byte[1024];
		int len = -1;
		while ((len = fis.read(bbs)) != -1) {
			fos.write(bbs, 0, len);
		}
		fis.close();
		fos.flush();
		fos.close();
	}
}

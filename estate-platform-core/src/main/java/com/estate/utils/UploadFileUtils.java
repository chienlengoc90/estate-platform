package com.estate.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.estate.constant.SystemConstant;

public class UploadFileUtils {
	
	private static Logger LOGGER = LoggerFactory.getLogger(UploadFileUtils.class);
	
	public static void writeOrUpdate(String path, String base64) {
		checkAndCreateFolder(SystemConstant.BASE_DIR, path);
		FileOutputStream outputStream = null;
		try {
			String location = SystemConstant.BASE_DIR + File.separator + path;
			File file = new File(location);
			if (file.exists()) {
				file.delete();
			}
			outputStream = new FileOutputStream(location);
			byte[] decodedString = Base64.decodeBase64(base64.getBytes());
			outputStream.write(decodedString);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			try {
				if (outputStream != null)
					outputStream.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
	}
	
	private static void checkAndCreateFolder(String location, String path) {
		File fileLocation = new File(location);
		if (!fileLocation.exists()) {
			fileLocation.mkdir();
		}
		File file = new File(fileLocation + File.separator + path);
		if (!file.exists()) {
			file.mkdirs();
		}
	}
}

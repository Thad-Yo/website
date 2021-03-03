package com.website.admin.baidu.ueditor.upload;

import java.util.Map;
import org.apache.commons.codec.binary.Base64;

import com.website.admin.baidu.ueditor.define.AppInfo;
import com.website.admin.baidu.ueditor.define.BaseState;
import com.website.admin.baidu.ueditor.PathFormat;
import com.website.admin.baidu.ueditor.define.FileType;
import com.website.admin.baidu.ueditor.define.State;
import com.website.common.util.properties.PropertyUtil;

public final class Base64Uploader {
	
	private static String ueditorSavePath = PropertyUtil.getSystemResourcesPropertieValue("file.basepath");

	public static State save(String content, Map<String, Object> conf) {
		
		byte[] data = decode(content);

		long maxSize = ((Long) conf.get("maxSize")).longValue();

		if (!validSize(data, maxSize)) {
			return new BaseState(false, AppInfo.MAX_SIZE);
		}

		String suffix = FileType.getSuffix("JPG");

		String savePath = PathFormat.parse((String) conf.get("savePath"),
				(String) conf.get("filename"));
		
		savePath = savePath + suffix;
//		String physicalPath = (String) conf.get("rootPath") + savePath;
		String physicalPath = ueditorSavePath + savePath;

		State storageState = StorageManager.saveBinaryFile(data, physicalPath);

		if (storageState.isSuccess()) {
			storageState.putInfo("url", PathFormat.format(savePath));
			storageState.putInfo("type", suffix);
			storageState.putInfo("original", "");
		}

		return storageState;
	}

	private static byte[] decode(String content) {
		return Base64.decodeBase64(content);
	}

	private static boolean validSize(byte[] data, long length) {
		return data.length <= length;
	}
	
}
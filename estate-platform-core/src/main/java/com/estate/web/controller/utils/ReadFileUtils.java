package com.estate.web.controller.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.estate.constant.SystemConstant;

public class ReadFileUtils extends HttpServlet {
	
	private static final long serialVersionUID = 3633904564880655554L;
	
	private final String imagesBase = SystemConstant.BASE_DIR;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		String imageUrl = request.getRequestURI();
		int repIndex = imageUrl.indexOf("/repository/");
		String relativeImagePath = null;
        if(repIndex != -1) {
            repIndex += "/repository/".length();
            relativeImagePath = imageUrl.substring(repIndex);
        }
		ServletOutputStream outStream;
		outStream = response.getOutputStream();
		FileInputStream fin = new FileInputStream(imagesBase + File.separator + relativeImagePath);
		BufferedInputStream bin = new BufferedInputStream(fin);
		BufferedOutputStream bout = new BufferedOutputStream(outStream);
		int ch =0; ;
		while((ch=bin.read())!=-1)
			bout.write(ch);
		bin.close();
		fin.close();
		bout.close();
		outStream.close();
	}
}

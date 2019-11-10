package com.softtron.pinmaoserver.controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.softtron.pinmaoserver.annotations.Autowried;
import com.softtron.pinmaoserver.annotations.Controller;
import com.softtron.pinmaoserver.annotations.RequestMapping;
import com.softtron.pinmaoserver.annotations.Result;
import com.softtron.pinmaoserver.services.ImgService;
import com.softtron.pinmaoserver.utils.FileUtil;

@Controller(url = "/upload")
public class UploadController {
	@Autowried
	ImgService ImgService; 
	@RequestMapping(url = "/file.htm")
	@SuppressWarnings(value="unchecked")
	public Map uploadImg(@Result Map resultMap, HttpServletRequest request) throws IllegalStateException, IOException, ServletException, URISyntaxException {
		//上传
		resultMap.put("message", "操作成功");
		resultMap.put("ob", ImgService.insert(request));
		resultMap.put("state", "200");
		return resultMap;
	}
}

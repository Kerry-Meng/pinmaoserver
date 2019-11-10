package com.softtron.pinmaoserver.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.softtron.pinmaoserver.annotations.Autowried;
import com.softtron.pinmaoserver.annotations.Controller;
import com.softtron.pinmaoserver.annotations.NotNull;
import com.softtron.pinmaoserver.annotations.RequestBody;
import com.softtron.pinmaoserver.annotations.RequestMapping;
import com.softtron.pinmaoserver.annotations.Result;
import com.softtron.pinmaoserver.domains.TNews;
import com.softtron.pinmaoserver.services.NewsService;

@Controller(url = "/news")
public class NewsController {
	@Autowried
	NewsService newsService;
	@RequestMapping(url="/findall.htm")
	public Map findAll(@Result Map resultMap,@NotNull(message="页数不能为空",state="500")String page,@NotNull(message="每页显示数不能为空",state="500")String count) {
		Map map2 = new HashMap();
		resultMap.put("message", "操作成功");
		map2.put("news", newsService.findAll(page, count));
		map2.put("total", newsService.getTotal());
		resultMap.put("ob", map2);
		resultMap.put("state", "200");
		return resultMap;
	}
	@RequestMapping(url="/delete.htm")
	public Map deleteNews(@Result Map resultMap,@NotNull(message="新闻Id不能为空",state="500")String newsId) {
		resultMap.put("message", "操作成功");		
		resultMap.put("ob", newsService.delete(Integer.parseInt(newsId)));
		resultMap.put("state", "200");
		return resultMap;
	}
	@RequestMapping(url="/insert.htm")
	public Map insertNews(@Result Map resultMap,@RequestBody TNews news) {
		resultMap.put("message", "操作成功");
		if(news.getNewsId()!=-1)//更新
		resultMap.put("ob", newsService.update(news));
		else {
		news.setDateCreated(new Date());
		news.setNewsId(newsService.insert(news));
		resultMap.put("ob", news);
		}
		resultMap.put("state", "200");
		return resultMap;
	}
}

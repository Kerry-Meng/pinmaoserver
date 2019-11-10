package com.softtron.pinmaoserver.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.softtron.pinmaoserver.annotations.Autowried;
import com.softtron.pinmaoserver.annotations.Service;
import com.softtron.pinmaoserver.daos.NewsDao;
import com.softtron.pinmaoserver.domains.TNews;

@Service
public class NewsService {
	@Autowried
	NewsDao newsDao;

	public Set<TNews> findAll(String page, String count) {
		Map map = new HashMap<>();
		map.put("start", (Integer.parseInt(page) - 1) * Integer.parseInt(count));
		map.put("count", Integer.parseInt(count));
		return newsDao.findAll(map);
	}

	public Integer getTotal() {
		return newsDao.getTotal();
	}

	public Integer update(TNews news) {
		return newsDao.update(news);
	}

	public Integer delete(int newsId) {
		return newsDao.delete(newsId);
	}

	public Integer insert(TNews news) {
		return newsDao.insert(news);
	}
}

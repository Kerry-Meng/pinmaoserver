package com.softtron.pinmaoserver.daos;

import java.util.Map;
import java.util.Set;

import com.softtron.pinmaoserver.domains.TNews;

public interface NewsDao {
	public Set<TNews> findAll(Map map);
	public Integer getTotal();
	public Integer update(TNews news);
	public Integer delete(int newsId);
	public Integer insert(TNews news);
}

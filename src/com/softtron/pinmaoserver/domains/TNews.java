package com.softtron.pinmaoserver.domains;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.softtron.pinmaoserver.annotations.Column;

public class TNews {
	@Column(name = "newsid")
	private int newsId;
	@Column(name = "newsTitle")
	private String newsTitle;
	@Column(name = "newsContent")
	private String newsContent;
	@Column(name = "createdDate")
	private Date dateCreated;

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public String getDateCreated() {
		String str  =null;
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 if(this.dateCreated!=null)
		 str= sdf.format(this.dateCreated);
		return str;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

}

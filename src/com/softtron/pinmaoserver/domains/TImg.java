package com.softtron.pinmaoserver.domains;

import com.softtron.pinmaoserver.annotations.Column;

public class TImg {
	@Column(name="imgid")
	private int imgId;
	@Column(name="imgpath")
	private String imgPath;

	public int getImgId() {
		return imgId;
	}

	public void setImgId(int imgId) {
		this.imgId = imgId;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

}

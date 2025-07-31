package com.threeteam.sns.util;

import java.util.HashMap;

public class Page {
	private int page = 1;         // 현재 페이지
	private int rows = 30;        // 페이지 당 항목 수
	private int total = 0;        // 전체 항목 수
	private int totalPage = 0;    // 전체 페이지 수
	private int beginIndex = 0;   // 시작 인덱스
	private int endIndex = 0;     // 끝 인덱스

	public Page() {}

	public Page(int total, HashMap<String, Object> params) {
		this.total = total;

		if (params.get("pageNo") != null) {
			this.page = Integer.parseInt(params.get("pageNo").toString());
		}
		if (params.get("pageSize") != null) {
			this.rows = Integer.parseInt(params.get("pageSize").toString());
		}

		this.totalPage = (int) Math.ceil((double) total / rows);
		this.beginIndex = (page - 1) * rows;
		this.endIndex = Math.min(beginIndex + rows, total);
	}

	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("page", page);
		map.put("rows", rows);
		map.put("total", total);
		map.put("totalPage", totalPage);
		map.put("beginIndex", beginIndex);
		map.put("endIndex", endIndex);

		// 페이징 네비게이션 정보
		int pageGroupSize = 10;
		int beginPage = ((page - 1) / pageGroupSize) * pageGroupSize + 1;
		int endPage = Math.min(beginPage + pageGroupSize - 1, totalPage);

		map.put("beginPage", beginPage);
		map.put("endPage", endPage);
		map.put("existFirstPage", page > 1);
		map.put("existLastPage", page < totalPage);
		map.put("existPrevPage", beginPage > 1);
		map.put("existNextPage", endPage < totalPage);
		map.put("firstPage", 1);
		map.put("lastPage", totalPage);

		return map;
	}

	public int getBeginIndex() {
		return beginIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}
}


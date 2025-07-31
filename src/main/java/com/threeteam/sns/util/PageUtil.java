package com.threeteam.sns.util;

import java.util.*;
import jakarta.servlet.http.HttpServletRequest;

public class PageUtil {

    /**
     * HttpServletRequest로부터 모든 파라미터를 받아와 Map 형태로 반환
     */
    public HashMap<String, Object> getReqParams(HttpServletRequest req) {
        HashMap<String, Object> map = new HashMap<>();

        Enumeration<String> enums = req.getParameterNames();
        while (enums.hasMoreElements()) {
            String key = enums.nextElement();
            String val = req.getParameter(key);
            if (val != null && !val.trim().equals("")) {
                map.put(key, val.trim());
            }
        }

        // 기본값 세팅 (pageNo=1, pageSize=30)
        if (!map.containsKey("pageNo")) {
            map.put("pageNo", "1");
        }
        if (!map.containsKey("pageSize")) {
            map.put("pageSize", "30");
        }

        return map;
    }

    /**
     * 페이징된 리스트 반환
     */
    public List<HashMap<String, Object>> setPagingList(List<HashMap<String, Object>> list, Page page, String sortKey) {
        List<HashMap<String, Object>> pagedList = new ArrayList<>();
        int start = page.getBeginIndex();
        int end = page.getEndIndex();

        if (start >= list.size()) return pagedList;
        if (end > list.size()) end = list.size();

        for (int i = start; i < end; i++) {
            pagedList.add(list.get(i));
        }

        return pagedList;
    }
}


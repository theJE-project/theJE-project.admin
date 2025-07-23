package com.example.gogguchips.api.categories;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface categories {
    List<categoriesData> parent();
    // parent IS NULL 인 상위 카테고리
    // parent IS NULL 인 상위 카테고리
    List<categoriesData> children(Long id); // 특정 parent ID에 해당하는 자식 카테고리들
}
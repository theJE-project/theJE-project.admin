package com.example.gogguchips.api.categroies;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface categroies {
    List<categroiesData> parent();          // parent IS NULL 인 상위 카테고리
    List<categroiesData> children(Long id); // 특정 parent ID에 해당하는 자식 카테고리들
}
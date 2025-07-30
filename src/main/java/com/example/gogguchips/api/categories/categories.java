package com.example.gogguchips.api.categories;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface categories {
    List<categoriesData> allSelect();
}
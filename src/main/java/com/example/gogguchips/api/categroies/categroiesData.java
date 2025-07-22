package com.example.gogguchips.api.categroies;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class categroiesData {
    private Long id;
    private Long parent;
    private String name;
    private String url;
    private String BOARD_TYPE;
    private String CREATED_AT;
    private List<categroiesData> children;
}
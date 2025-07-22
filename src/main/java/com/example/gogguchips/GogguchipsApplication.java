package com.example.gogguchips;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;


import com.example.gogguchips.api.categroies.*;

@SpringBootApplication
@MapperScan({
		"com.example.gogguchips.mapper",
		"com.example.gogguchips.api.categroies"
})

public class GogguchipsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GogguchipsApplication.class, args);
	}

	// 뷰 반환 컨트롤러
	@Controller
	static class PageController {

		@GetMapping("/")
		public String main(Model model) {
			return "admin/main"; // templates/admin/main.html
		}
	}

	@RestController
	static class ApiController {
		private final categroies categroiesMapper;

		@Autowired
		public ApiController(categroies categoryMapper) {
			this.categroiesMapper = categoryMapper;
		}

		@GetMapping("/api/categories")
		public List<categroiesData> getCategories() {
			List<categroiesData> parents = categroiesMapper.parent();
			for (categroiesData parent : parents) {
				List<categroiesData> children = categroiesMapper.children(parent.getId());
				parent.setChildren(children);
			}
			return parents;
		}
	}
}

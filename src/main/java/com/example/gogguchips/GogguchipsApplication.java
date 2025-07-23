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


import com.example.gogguchips.api.categories.*;

@SpringBootApplication
@MapperScan({
		"com.example.gogguchips.mapper",
		"com.example.gogguchips.api.categories"
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
		private final categories categoriesMapper;

		@Autowired
		public ApiController(categories categoryMapper) {
			this.categoriesMapper = categoryMapper;
		}

		@GetMapping("/api/categories")
		public List<categoriesData> getCategories() {
			List<categoriesData> parents = categoriesMapper.parent();
			for (categoriesData parent : parents) {
				List<categoriesData> children = categoriesMapper.children(parent.getId());
				parent.setChildren(children);
			}
			return parents;
		}
	}
}

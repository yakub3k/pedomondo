package pl.yakub.book.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.yakub.book.data.Category;
import pl.yakub.book.repository.CategoryRepository;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {

    @Inject
    private CategoryRepository categoryRepository;

    @GetMapping("all")
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

}

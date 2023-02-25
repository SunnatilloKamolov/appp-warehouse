package uz.pdp.apppwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apppwarehouse.entity.Category;
import uz.pdp.apppwarehouse.payload.CategoryDto;
import uz.pdp.apppwarehouse.payload.Result;
import uz.pdp.apppwarehouse.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PostMapping
    public Result addCategory(@RequestBody CategoryDto categoryDto){
        Result result = categoryService.addCategory(categoryDto);
        return result;
    }@GetMapping
    public List<Category>getCategories(){
       return categoryService.getCategories();
    }
    @DeleteMapping
    public Result deleteCategory(@PathVariable Integer id){
        Result result = categoryService.deleteCategory(id);
        return result;
    }@PutMapping
    public Result editCategory(@PathVariable Integer id,@RequestBody CategoryDto categoryDto){
        Result result = categoryService.editCategory(categoryDto, id);
        return result;
    }
}

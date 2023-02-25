package uz.pdp.apppwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.apppwarehouse.entity.Category;
import uz.pdp.apppwarehouse.payload.CategoryDto;
import uz.pdp.apppwarehouse.payload.Result;
import uz.pdp.apppwarehouse.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public Result addCategory(CategoryDto categoryDto){
     Category category=new Category();
     category.setName(categoryDto.getName());
     if (categoryDto.getParentCategoryId()!=null){
         Optional<Category> optionalParentCategory = categoryRepository.findById(categoryDto.getParentCategoryId());
         if (!optionalParentCategory.isPresent())
             return new Result("Bunday ota kategoriya mavjud emas",false);
         category.setParentCategory(optionalParentCategory.get());
    }categoryRepository.save(category);
     return new Result("Muvaffaqiyatli saqlandi",true);
    }
    public Result editCategory(CategoryDto categoryDto,Integer id){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()){
            Category category1 = optionalCategory.get();
            category1.setName(categoryDto.getName());
            categoryRepository.save(category1);
            return new Result("Category edited",true);
        }return new Result("Category not found",false);
    }
    public Result deleteCategory(Integer id){
        categoryRepository.deleteById(id);
        return new Result("Category deleted",true);
    }
    public List<Category>getCategories(){
        List<Category>categoryList=categoryRepository.findAll();
        return categoryList;
    }
}

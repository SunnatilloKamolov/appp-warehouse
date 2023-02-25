package uz.pdp.apppwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.apppwarehouse.entity.Attachment;
import uz.pdp.apppwarehouse.entity.Category;
import uz.pdp.apppwarehouse.entity.Measurement;
import uz.pdp.apppwarehouse.entity.Product;
import uz.pdp.apppwarehouse.payload.ProductDto;
import uz.pdp.apppwarehouse.payload.Result;
import uz.pdp.apppwarehouse.repository.AttachmentRepository;
import uz.pdp.apppwarehouse.repository.CategoryRepository;
import uz.pdp.apppwarehouse.repository.MeasurementRepository;
import uz.pdp.apppwarehouse.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    MeasurementRepository measurementRepository;
    public Result addProduct(ProductDto productDto){
        boolean existsByNameAndCategoryId = productRepository.existsByNameAndCategoryId(productDto.getName(), productDto.getCategoryId());
        if (existsByNameAndCategoryId)
            return new Result("Bunday mahsulot ushbu kategoriyada mavjud",false);

        //CATEGORIYANI TEKSHIRISH
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent())
            return new Result("Bunday kategoriya mavjud emas",false);

        //PHOTO TEKSHIRISH
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
        Product product=new Product();
        if (!optionalAttachment.isPresent())
            return new Result("Bunday rasm mavjud emas",false);

        //MEASUREMENTNI TEKSHIRISH
        Optional<Measurement>optionalMeasurement = measurementRepository.findById(productDto.getMeasurementId());
        if (!optionalMeasurement.isPresent())
            return new Result("Bunday o'lchov birligi mavjud emas",false);

        //SAQLASH
        product.setName(productDto.getName());
        product.setCode("1");
        product.setCategory(optionalCategory.get());
        product.setPhoto(optionalAttachment.get());
        product.setMeasurement(optionalMeasurement.get());
        productRepository.save(product);
        return new Result("Mahsulot saqlandi",true);
    } public Result editProduct(ProductDto productDto,Integer id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()){
        boolean existsByNameAndCategoryId = productRepository.existsByNameAndCategoryId(productDto.getName(), productDto.getCategoryId());
        if (existsByNameAndCategoryId)
            return new Result("Bunday mahsulot ushbu kategoriyada mavjud",false);

        //CATEGORIYANI TEKSHIRISH
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent())
            return new Result("Bunday kategoriya mavjud emas",false);

        //PHOTO TEKSHIRISH
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
        Product product=new Product();
        if (!optionalAttachment.isPresent())
            return new Result("Bunday rasm mavjud emas",false);

        //MEASUREMENTNI TEKSHIRISH
        Optional<Measurement>optionalMeasurement = measurementRepository.findById(productDto.getMeasurementId());
        if (!optionalMeasurement.isPresent())
            return new Result("Bunday o'lchov birligi mavjud emas",false);

        //SAQLASH
        product.setName(productDto.getName());
        product.setCode("1");
        product.setCategory(optionalCategory.get());
        product.setPhoto(optionalAttachment.get());
        product.setMeasurement(optionalMeasurement.get());
        productRepository.save(product);
        return new Result("Mahsulot saqlandi",true);
    }return new Result("Not found",false);
    }
    public Result deleteProduct(Integer id){
        productRepository.deleteById(id);
        return new Result("deleted",true);
    }public List<Product>getProducts(){
        List<Product>productList=productRepository.findAll();
        return productList;
    }
}

package uz.pdp.apppwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apppwarehouse.entity.Output;
import uz.pdp.apppwarehouse.entity.Product;
import uz.pdp.apppwarehouse.payload.OutputDto;
import uz.pdp.apppwarehouse.payload.ProductDto;
import uz.pdp.apppwarehouse.payload.Result;
import uz.pdp.apppwarehouse.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
  @PostMapping
    public Result addProduct(@RequestBody ProductDto productDto){
      Result result = productService.addProduct(productDto);
      return result;
  }@PutMapping
    public Result editProduct(@RequestBody ProductDto productDto, @PathVariable Integer id){
        Result result = productService.editProduct(productDto, id);
        return result;
    }@DeleteMapping
    public Result deleteProduct(@PathVariable Integer id){
        Result result = productService.deleteProduct(id);
        return result;
    }
    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }
}

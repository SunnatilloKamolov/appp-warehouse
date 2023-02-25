package uz.pdp.apppwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apppwarehouse.entity.Product;
import uz.pdp.apppwarehouse.entity.User;
import uz.pdp.apppwarehouse.payload.ProductDto;
import uz.pdp.apppwarehouse.payload.Result;
import uz.pdp.apppwarehouse.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping
    public Result addUser(@RequestBody User user){
        Result result = userService.addUser(user);
        return result;
    }@PutMapping
    public Result editUser(@RequestBody User user, @PathVariable Integer id){
        Result result = userService.editUser(user, id);
        return result;
    }@DeleteMapping
    public Result deleteUser(@PathVariable Integer id){
        Result result = userService.deleteUser(id);
        return result;
    }
    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }
}

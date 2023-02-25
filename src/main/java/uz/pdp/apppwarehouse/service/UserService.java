package uz.pdp.apppwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.apppwarehouse.entity.User;
import uz.pdp.apppwarehouse.payload.Result;
import uz.pdp.apppwarehouse.repository.UserRepository;

import javax.sound.midi.Track;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public Result addUser(User user){
        boolean exists = userRepository.existsByPhoneNumber(user.getPhoneNumber());
        if (exists)
            return new Result("Bunday user mavjud",false);
        userRepository.save(user);
        return new Result("Muvaffaqiyatli qo'shildi",true);
    }
    public Result editUser(User user,Integer id){
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            User user1 = optionalUser.get();
            user1.setFirstName(user.getFirstName());
            user1.setLastName(user.getLastName());
            user1.setPhoneNumber(user.getPhoneNumber());
            user1.setPassword(user.getPassword());
            user1.setCode(user.getCode());
            user1.setWarehouses(user.getWarehouses());
            userRepository.save(user1);
            return new Result("Edited",true);
        }return new Result("Not found",false);
    }public Result deleteUser(Integer id){
        userRepository.deleteById(id);
        return new Result("Deleted", true);
    }public List<User>getUsers(){
        List<User>userList=userRepository.findAll();
        return userList;
    }
}

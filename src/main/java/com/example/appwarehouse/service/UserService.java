package com.example.appwarehouse.service;

import com.example.appwarehouse.entity.User;
import com.example.appwarehouse.entity.Warehouse;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.payload.UserDto;
import com.example.appwarehouse.repository.UserRepository;
import com.example.appwarehouse.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    WarehouseRepository warehouseRepository;

    public Result addUser(UserDto userDto){

        Optional <Warehouse> optionalWarehouse = warehouseRepository.findById(userDto.getWarehouseId());
        if (optionalWarehouse.isPresent()) {
            User user = new User();
            // warehouse qo`shish
            Warehouse warehouse = optionalWarehouse.get();
            Set<Warehouse> warehouses = new HashSet<>();
            warehouses.add(warehouse);
            user.setWarehouses(warehouses);

            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setPhoneNumber(userDto.getPhoneNumber());
            user.setCode(userDto.getCode());
            user.setPassword(userDto.getPassword());
            userRepository.save(user);
            return new Result("User saqlandi", true, user.getId());
        }
        return new Result("Bunday Id li Ombor mavjud emas",false);

    }

    public List<User> getUser() {
         return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        Optional<User> byId = userRepository.findById(id);
        return byId.orElse(null);
    }

    public Result editUserById(Integer id, UserDto userDto) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty())
            return new Result("Bunday Id li user yo`q",false);

        User user1 = optionalUser.get();
        user1.setFirstName(userDto.getFirstName());
        user1.setLastName(userDto.getLastName());
        user1.setPhoneNumber(userDto.getPhoneNumber());
        user1.setCode(userDto.getCode());
        user1.setPassword(userDto.getPassword());
        userRepository.save(user1);
        return new Result("User muvaffaqiyatli saqlandi",true,user1.getId());

    }
}

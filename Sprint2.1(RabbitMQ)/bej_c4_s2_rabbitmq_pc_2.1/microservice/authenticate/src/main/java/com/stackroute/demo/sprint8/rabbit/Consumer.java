package com.stackroute.demo.sprint8.rabbit;

import com.stackroute.demo.sprint8.domain.UserDTO;
import com.stackroute.demo.sprint8.domain.UserModal;
import com.stackroute.demo.sprint8.service.UserService;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    private UserService userService;
    @RabbitListener(queues = "user_queue")
    public void getDTOfromQueueAndAddtoDB(UserDTO userDTO){
        UserModal userModal=new UserModal();
        userModal.setEmail(userDTO.getEmail());
        userModal.setPassword(userDTO.getPassword());
        userModal.setRole("Role_User");
        UserModal result=userService.addUser(userModal);
        System.out.println("/nAdd user" +result);
    }

}

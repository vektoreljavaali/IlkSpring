package com.vektorel.IlkSpring.controller;

import com.vektorel.IlkSpring.repository.entity.User;
import com.vektorel.IlkSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class RegisterController {

    @Autowired
    UserService userService;
    // NOT: URL adı ayın olan methodlar ve yönlendirmeler kullanamıazsınız.
    // Ancak; talep tipi (POST,GET,PUT,DELTE) olan yapılarda aynı url adı kullanılabilir.
    @GetMapping("/register")
    public ModelAndView loginPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("register");
        return model;
    }

    // Bu method a post olarak gelecek değerin "name" alanı birebir
    // method ta talep ettiğimiz değişken adları ile aynı olmalıdır.
    // http://localhost/register
    @PostMapping("/register")
    public String registerPage(String username,String password,
                               int user_question, String user_answer){
        userService.save(
                User.builder().username(username)
                        .password(password)
                        .questions(user_question)
                        .answer(user_answer).build()
        );
        return "redirect:/login";
    }
}

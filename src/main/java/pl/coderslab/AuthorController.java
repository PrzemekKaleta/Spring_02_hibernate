package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

import javax.validation.Valid;
import javax.validation.Validator;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final Validator validator;

    @Autowired
    public AuthorController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/form")
    public String form(Model moel){
        moel.addAttribute("author", new Author());
        return "/form/author";
    }
    @PostMapping("/form")
    public String save(Model model, @ModelAttribute @Valid Author author, BindingResult result){

        model.asMap().forEach((k, v) -> System.out.println(k + ": " + v));

        if(result.hasErrors()){
            return "/form/author";
        }
       return "/form/author";
    }


}

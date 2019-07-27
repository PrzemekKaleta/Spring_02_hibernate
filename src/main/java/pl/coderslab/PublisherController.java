package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Publisher;

import javax.validation.Validator;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    private final Validator validator;

    @Autowired
    public PublisherController(Validator validator) {
         this.validator = validator;
    }

    @GetMapping("form")
    public String form(Model model){
        model.addAttribute("publisher", new Publisher());
        return "/form/publisher";
    }
}

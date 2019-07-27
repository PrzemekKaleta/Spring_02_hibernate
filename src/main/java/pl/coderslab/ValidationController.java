package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class ValidationController {

    public final Validator validator;

    @Autowired
    public ValidationController(Validator validator) {
        this.validator = validator;
    }
    @RequestMapping("/validate")
    public String validateTest(Model model) {
        Book p2 = new Book();
        List<String> info = new ArrayList<>();
        p2.setPages(1);
        p2.setRating(12);
        Set<ConstraintViolation<Book>> violations = validator.validate(p2);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Book> constraintViolation : violations) {
                System.out.println(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage());
                info.add(constraintViolation.getPropertyPath() + " : "
                        + constraintViolation.getMessage());
            }
            model.addAttribute("info", info);
        } else {

            return "validateResult"; }
        return "/validation";
    }


}

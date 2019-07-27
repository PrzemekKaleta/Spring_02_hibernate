package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.repository.BookRepository;
import pl.coderslab.dao.PublisherDAO;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.Collection;
import java.util.Set;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;
    private final PublisherDAO publisherDAO;
    private final Validator validator;

    @Autowired
    public BookController(BookRepository bookRepository, PublisherDAO publisherDAO, Validator validator) {
        this.bookRepository = bookRepository;
        this.publisherDAO = publisherDAO;
        this.validator = validator;
        Publisher publisher1 = new Publisher();
        Publisher publisher2 = new Publisher();
        publisher1.setName("ZZZ");
        publisher2.setName("XXX");
        publisherDAO.save(publisher1);
        publisherDAO.save(publisher2);
        bookRepository.resetRating(4);
    }

    @GetMapping("/form")
    public String form(Model moel){
        moel.addAttribute("book", new Book());
        return "/form/book";
    }

    @PostMapping("/form")
    public String save(Model model, @ModelAttribute @Valid Book book, BindingResult result){

            model.asMap().forEach((k, v) -> System.out.println(k + ": " + v));

        if(result.hasErrors()){
            return "/form/book";
        }
        bookRepository.save(book);
        return "/form/book";
    }
    @ModelAttribute("publishers")
    public Collection<Publisher> publishers(){
        return publisherDAO.findAll();

    }

    @RequestMapping("/validate")
    @ResponseBody
    public String validateTest() {
        Book p2 = new Book();
        Set<ConstraintViolation<Book>> violations = validator.validate(p2);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Book> constraintViolation : violations) {
                System.out.println(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage()); }
        } else {
// save object }
            return "validateResult"; }
            return violations.toString();
            }


}

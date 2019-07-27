package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PersonDAO;
import pl.coderslab.entity.Person;
import pl.coderslab.repository.PersonRepository;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonDAO personDAO;

    private final PersonRepository personRepository;


    public PersonController(PersonRepository personRepository, PersonDAO personDAO) {
        this.personRepository = personRepository;
        this.personDAO = personDAO;
    }
    @GetMapping(value = "/change")
    @ResponseBody
    public String testCustom() {
        personRepository.changeLastName("kowal", "Kowalski");
        return "All data changed";
    }


    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("person", new Person());
        return "/form/person";
    }
//    @GetMapping("/form")
//    public String form(){
//        return "/form/person";
//    }


    @PostMapping("/form")
    public String save(Model model, @ModelAttribute Person person){
        personDAO.save(person);
        model.addAttribute("person", new Person());
        return "/form/person";
    }

//    @PostMapping("/form")
//    public String save(@RequestParam("login") String login, @RequestParam("password") String password,
//                       @RequestParam("email") String email){
//        Person person = new Person();
//        person.setLogin(login);
//        person.setPassword(password);
//        person.setEmail(email);
//        personDAO.save(person);
//
//        return "/form/person";
//    }
}

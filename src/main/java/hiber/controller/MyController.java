package hiber.controller;

import hiber.dao.UserDao;
import hiber.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping()
public class MyController {

    @Autowired
    public UserDao userDao;

    @GetMapping("/")
    public String showAllUsers(Model model) {
        List<User> list = userDao.listUsers();

        model.addAttribute("attribute", list);
        return "default";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());

        return "add";
    }

    @PostMapping("/create")
    @Transactional
    public String create(@ModelAttribute("user") User user) {
        userDao.add(user);
        return "redirect:/";
    }

    @PostMapping("/update/{id}")
    @Transactional
    public String set(@ModelAttribute("user") User user, @PathVariable(name = "id") int id) {
        userDao.set(id, user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name = "id") int id) {

        ModelAndView modelAndView = new ModelAndView("edit");
        User user = userDao.get(id);

        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    @Transactional
    public String delete(@PathVariable(name = "id") int id) {
        userDao.delete(id);
        return "redirect:/";
    }
}

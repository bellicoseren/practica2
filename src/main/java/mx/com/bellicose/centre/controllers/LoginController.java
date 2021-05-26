package mx.com.bellicose.centre.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.com.bellicose.centre.entities.User;

@Controller()
@RequestMapping("/")
public class LoginController {

	@GetMapping()
	public String list() throws Exception {
		return "/list";
	}

	//@GetMapping({ "", "/" })
	//public String board(@RequestParam(value = "idx", defaultValue = "0") Long idx, Model model) throws Exception {
	@GetMapping()
	public String user(Model model) throws Exception {
		
			User user = new User();
			user.getAcyividades();
			model.addAttribute("user", user);
		
		return "/list/";
	}

}

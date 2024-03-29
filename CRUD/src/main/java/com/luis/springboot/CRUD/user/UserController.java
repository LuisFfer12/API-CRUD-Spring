package com.luis.springboot.CRUD.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/users")
public class UserController {

	 private ApplicationUserRepository applicationUserRepository;
	    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserController(ApplicationUserRepository applicationUserRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
this.applicationUserRepository = applicationUserRepository;
this.bCryptPasswordEncoder = bCryptPasswordEncoder;
}

	
	@PostMapping("/sign-up")
		public void signUp(@RequestBody ApplicationUser user) {
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		//user.setId(0);
        applicationUserRepository.save(user);
	}
}

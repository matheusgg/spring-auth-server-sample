package br.com.security.web.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Matheus on 20/03/16.
 */
@RestController
public class ProtectedResource {

	@RequestMapping(value = "me")
	public Principal me(final Principal principal) {
		return principal;
	}

	@RequestMapping(value = "greetings")
	public String greetings(final Principal principal) {
		return "Hi " + principal.getName();
	}

}

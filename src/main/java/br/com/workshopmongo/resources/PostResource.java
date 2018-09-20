package br.com.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.workshopmongo.domain.Post;
import br.com.workshopmongo.resources.util.URL;
import br.com.workshopmongo.service.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	public PostService postService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = postService.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	//encontrar serviço passando uma parte do titulo do post
	@RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decodeParam(text); //decodifica a string passada (se caso houver espaços no parametro ele decodifica esse espaço)
		
		List<Post> list = postService.findByTitle(text);
		
		return ResponseEntity.ok().body(list);
	}
}

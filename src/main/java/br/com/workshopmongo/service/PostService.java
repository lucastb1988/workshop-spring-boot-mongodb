package br.com.workshopmongo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.workshopmongo.domain.Post;
import br.com.workshopmongo.repository.PostRepository;
import br.com.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	public PostRepository postRepository;
	
	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}

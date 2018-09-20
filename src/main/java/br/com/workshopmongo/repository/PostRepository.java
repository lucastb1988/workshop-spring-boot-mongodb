package br.com.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> { //<Post, tipo do id da classe User(String)>

	List<Post> findByTitleContainingIgnoreCase(String text);
}

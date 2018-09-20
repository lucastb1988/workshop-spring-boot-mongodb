package br.com.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> { //<User, tipo do id da classe User(String)>

	
}

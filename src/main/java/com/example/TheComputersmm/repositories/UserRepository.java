package com.example.TheComputersmm.repositories;

import com.example.TheComputersmm.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>
{
	public User findByUsername(String username);
}

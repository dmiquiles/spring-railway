package miquiles.daniel.springrailway.services;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import miquiles.daniel.springrailway.models.User;
import miquiles.daniel.springrailway.repository.UserRepository;
import miquiles.daniel.springrailway.services.interfaces.IUserService;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRepository.save(userToCreate);
    }
}
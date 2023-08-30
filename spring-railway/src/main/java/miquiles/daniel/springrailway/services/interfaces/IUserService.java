package miquiles.daniel.springrailway.services.interfaces;

import miquiles.daniel.springrailway.models.User;

public interface IUserService {

    User findById(Long id);

    User create(User userToCreate);
}
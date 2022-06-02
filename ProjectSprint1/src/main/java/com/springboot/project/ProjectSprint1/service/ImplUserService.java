package com.springboot.project.ProjectSprint1.service;

import com.springboot.project.ProjectSprint1.model.User;
import com.springboot.project.ProjectSprint1.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplUserService implements IUserService {
    private final IUserRepository iUserRepository;

    public ImplUserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public User createUser(User user) {
        return iUserRepository.save(user);
    }

    @Override
    public Optional<User> findByIdUser(String idUser) {
        try {
            return iUserRepository.findById(Long.parseLong(idUser));
        } catch (NumberFormatException e) {
            e.getMessage();
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<User>> getAllUsers() {
        List<User> listUsers = iUserRepository.findAll();
        return (listUsers != null && !listUsers.isEmpty()) ? Optional.of(listUsers) : Optional.empty();
    }

    @Override
    public boolean deleteUser(String idUser) {
        try {
            Long id = Long.parseLong(idUser);
            iUserRepository.deleteById(id);
            Optional<User> user = iUserRepository.findById(id);
            return user.isPresent() ? false : true;
        } catch (NumberFormatException e) {
             e.getMessage();
             return false;
        }
    }

    @Override
    public Optional<User> updateUser(String idUser, User userUpdated) {
        Optional<User> user = iUserRepository.findById(Long.parseLong(idUser));
        if (user.isPresent()){
            user.get().setEmail(userUpdated.getEmail());
            user.get().setFirst_name(userUpdated.getFirst_name());
            user.get().setLast_name(userUpdated.getLast_name());
            user.get().setUsername(userUpdated.getUsername());
            return Optional.of(iUserRepository.save(user.get()));
        } else {
            return Optional.empty();
        }
    }
}

package com.springboot.project.ProjectSprint1.service;

import com.springboot.project.ProjectSprint1.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
@Service
public class ImplUserService implements IUserService {
    private final List<User> listUsers = new ArrayList<>();


    @Override
    public User createUser(User user) {
        listUsers.add(user);
        return listUsers.stream().filter(element -> element.getIdUser().equals(user.getIdUser())).collect(Collectors.toList()).get(0);
    }

    @Override
    public Optional<User> findByIdUser(String idUser) {
        User user = listUsers.stream().filter(element -> element.getIdUser().equals(idUser)).collect(Collectors.toList()).get(0);
        return user != null ? Optional.of(user) : Optional.empty();
    }

    @Override
    public Optional<List<User>> getAllUsers() {
        return (listUsers != null && !listUsers.isEmpty()) ? Optional.of(listUsers) : Optional.empty();
    }

    @Override
    public boolean deleteUser(String idUser) {
        listUsers.removeIf((s) -> s.getIdUser().equals(idUser));
        return !listUsers.stream().anyMatch(element -> element.getIdUser().equals(idUser));
    }

    @Override
    public Optional<User> updateUser(String idUser, User userUpdated) {
        try {
            int index = IntStream.range(0, listUsers.size())
                    .filter(userIndex -> listUsers.get(userIndex).getIdUser().equals(idUser))
                    .findFirst().getAsInt();
            listUsers.get(index).setEmail(userUpdated.getEmail());
            listUsers.get(index).setFirstName(userUpdated.getFirstName());
            listUsers.get(index).setLastName(userUpdated.getLastName());
            listUsers.get(index).setUsername(userUpdated.getUsername());
            return Optional.of(listUsers.get(index));
        } catch (NoSuchElementException e) {
            return Optional.empty();
        }
    }
}

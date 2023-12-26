package net.javaguides.Project.service;

import net.javaguides.Project.model.Animal;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AnimalService {
    List<Animal> getAllAnimals();

    void saveAnimal(Animal animal);

    Animal getAnimalById(long id);

    public void deleteAnimalById(long id);

    Page<Animal> findPaginated(int pageNo, int pageSize);

    Page<Animal> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);


}

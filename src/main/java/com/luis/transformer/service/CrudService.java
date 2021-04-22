package com.luis.transformer.service;

import java.util.List;
import java.util.Objects;
import javax.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudService<T> {

    JpaRepository<T, Long> getRepository();

    default T save(T entity) {
        return getRepository().saveAndFlush(entity);
    }

    default List<T> save(List<T> entities) {
        return getRepository().saveAll(entities);
    }

    default void delete(T entity) {
        if (Objects.isNull(entity)) {
            throw new EntityNotFoundException("Could not delete the entity. Can't be null");
        }
        getRepository().delete(entity);
    }

    default void delete(Long id) {
        getRepository().delete(load(id));
    }

    default Long count() {
        return getRepository().count();
    }

    default T load(Long id) {
        return getRepository().findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Entity not found with ID %s. Please try another Id.", id)));

    }

    default List<T> findAll() {

        List<T> allEntities = getRepository().findAll();

        if (allEntities.isEmpty()) {
            throw new EntityNotFoundException("Not found list of transformers");
        }

        return allEntities;

    }

}

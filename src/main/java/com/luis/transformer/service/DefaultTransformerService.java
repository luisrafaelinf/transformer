package com.luis.transformer.service;

import com.luis.transformer.exception.EntityAlreadyExistException;
import com.luis.transformer.model.entity.Transformer;
import com.luis.transformer.repository.TransformerRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultTransformerService implements TransformerService, CrudService<Transformer> {

    private final TransformerRepository repository;

    public DefaultTransformerService(TransformerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long totalTransformers() {
        return count();
    }

    @Override
    @Transactional
    public List<Transformer> saveAllTransformers(List<Transformer> Transformers) {
        return save(Transformers);
    }

    @Override
    @Transactional
    public Transformer saveTransformer(Transformer transformer) {
        
        repository.findByName(transformer.getName())
                .ifPresent(t -> {
                    throw new EntityAlreadyExistException(String.format("Transformer with name %s already exits", t.getName()));
                });

        return save(transformer);
    }

    @Override
    public Transformer getTransformerById(Long id) {
        return load(id);
    }

    @Override
    public List<Transformer> findAllTransformers() {
        return findAll();
    }

    @Override
    @Transactional
    public void deleteAllTransformers() {
        getRepository().deleteAll();
    }

    @Override
    @Transactional
    public void deleteTransformer(Long id) {
        delete(id);
    }

    @Override
    public JpaRepository<Transformer, Long> getRepository() {
        return (JpaRepository<Transformer, Long>) repository;
    }

    @Override
    @Transactional(readOnly = true)
    public Transformer getByName(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Transformer with name %s not found", name)));
    }

    @Override
    public Transformer updateTransformer(Transformer transformer) {
        
        load(transformer.getId());

        Optional<Transformer> byName = repository.findByName(transformer.getName());

        if (byName.isEmpty()) {
            return save(transformer);
        }

        if (Objects.equals(byName.get().getId(), transformer.getId())) {
            return save(transformer);
        }

        throw new EntityAlreadyExistException(String.format("Transformer with name %s already exits. Change the name and try again", transformer.getName()));
    }

}

package com.luis.transformer.service;

import com.luis.transformer.exception.EntityAlreadyExistException;
import com.luis.transformer.fakedata.FakeTransformers;
import com.luis.transformer.model.entity.Transformer;
import com.luis.transformer.repository.JpaTransformerRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DefaultTransformerServiceTest {

    @Mock
    private JpaTransformerRepository repository;

    private TransformerService transformerService;

    public DefaultTransformerServiceTest() {
    }

    @BeforeEach
    public void setUp() {
        transformerService = new DefaultTransformerService(repository);
    }

    @AfterEach
    public void tearDown() {
        repository = null;
        transformerService = null;
    }

    @Test
    public void testTotalTransformers() {

        Mockito.when(repository.count()).thenReturn(1l);

        MatcherAssert.assertThat(String.format("Should return %s", 1), transformerService.totalTransformers(), Matchers.equalTo(1l));

    }

    @Test
    @DisplayName("Save transformer")
    public void testSaveTransformer() {

        Transformer toSave = FakeTransformers.getSkyfire();

        when(repository.findByName(toSave.getName())).thenReturn(Optional.empty());

        transformerService.saveTransformer(toSave);

        verify(repository,
                times(1)
                        .description("service should call the repository's method 'findByName'  one time")
        ).findByName(anyString());

    }

    @Test
    @DisplayName("Save transformer with name already exist")
    public void testSaveTransformerExistName() {

        Transformer toSave = FakeTransformers.getSkyfire();
        Transformer founded = new Transformer();
        founded.setName(toSave.getName());

        when(repository.findByName(toSave.getName())).thenReturn(Optional.of(founded));

        assertThrows(EntityAlreadyExistException.class, () -> {
            transformerService.saveTransformer(toSave);
        }, "EntityAlreadyExistException should be throw");

        verify(repository,
                times(1)
                        .description("service should call the repository's method 'findByName'  one time")
        ).findByName(anyString());

    }

    @Test
    @DisplayName("Find transformer by ID")
    public void testGetTransformerById() {

        Long id = 1l;

        when(repository.findById(anyLong())).thenReturn(Optional.of(mock(Transformer.class)));

        Transformer transformerById = transformerService.getTransformerById(id);

        assertThat(String.format("Transformer with ID $s should not be null", id), Objects.nonNull(transformerById), is(true));

    }

    @Test
    @DisplayName("Find transformer by ID not exists")
    public void testGetTransformerByIdNotExists() {

        Long id = 1l;

        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            transformerService.getTransformerById(id);
        }, "EntityNotFoundException should be throw");

    }

    @Test
    @DisplayName("Find all transformers")
    public void testFindAllTransformers() {

        when(repository.findAll()).thenReturn(FakeTransformers.getListTransformers());

        List<Transformer> allTransformers = transformerService.findAllTransformers();

        assertThat("The list of transformers should not be empty", allTransformers.isEmpty(), is(false));

    }

    @Test
    @DisplayName("Find all transformers empty list")
    public void testFindAllTransformersEmptyList() {

        when(repository.findAll()).thenReturn(new ArrayList<>());

        assertThrows(EntityNotFoundException.class, () -> {
            transformerService.findAllTransformers();
        }, "EntityNotFoundException should be throw");

    }

    @Test
    @DisplayName("deleting all transformers")
    public void testDeleteAllTransformers() {

        doNothing().when(repository).deleteAll();

        transformerService.deleteAllTransformers();

        verify(repository,
                times(1)
                        .description("service should call the repository's method 'deleteAll'  one time")
        ).deleteAll();
    }

    @Test
    @DisplayName("delete transformer by existent ID")
    public void testDeleteTransformerById() {

        Long id = 1l;

        when(repository.findById(anyLong())).thenReturn(Optional.of(mock(Transformer.class)));
        
        transformerService.deleteTransformer(id);

        verify(repository,
                times(1)
                        .description("service should call the repository's method 'findById'  one time")
        ).findById(id);

    }

    @Test
    @DisplayName("delete transformer by not existent ID")
    public void testDeleteTransformerByNotExistetnId() {

        Long id = 1l;

        when(repository.findById(anyLong())).thenReturn(Optional.empty());
        
        assertThrows(EntityNotFoundException.class, () -> {
            transformerService.deleteTransformer(id);
        }, "EntityNotFoundException should be throw");

        verify(repository,
                times(1)
                        .description("service should call the repository's method 'findById'  one time")
        ).findById(id);

    }

    @Test
    @DisplayName("Find transformer by name")
    public void testGetByName() {
        
        final String name = FakeTransformers.getSkyfire().getName();
        
        when(repository.findByName(anyString())).thenReturn(Optional.of(mock(Transformer.class)));
        
        Transformer byName = transformerService.getByName(anyString());
        
        assertThat(String.format("Transformer with name %s shoul be found", name), Objects.nonNull(byName), is(true));
        
    }

    @Test
    @DisplayName("Find transformer by name unknown")
    public void testGetByNameUnknown() {
        
        final String name = FakeTransformers.getSkyfire().getName();
        
        when(repository.findByName(anyString())).thenReturn(Optional.empty());
        
        assertThrows(EntityNotFoundException.class, () -> {
            transformerService.getByName(anyString());        
        }, "EntityNotFoundException should be throw");
        
    }

    @Test
    @DisplayName("updating transformer with new name")
    public void testUpdateTransformerNewName() {
        
        final String newName = "fakeName";
        
        Transformer skyfire = FakeTransformers.getSkyfire();
        skyfire.setId(1l);
        skyfire.setName(newName);
        
        when(repository.findById(anyLong())).thenReturn(Optional.of(skyfire));
        when(repository.findByName(anyString())).thenReturn(Optional.empty());
        when(repository.saveAndFlush(skyfire)).thenReturn(skyfire);
        
        Transformer updateTransformer = transformerService.updateTransformer(skyfire);
        
        verify(repository,
                times(1)
                        .description("service should call the repository's method 'findByName'  one time")
        ).findByName(anyString());
        
        verify(repository,
                times(1)
                        .description("service should call the repository's method 'findById'  one time")
        ).findById(anyLong());
        
        verify(repository,
                times(1)
                        .description("service should call the repository's method 'saveAndFlush'  one time")
        ).saveAndFlush(skyfire);
        
        assertThat(
                String.format("The transformer updated should change the name to $s", newName), 
                Objects.equals(updateTransformer.getName(), newName), 
                is(true)
        );
        
    }

    @Test
    @DisplayName("updating transformer with name existent")
    public void testUpdateTransformerNameExistent() {
                
        Transformer skyfire = FakeTransformers.getSkyfire();
        skyfire.setId(1l);
        
        Transformer bluestreak = FakeTransformers.getBluestreak();
        bluestreak.setId(2l);
        bluestreak.setName(skyfire.getName());
        
        when(repository.findById(anyLong())).thenReturn(Optional.of(bluestreak));
        when(repository.findByName(anyString())).thenReturn(Optional.of(skyfire));
        
        assertThrows(EntityAlreadyExistException.class, () -> {
            transformerService.updateTransformer(bluestreak);        
        }, "EntityAlreadyExistException should be throw");
        
        verify(repository,
                times(1)
                        .description("service should call the repository's method 'findByName'  one time")
        ).findByName(anyString());
        
        verify(repository,
                times(1)
                        .description("service should call the repository's method 'findById'  one time")
        ).findById(anyLong());
                
    }

    @Test
    @DisplayName("updating transformer with ID not existent")
    public void testUpdateTransformerIdExistent() {
                        
        Transformer bluestreak = FakeTransformers.getSkyfire();
        bluestreak.setId(2l);
        
        when(repository.findById(anyLong())).thenReturn(Optional.empty());
        
        assertThrows(EntityNotFoundException.class, () -> {
            transformerService.updateTransformer(bluestreak);        
        }, "EntityNotFoundException should be throw");
        
        verify(repository,
                times(1)
                        .description("service should call the repository's method 'findById'  one time")
        ).findById(anyLong());
        
                
    }

}

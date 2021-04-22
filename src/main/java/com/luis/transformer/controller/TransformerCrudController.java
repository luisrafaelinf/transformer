package com.luis.transformer.controller;

import com.luis.transformer.process.TransformerCrudTransaction;
import com.luis.transformer.model.request.TransformerRequest;
import com.luis.transformer.model.response.TransformerResponse;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        path = "transformers/v1",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
public class TransformerCrudController {

    private final TransformerCrudTransaction crudTransaction;
    private final RepresentationModelAssembler assembler;

    public TransformerCrudController(TransformerCrudTransaction crudTransaction, @Qualifier("transformer") RepresentationModelAssembler assembler) {
        this.crudTransaction = crudTransaction;
        this.assembler = assembler;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CollectionModel<EntityModel<TransformerResponse>> findAllTransformers() {

        List<TransformerResponse> transformers = crudTransaction.findAllTransformer();

        return assembler.toCollectionModel(transformers);

    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EntityModel<TransformerResponse> findTransformerById(@PathVariable("id") Long id) {

        TransformerResponse transformer = crudTransaction.findTransformerById(id);

        return (EntityModel<TransformerResponse>) assembler.toModel(transformer);
    }

    @PostMapping(value = "/transformer")
    @ResponseStatus(HttpStatus.CREATED)
    public EntityModel<TransformerResponse> createTransformer(@RequestBody @Valid TransformerRequest transformerRequest) {

        TransformerResponse transformer = crudTransaction.createNewTransformer(transformerRequest);

        return (EntityModel<TransformerResponse>) assembler.toModel(transformer);

    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EntityModel<TransformerResponse> updateTransformer(@RequestBody @Valid TransformerRequest transformerRequest, @PathVariable("id") Long id) {

        TransformerResponse transformer = crudTransaction.updateTransformer(transformerRequest, id);

        return (EntityModel<TransformerResponse>) assembler.toModel(transformer);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteTransformer(@PathVariable("id") Long id) {
        crudTransaction.deleteTransformer(id);
        
        return ResponseEntity.noContent().build();
    }

}

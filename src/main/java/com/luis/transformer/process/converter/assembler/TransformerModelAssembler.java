package com.luis.transformer.process.converter.assembler;

import com.luis.transformer.controller.TransformerCrudController;
import com.luis.transformer.model.request.TransformerRequest;
import com.luis.transformer.model.response.TransformerResponse;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;


@Component
@Qualifier("transformer")
public class TransformerModelAssembler implements RepresentationModelAssembler<TransformerResponse, EntityModel<TransformerResponse>> {

    @Override
    public EntityModel<TransformerResponse> toModel(TransformerResponse transformer) {
        
        return EntityModel.of(
                transformer,
                linkTo(methodOn(TransformerCrudController.class).findTransformerById(transformer.getId())).withSelfRel().withType(RequestMethod.GET.toString()),
                linkTo(methodOn(TransformerCrudController.class).updateTransformer(new TransformerRequest(),transformer.getId())).withRel("Update").withType(RequestMethod.PUT.toString()),
                linkTo(methodOn(TransformerCrudController.class).deleteTransformer(transformer.getId())).withRel("Delete").withType(RequestMethod.DELETE.toString()),
                linkTo(methodOn(TransformerCrudController.class).findAllTransformers()).withRel("all-transformers").withType(RequestMethod.GET.toString())
        );
    }

    @Override
    public CollectionModel<EntityModel<TransformerResponse>> toCollectionModel(Iterable<? extends TransformerResponse> transformers) {
        
        Spliterator<? extends TransformerResponse> spliterator = transformers.spliterator();
        Stream<? extends TransformerResponse> stream = StreamSupport.stream(spliterator, false);
        
        List<EntityModel<TransformerResponse>> transformersResponse = stream
                .map(this::toModel)
                .collect(Collectors.toList());
                
        return CollectionModel.of(
                transformersResponse,
                linkTo(methodOn(TransformerCrudController.class).findAllTransformers()).withSelfRel().withType(RequestMethod.GET.toString()));
    }

}

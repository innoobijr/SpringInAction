package com.example.demo.api;

import com.example.demo.controller.DesignTacoController;
import com.example.demo.model.Taco;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class TacoResourceAssembler extends ResourceAssemblerSupport<Taco, TacoResource> {

    public TacoResourceAssembler(){
        super(DesignTacoController.class, TacoResource.class);
    }

    @Override
    public TacoResource instantiateResource(Taco taco){
        return new TacoResource(taco);
    }

    @Override
    public TacoResource toResource(Taco taco){
        return createResourceWithId(taco.getId(), taco);
    }
}

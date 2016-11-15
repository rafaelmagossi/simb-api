package com.magossi.apisimb.resources.bovino;

import com.magossi.apisimb.domain.bovino.Peso;
import com.magossi.apisimb.service.bovino.PesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Created by RafaelMq on 03/11/2016.
 */

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/peso")
public class PesoResources {

    @Autowired
    public PesoService pesoService;


    @RequestMapping(method =  RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody Peso peso){
        peso = pesoService.salvar(peso);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(peso.getIdPeso()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Peso>> listar(){

        List<Peso> pesos = pesoService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(pesos);
    }
}

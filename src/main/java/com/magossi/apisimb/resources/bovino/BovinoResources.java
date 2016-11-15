package com.magossi.apisimb.resources.bovino;

import com.magossi.apisimb.domain.bovino.Bovino;

import com.magossi.apisimb.domain.bovino.Ecc;
import com.magossi.apisimb.domain.bovino.Peso;
import com.magossi.apisimb.service.bovino.BovinoService;
import com.magossi.apisimb.service.bovino.EccService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Created by RafaelMq on 15/05/2016.
 */

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/bovino")
public class BovinoResources {


    @Autowired
    public BovinoService bovinoService;

    @Autowired
    public EccService eccService;

    // ******************************** METODOS POST *******************************************************

    @RequestMapping(method =  RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody Bovino bovino){
        bovino = bovinoService.salvar(bovino);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(bovino.getIdBovino()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}/ecc", method =  RequestMethod.POST)
    public ResponseEntity<Void> salvarEccBovino(@PathVariable("id") Long id, @RequestBody Ecc ecc){
        Bovino bovino = bovinoService.buscarId(id);
        bovino.getEcc().add(ecc);
        bovino = bovinoService.salvar(bovino);


        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(bovino.getIdBovino()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}/peso", method =  RequestMethod.POST)
    public ResponseEntity<Void> salvarPesoBovino(@PathVariable("id") Long id, @RequestBody Peso peso){
        Bovino bovino = bovinoService.buscarId(id);
        bovino.getPeso().add(peso);
        bovino = bovinoService.salvar(bovino);


        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(bovino.getIdBovino()).toUri();

        return ResponseEntity.created(uri).build();
    }


    // ******************************** METODOS GET *******************************************************

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Bovino>> listar(){

        List<Bovino> bovino = bovinoService.buscarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(bovino);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Bovino> buscarBovinoPorId(@PathVariable("id") Long id){   //? encapsula qualquer tipo de objeto

        Bovino bovino = bovinoService.buscarId(id);
        return ResponseEntity.status(HttpStatus.OK).body(bovino);
    }

    @RequestMapping(value = "/tag/{tag}", method = RequestMethod.GET)
    public ResponseEntity<Bovino> buscarBovinoPorTag(@PathVariable("tag")String tag){

        Bovino bovino = bovinoService.buscarTag(tag);
        return ResponseEntity.status(HttpStatus.OK).body(bovino);

    }



}

package com.magossi.apisimb.resources.bovino;

import com.magossi.apisimb.domain.bovino.Ecc;
import com.magossi.apisimb.service.bovino.EccService;
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
@RequestMapping("/ecc")
public class EccResources {

    @Autowired
    public EccService eccService;


    @RequestMapping(method =  RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody Ecc ecc){
        ecc = eccService.salvar(ecc);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(ecc.getIdECC()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Ecc>> listar(){

        List<Ecc> eccs = eccService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(eccs);
    }
}

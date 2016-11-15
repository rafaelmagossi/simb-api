package com.magossi.apisimb.resources.matriz;

import com.magossi.apisimb.domain.matriz.DiagnosticoGestacao;
import com.magossi.apisimb.service.matriz.DiagGestService;
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
 * Created by RafaelMq on 04/11/2016.
 */


@SuppressWarnings("ALL")
@RestController
@RequestMapping("/diagnosticogestacao")
public class DiagGestResources {

    @Autowired
    public DiagGestService diagGestService;

    @RequestMapping(method =  RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody DiagnosticoGestacao diagnosticoGestacao){
        diagnosticoGestacao = diagGestService.salvar(diagnosticoGestacao);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(diagnosticoGestacao.getIdDiagGest()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<DiagnosticoGestacao>> listar(){

        List<DiagnosticoGestacao> diagnosticoGestacoes = diagGestService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(diagnosticoGestacoes);
    }
}

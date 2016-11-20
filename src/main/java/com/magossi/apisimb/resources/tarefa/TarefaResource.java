package com.magossi.apisimb.resources.tarefa;

import com.magossi.apisimb.domain.bovino.Bovino;
import com.magossi.apisimb.domain.matriz.Inseminacao;
import com.magossi.apisimb.domain.tarefa.Tarefa;
import com.magossi.apisimb.service.tarefa.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.constraints.AssertFalse;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by RafaelMq on 16/11/2016.
 */

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/tarefa")
public class TarefaResource {

    @Autowired
    public TarefaService tarefaService;

    @RequestMapping(method =  RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody Tarefa tarefa){
        tarefa = tarefaService.salvar(tarefa);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(tarefa.getIdTarefa()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}/inseminacao", method =  RequestMethod.POST)
    public ResponseEntity<Void> salvarInseminacaoTarefa(@PathVariable("id") Long id, @RequestBody Inseminacao inseminacao){
        Tarefa tarefa = tarefaService.buscarId(id);
        if (tarefa.getBovinoMatriz().getFichaMatriz().getInseminacao().isEmpty()){
            List<Inseminacao> inseminacaos = new ArrayList<>();
            tarefa.getBovinoMatriz().getFichaMatriz().setInseminacao(inseminacaos);
        }
        tarefa.setStatusDaTarefa(true);
        tarefa.setDataConclusao(new Date());
        tarefa.getBovinoMatriz().getFichaMatriz().getInseminacao().add(inseminacao);
        tarefa = tarefaService.atualizar(tarefa);


        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(tarefa.getIdTarefa()).toUri();

        return ResponseEntity.created(uri).build();
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Tarefa>> listar(){

        List<Tarefa> tarefas = tarefaService.buscarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(tarefas);
    }

    @RequestMapping(value = "/imei/{imei}", method = RequestMethod.GET)
    public ResponseEntity<List<Tarefa>> buscarBovinoPorTag(@PathVariable("imei")String imei){

        List<Tarefa> tarefas = tarefaService.buscarImei(imei);
        return ResponseEntity.status(HttpStatus.OK).body(tarefas);

    }
}

package com.magossi.apisimb.service.tarefa;

import com.magossi.apisimb.domain.tarefa.Tarefa;
import com.magossi.apisimb.repository.tarefa.TarefaRepository;
import com.magossi.apisimb.service.exceptions.BovinoExistenteException;
import com.magossi.apisimb.service.exceptions.BovinoNaoEncontradoException;
import com.magossi.apisimb.service.exceptions.BovinoNaoExistenteException;
import com.magossi.apisimb.service.exceptions.EccNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by RafaelMq on 16/11/2016.
 */

@SuppressWarnings("ALL")
@Service
public class TarefaService {


    @Autowired
    TarefaRepository tarefaRepository;

    public Tarefa salvar(Tarefa tarefa){
        if(tarefa.getIdTarefa() != null){

            Tarefa t = tarefaRepository.findOne(tarefa.getIdTarefa());
            if(t != null){
                throw new BovinoExistenteException("Tarefa já Existe");
            }
        }
        return tarefaRepository.save(tarefa);
    }

    public Tarefa atualizar(Tarefa tarefa){
        if(tarefa.getIdTarefa() != null){

            Tarefa t = tarefaRepository.findOne(tarefa.getIdTarefa());
            if(t == null){
                throw new BovinoExistenteException("Tarefa Nao Existe");
            }
        }
        return tarefaRepository.save(tarefa);
    }

    public Tarefa buscarId(Long id){
        Tarefa tarefa = tarefaRepository.findOne(id);

        if(tarefa==null){
            throw new BovinoNaoEncontradoException("Tarefa não Encontrada");
        }
        return tarefa;
    }

    public List<Tarefa> buscarTodos(){
        List<Tarefa> tarefas = tarefaRepository.findAll();

        if(tarefas==null){
            throw new EccNaoEncontradoException("Lista de Tarefas não Encontrada");
        }
        return tarefas;
    }

    public List<Tarefa> buscarImei(String imei){
        List<Tarefa> tarefas = tarefaRepository.findByImei(imei);

        if(tarefas==null){
            throw new EccNaoEncontradoException("Lista de Tarefas não Encontrada");
        }

        return tarefas;
    }
}

package com.magossi.apisimb.repository.tarefa;

import com.magossi.apisimb.domain.tarefa.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by RafaelMq on 16/11/2016.
 */
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findByImei(String tag);
    List<Tarefa> findByStatusDaTarefaOrderByDataInclusaoAsc(Boolean statusDaTarefa);
    List<Tarefa> findByDataInclusaoContainingAndStatusDaTarefaOrderByDataInclusaoAsc(Date dataInclusao, Boolean statusDaTarefa);

}

package com.magossi.apisimb.repository.tarefa;

import com.magossi.apisimb.domain.tarefa.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by RafaelMq on 16/11/2016.
 */
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}

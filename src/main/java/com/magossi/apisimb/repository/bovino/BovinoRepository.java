package com.magossi.apisimb.repository.bovino;

import com.magossi.apisimb.domain.bovino.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by RafaelMq on 15/05/2016.
 */
public interface BovinoRepository extends JpaRepository<Bovino, Long>{

        Bovino findByTag(String tag);
        //Bovino findByNomeBovino(String nome);
        List<Bovino> findByNomeBovinoContaining(String nome);
        List<Bovino> findByPai(String pai);
        List<Bovino> findByMaeContaining(String mae);
        List<Bovino> findByRaca(Raca raca);
        List<Bovino> findByPelagem(Pelagem pelagem);
        List<Bovino> findByFazenda(Fazenda fazenda);
        List<Bovino> findByProprietario(Proprietario proprietario);
        List<Bovino> findByDataNascimento(Date data);
        List<Bovino> findByPeso(Peso peso);
        List<Bovino> findByStatus(Boolean status);


}
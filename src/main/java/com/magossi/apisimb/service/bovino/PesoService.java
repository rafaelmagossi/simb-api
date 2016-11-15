package com.magossi.apisimb.service.bovino;

import com.magossi.apisimb.domain.bovino.Peso;
import com.magossi.apisimb.repository.bovino.PesoRepository;
import com.magossi.apisimb.service.exceptions.PesoExistenteException;
import com.magossi.apisimb.service.exceptions.PesoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by RafaelMq on 03/11/2016.
 */

@SuppressWarnings("ALL")
@Service
public class PesoService {

    @Autowired
    PesoRepository pesoRepository;


    public Peso salvar(Peso peso){
        if(peso.getIdPeso() != null){

            Peso p = pesoRepository.findOne(peso.getIdPeso());
            if(p != null){
                throw new PesoExistenteException("Peso já Existe");
            }
        }
        return pesoRepository.save(peso);
    }

    public List<Peso> listar(){
        List<Peso> pesos = pesoRepository.findAll();

        if(pesos==null){
            throw new PesoNaoEncontradoException("Lista de Pesos não Encontrada");
        }
        return pesos;
    }
}

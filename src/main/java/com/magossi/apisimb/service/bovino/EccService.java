package com.magossi.apisimb.service.bovino;

import com.magossi.apisimb.domain.bovino.Ecc;
import com.magossi.apisimb.repository.bovino.EccRepository;
import com.magossi.apisimb.service.exceptions.EccExistenteException;
import com.magossi.apisimb.service.exceptions.EccNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by RafaelMq on 03/11/2016.
 */

@SuppressWarnings("ALL")
@Service
public class EccService {

    @Autowired
    EccRepository eccRepository;


    public Ecc salvar(Ecc ecc){
        if(ecc.getIdECC() != null){

            Ecc e = eccRepository.findOne(ecc.getIdECC());
            if(e != null){
                throw new EccExistenteException("Ecc já Existe");
            }
        }
        return eccRepository.save(ecc);
    }

    public List<Ecc> listar(){
        List<Ecc> eccs = eccRepository.findAll();

        if(eccs==null){
            throw new EccNaoEncontradoException("Lista de Eccs não Encontrada");
        }
        return eccs;
    }
}

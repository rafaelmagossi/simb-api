package com.magossi.apisimb.service.matriz;

import com.magossi.apisimb.domain.matriz.Parto;
import com.magossi.apisimb.repository.matriz.PartoRepository;
import com.magossi.apisimb.service.exceptions.FazendaExistenteException;
import com.magossi.apisimb.service.exceptions.FazendaNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by RafaelMq on 04/11/2016.
 */

@SuppressWarnings("ALL")
@Service
public class PartoService {

    @Autowired
    PartoRepository m_partoRepository;


    public Parto salvar(Parto parto){
        if(parto.getIdParto() != null){

            Parto p = m_partoRepository.findOne(parto.getIdParto());
            if(p != null){
                throw new FazendaExistenteException("Intervalo de Parto já Existe");
            }
        }
        return m_partoRepository.save(parto);
    }

    public List<Parto> listar(){
        List<Parto> partos = m_partoRepository.findAll();

        if(partos==null){
            throw new FazendaNaoEncontradaException("Lista de Intervalos de Parto não Encontrada");
        }
        return partos;
    }
}

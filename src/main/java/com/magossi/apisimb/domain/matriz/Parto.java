package com.magossi.apisimb.domain.matriz;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.magossi.apisimb.domain.bovino.Bovino;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by RafaelMq on 04/11/2016.
 */

@Entity
public class Parto {


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParto;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date dataParto;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(fetch = FetchType.LAZY)
    private List<Bovino> bovinoParto;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date dataInclusao = new Date();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean status;


    public Long getIdParto() {
        return idParto;
    }

    public void setIdParto(Long idParto) {
        this.idParto = idParto;
    }

    public Date getDataParto() {
        return dataParto;
    }

    public void setDataParto(Date dataParto) {
        this.dataParto = dataParto;
    }

    public List<Bovino> getBovinoParto() {
        return bovinoParto;
    }

    public void setBovinoParto(List<Bovino> bovinoParto) {
        this.bovinoParto = bovinoParto;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

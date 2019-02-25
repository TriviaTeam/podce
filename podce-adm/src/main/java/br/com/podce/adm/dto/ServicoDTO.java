package br.com.podce.adm.dto;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Victor Alexsander
 *
 */
public class ServicoDTO {

    private Integer id;
    private String titulo;
    private String descricao;
    private LocalDate dataCadastro;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private UsuarioDTO usuarioCriado;
    private List<TipoServicoDTO> listaServicos;
    private List<AnexoDTO> anexos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public UsuarioDTO getUsuarioCriado() {
        return usuarioCriado;
    }

    public void setUsuarioCriado(UsuarioDTO usuarioCriado) {
        this.usuarioCriado = usuarioCriado;
    }

    public List<TipoServicoDTO> getListaServicos() {
        return listaServicos;
    }

    public void setListaServicos(List<TipoServicoDTO> listaServicos) {
        this.listaServicos = listaServicos;
    }

    public List<AnexoDTO> getAnexos() {
        return anexos;
    }

    public void setAnexos(List<AnexoDTO> anexos) {
        this.anexos = anexos;
    }
}

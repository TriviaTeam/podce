package br.com.podce.adm.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AvaliacaoServicoOfertaPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "id_servico", referencedColumnName="id_servico"),@JoinColumn(name = "id_usuario_ofertante", referencedColumnName="id_usuario_ofertante")})
    private ServicoOferta ordemServicoServico;

    @ManyToOne
    @JoinColumn(name="usuarioAvaliador")
    private Usuario usuarioOfertante;

    public AvaliacaoServicoOfertaPK() {
    }

    public AvaliacaoServicoOfertaPK(ServicoOferta ordemServicoServico, Usuario usuarioOfertante) {
        this.ordemServicoServico = ordemServicoServico;
        this.usuarioOfertante = usuarioOfertante;
    }

    public ServicoOferta getOrdemServicoServico() {
        return ordemServicoServico;
    }

    public void setOrdemServicoServico(ServicoOferta ordemServicoServico) {
        this.ordemServicoServico = ordemServicoServico;
    }

    public Usuario getUsuarioOfertante() {
        return usuarioOfertante;
    }

    public void setUsuarioOfertante(Usuario usuarioOfertante) {
        this.usuarioOfertante = usuarioOfertante;
    }
}

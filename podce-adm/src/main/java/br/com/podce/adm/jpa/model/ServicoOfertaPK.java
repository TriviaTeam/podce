package br.com.podce.adm.jpa.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class ServicoOfertaPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name="id_servico")
    private Servico servico;

    @ManyToOne
    @JoinColumn(name="id_usuario_ofertante")
    private Usuario usuarioOfertante;

    public ServicoOfertaPK() {
    }

    public ServicoOfertaPK(Servico servico, Usuario usuarioOfertante) {
        this.servico = servico;
        this.usuarioOfertante = usuarioOfertante;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Usuario getUsuarioOfertante() {
        return usuarioOfertante;
    }

    public void setUsuarioOfertante(Usuario usuarioOfertante) {
        this.usuarioOfertante = usuarioOfertante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicoOfertaPK that = (ServicoOfertaPK) o;
        return Objects.equals(servico, that.servico) &&
                Objects.equals(usuarioOfertante, that.usuarioOfertante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(servico, usuarioOfertante);
    }
}

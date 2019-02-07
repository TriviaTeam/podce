package br.com.podce.adm.jpa.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Victor Alexsander
 *
 */
@Entity
@Table(name = "avaliacao_servico", schema = "podce")
public class AvaliacaoServicoOferta implements Serializable{
	private static final long serialVersionUID = -4104168036322050909L;

	@EmbeddedId
	private AvaliacaoServicoOfertaPK id;

	@Column(name = "valor_ava")
	private BigDecimal valorAvaliacao;

	@Column(name = "valor_servico")
	private String descricaoAvaliacao;


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AvaliacaoServicoOferta that = (AvaliacaoServicoOferta) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}

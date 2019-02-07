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
@Table(name = "servico_oferta", schema = "podce")
public class ServicoOferta implements Serializable{
	private static final long serialVersionUID = -4104168036322050909L;

	@EmbeddedId
	private ServicoOfertaPK id;

	@Column(name = "titulo")
	private String descricaoOferta;

	@Column(name = "dataCadastro", columnDefinition = "date default current_date")
	private LocalDate dataCadastro;

	@Column(name = "valor_servico")
	private BigDecimal valor;

	public ServicoOfertaPK getId() {
		return id;
	}

	public void setId(ServicoOfertaPK id) {
		this.id = id;
	}

	public String getDescricaoOferta() {
		return descricaoOferta;
	}

	public void setDescricaoOferta(String descricaoOferta) {
		this.descricaoOferta = descricaoOferta;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ServicoOferta that = (ServicoOferta) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}

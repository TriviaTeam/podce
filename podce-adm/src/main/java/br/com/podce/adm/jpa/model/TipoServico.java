package br.com.podce.adm.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Victor Alexsander
 *
 */
@Entity
@Table(name = "tipo_servico", schema = "podce")
public class TipoServico implements Serializable{
	private static final long serialVersionUID = -4104168036322050909L;

	@Id
	@Column(name = "id_tipo_servico")
	@GeneratedValue(generator = "sq_id_tipo_servico", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sq_id_tipo_servico", sequenceName = "sq_id_tipo_servico", allocationSize = 1)
	private Integer id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "descricao_servico")
	private String descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TipoServico that = (TipoServico) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}

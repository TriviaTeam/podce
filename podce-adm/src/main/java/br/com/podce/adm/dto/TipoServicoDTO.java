package br.com.podce.adm.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Victor Alexsander
 *
 */
public class TipoServicoDTO implements Serializable{
	private static final long serialVersionUID = -4104168036322050909L;
	private Integer id;
	private String nome;
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
		TipoServicoDTO that = (TipoServicoDTO) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}

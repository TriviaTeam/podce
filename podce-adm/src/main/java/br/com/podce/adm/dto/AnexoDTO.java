package br.com.podce.adm.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * 
 * @author Victor Alexsander
 *
 */
public class AnexoDTO implements Serializable {
	private static final long serialVersionUID = 1978253229617657146L;
	private Integer id;
	private String nome;
	private byte[] data;

	public AnexoDTO() {
		super();
	}

	public AnexoDTO(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

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

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AnexoDTO anexoDTO = (AnexoDTO) o;
		return Objects.equals(id, anexoDTO.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}

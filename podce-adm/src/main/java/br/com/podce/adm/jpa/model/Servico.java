package br.com.podce.adm.jpa.model;

import br.com.podce.adm.dto.ServicoDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Victor Alexsander
 *
 */
@Entity
@Table(name = "servico", schema = "podce")
public class Servico implements Serializable{
	private static final long serialVersionUID = -4104168036322050909L;

	@Id
	@Column(name = "id_servico")
	@GeneratedValue(generator = "sq_id_servico", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sq_id_servico", sequenceName = "sq_id_servico", allocationSize = 1)
	private Integer id;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "dataCadastro", columnDefinition = "date default current_date")
	private LocalDate dataCadastro;

	@Column(name = "data_inicio")
	private LocalDate dataInicio;

	@Column(name = "data_fim")
	private LocalDate dataFim;

	@ManyToOne
	@JoinColumn(name="id_usuario_criador")
	private Usuario usuarioCriado;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "servico_tipo_servico",joinColumns = @JoinColumn(name = "id_servico"),inverseJoinColumns = @JoinColumn(name = "id_tipo_servico"))
	private List<TipoServico> listaServicos;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "servico_anexo",joinColumns={@JoinColumn(name="id_servico")},inverseJoinColumns={ @JoinColumn(name="id_anexo")})
	private List<Anexo> anexos;

	/*public Servico(ServicoDTO servicoDTO) {
		this.titulo = servicoDTO.getTitulo();
		this.descricao = servicoDTO.getDescricao();
		this.dataCadastro = servicoDTO.getDataCadastro();
		this.dataInicio = servicoDTO.getDataInicio();
		this.dataFim = servicoDTO.getDataFim();
		this.usuarioCriado = new Usuario();
		this.listaServicos = new ArrayList<>();
		this.anexos = new ArrayList<>();
	}*/

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

	public Usuario getUsuarioCriado() {
		return usuarioCriado;
	}

	public void setUsuarioCriado(Usuario usuarioCriado) {
		this.usuarioCriado = usuarioCriado;
	}

	public List<TipoServico> getListaServicos() {
		return listaServicos;
	}

	public void setListaServicos(List<TipoServico> listaServicos) {
		this.listaServicos = listaServicos;
	}

	public List<Anexo> getAnexos() {
		return anexos;
	}

	public void setAnexos(List<Anexo> anexos) {
		this.anexos = anexos;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Servico that = (Servico) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}

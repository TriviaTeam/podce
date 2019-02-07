package br.com.podce.adm.jpa.model;

import br.com.podce.adm.jpa.domain.SexoEnum;
import br.com.podce.adm.jpa.domain.TipoCadastroEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Victor Alexsander
 *
 */
@Entity
@Table(name = "usuario", schema = "podce")
public class Usuario implements Serializable{
	private static final long serialVersionUID = -4104168036322050909L;

	@Id
	@Column(name = "id_usuario")
	@GeneratedValue(generator = "sq_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sq_id", sequenceName = "sq_id", allocationSize = 1)
	private Integer id;

	@Column(name = "nome_usuario", length = 255)
	private String nomeUsuario;

	@Column(name = "num_cpf", length = 11)
	private String cpf;

	@Column(name = "login_rede")
	private String loginRede;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_cadastro")
	private TipoCadastroEnum tipoCadastro;

	@Column(name = "data_nasc")
	private LocalDate dataNascimento;

	@Column(name = "num_telefone")
	private String telefone;

	@Column(name = "sexo")
	@Enumerated(EnumType.STRING)
	private SexoEnum sexo;

	@Column(name = "email")
	private String email;

	@Column(name = "senha")
	private String senha;

	@Column(name = "data_cadastro", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime dataCadastro;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_expertises",joinColumns = @JoinColumn(name = "id_usuario"),inverseJoinColumns = @JoinColumn(name = "id_tipo_servico"))
	private List<TipoServico> listaServicos;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLoginRede() {
		return loginRede;
	}

	public void setLoginRede(String loginRede) {
		this.loginRede = loginRede;
	}

	public TipoCadastroEnum getTipoCadastro() {
		return tipoCadastro;
	}

	public void setTipoCadastro(TipoCadastroEnum tipoCadastro) {
		this.tipoCadastro = tipoCadastro;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public SexoEnum getSexo() {
		return sexo;
	}

	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public List<TipoServico> getListaServicos() {
		return listaServicos;
	}

	public void setListaServicos(List<TipoServico> listaServicos) {
		this.listaServicos = listaServicos;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Usuario that = (Usuario) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}

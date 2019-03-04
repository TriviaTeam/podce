package br.com.podce.adm.parse;

import br.com.podce.adm.dto.ServicoDTO;
import br.com.podce.adm.jpa.model.Servico;

import java.time.LocalDate;
import java.util.stream.Collectors;

public class ServicoParser extends Parser<ServicoDTO, Servico> {

	private static ServicoParser instancia;

	private ServicoParser() {
		super();
	}

	public static ServicoParser get() {
		if (instancia == null) {
			instancia = new ServicoParser();
		}
		return instancia;
	}

	@Override
	protected ServicoDTO parserDTO(Servico entidade) {
		ServicoDTO dto = new ServicoDTO();
		dto.setTitulo(entidade.getTitulo());
		dto.setId(entidade.getId());
		dto.setDataCadastro(entidade.getDataCadastro() != null ? dto.getDataCadastro() : LocalDate.now());
		dto.setDescricao(entidade.getDescricao());
		dto.setDataFim(entidade.getDataFim());
		dto.setDataInicio(entidade.getDataInicio());
		//dto.setListaServicos(entidade.getListaServicos().stream().map(ts -> TipoServicoParser.get().parserEntidade(ts)).collect(Collectors.toList()));
		//dto.setUsuarioCriado(); TODO usuarioCriado e TipoServicoParser
		dto.setAnexos(entidade.getAnexos().stream().map(ane -> AnexoParser.get().parserDTO(ane)).collect(Collectors.toList()));
		return dto;
	}

	@Override
	protected Servico parserEntidade(ServicoDTO dto) {
		Servico entidade = new Servico();
		entidade.setId(dto.getId());
		entidade.setDataFim(dto.getDataFim());
		entidade.setDataInicio(dto.getDataInicio());
		entidade.setDataCadastro(dto.getDataCadastro() != null ? dto.getDataCadastro() : LocalDate.now());
		entidade.setDescricao(dto.getDescricao());
		entidade.setTitulo(dto.getTitulo());
		//entidade.setUsuarioCriado(); TODO usuarioCriado e TipoServicoParser
		//entidade.setListaServicos(dto.getListaServicos().stream().map(ts -> TipoServicoParser.get().parserEntidade(ts)).collect(Collectors.toList()));
		entidade.setAnexos(dto.getAnexos().stream().map(ane -> AnexoParser.get().parserEntidade(ane)).collect(Collectors.toList()));
		return entidade;
	}

}

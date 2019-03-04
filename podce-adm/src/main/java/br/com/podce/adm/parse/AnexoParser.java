package br.com.podce.adm.parse;

import br.com.podce.adm.dto.AnexoDTO;
import br.com.podce.adm.jpa.model.Anexo;

/**
 *
 * @author Victor Alexsander
 *
 */
public class AnexoParser extends Parser<AnexoDTO, Anexo> {

	public AnexoParser() {
		super();
	}

	private Boolean anexo = Boolean.TRUE;

	public static AnexoParser get() {
		return new AnexoParser();
	}

	@Override
	protected AnexoDTO parserDTO(final Anexo domain) {
		final AnexoDTO dto = new AnexoDTO();
		dto.setId(domain.getId());
		if(this.anexo) {
			dto.setData(domain.getArquivo());
		}
		dto.setNome(domain.getNome());
		return dto;
	}

	@Override
	protected Anexo parserEntidade(final AnexoDTO dto) {
		final Anexo domain = new Anexo();
		domain.setId(dto.getId());
		domain.setArquivo(dto.getData());
		domain.setNome(dto.getNome());
		return domain;
	}

}

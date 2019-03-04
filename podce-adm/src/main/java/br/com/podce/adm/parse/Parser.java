package br.com.podce.adm.parse;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public abstract class Parser<DTO, ENTIDADE> {

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
	
	private ValidatorFactory factory = null;
	private Validator validator = null;
	private Boolean validar = Boolean.FALSE;
	
	private Boolean erros = Boolean.FALSE;
	
	private Set<ConstraintViolation<Object>> constraintViolations;
		
	protected Parser() {
		factory = Validation.byDefaultProvider()
		        .configure()
		        .messageInterpolator(
		                new ResourceBundleMessageInterpolator(
		                        new PlatformResourceBundleLocator( "ValidationMessages" )
		                )
		        )
		        .buildValidatorFactory();
		validator = factory.getValidator();
	}
	
	private void validaObjeto(Object objecto) {
		if(this.validar) {
			constraintViolations = validator.validate( objecto );
			if(constraintViolations!=null && !constraintViolations.isEmpty()) {
				this.erros = Boolean.TRUE;
			}
		}
	}

	public Parser<DTO, ENTIDADE> validar() {
		this.validar = Boolean.TRUE;
		return this;
	}
	
	
	public ENTIDADE paraEntidade(DTO dto) {
		validaObjeto(dto);
		ENTIDADE entidade =  parserEntidade( dto );
		return entidade;
	}

	public DTO paraDTO(ENTIDADE entidade) {
		validaObjeto(entidade);
		DTO dto =  parserDTO( entidade );
		return dto;
	}

	protected abstract DTO   parserDTO(ENTIDADE dto);
	protected abstract ENTIDADE parserEntidade(DTO dto);
}

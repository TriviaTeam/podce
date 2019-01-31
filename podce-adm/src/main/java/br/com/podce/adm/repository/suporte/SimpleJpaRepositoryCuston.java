package br.com.podce.adm.repository.suporte;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class SimpleJpaRepositoryCuston<T, ID> extends SimpleJpaRepository<T, ID> {

	public SimpleJpaRepositoryCuston(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
	}

	/* (non-Javadoc)
	 * @see br.gov.mi.gemeos.gestao.repository.suporte.A#findOne(org.springframework.data.domain.Example)
	 */
	@Override
	public <S extends T> Optional<S> findOne(Example<S> example) {

		try {
			return Optional.of(
					getQuery(new ExampleSpecification<S>(example), example.getProbeType(), Sort.unsorted()).getSingleResult());
		} catch (NoResultException e) {
			return Optional.empty();
		}
	}

	/* (non-Javadoc)
	 * @see br.gov.mi.gemeos.gestao.repository.suporte.A#count(org.springframework.data.domain.Example)
	 */
	@Override
	public <S extends T> long count(Example<S> example) {
		return executeCountQuery(getCountQuery(new ExampleSpecification<S>(example), example.getProbeType()));
	}

	/* (non-Javadoc)
	 * @see br.gov.mi.gemeos.gestao.repository.suporte.A#exists(org.springframework.data.domain.Example)
	 */
	@Override
	public <S extends T> boolean exists(Example<S> example) {
		return !getQuery(new ExampleSpecification<S>(example), example.getProbeType(), Sort.unsorted()).getResultList()
				.isEmpty();
	}

	/* (non-Javadoc)
	 * @see br.gov.mi.gemeos.gestao.repository.suporte.A#findAll(org.springframework.data.domain.Example)
	 */
	@Override
	public <S extends T> List<S> findAll(Example<S> example) {
		return getQuery(new ExampleSpecification<S>(example), example.getProbeType(), Sort.unsorted()).getResultList();
	}

	/* (non-Javadoc)
	 * @see br.gov.mi.gemeos.gestao.repository.suporte.A#findAll(org.springframework.data.domain.Example, org.springframework.data.domain.Sort)
	 */
	@Override
	public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
		return getQuery(new ExampleSpecification<S>(example), example.getProbeType(), sort).getResultList();
	}

	/* (non-Javadoc)
	 * @see br.gov.mi.gemeos.gestao.repository.suporte.A#findAll(org.springframework.data.domain.Example, org.springframework.data.domain.Pageable)
	 */
	@Override
	public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {

		ExampleSpecification<S> spec = new ExampleSpecification<>(example);
		Class<S> probeType = example.getProbeType();
		TypedQuery<S> query = getQuery(new ExampleSpecification<>(example), probeType, pageable);

		return isUnpaged(pageable) ? new PageImpl<>(query.getResultList()) : readPage(query, probeType, pageable, spec);
	}
	
	private static Long executeCountQuery(TypedQuery<Long> query) {

		Assert.notNull(query, "TypedQuery must not be null!");

		List<Long> totals = query.getResultList();
		Long total = 0L;

		for (Long element : totals) {
			total += element == null ? 0 : element;
		}

		return total;
	}
	
	private static boolean isUnpaged(Pageable pageable) {
		return pageable.isUnpaged();
	}

	private static class ExampleSpecification<T> implements Specification<T> {
		
		private final Example<T> example;
		
		/**
		 * Creates new {@link ExampleSpecification}.
		 *
		 * @param example
		 */
		ExampleSpecification(Example<T> example) {
			
			Assert.notNull(example, "Example must not be null!");
			this.example = example;
		}
		
		/*
		 * (non-Javadoc)
		 * @see org.springframework.data.jpa.domain.Specification#toPredicate(javax.persistence.criteria.Root, javax.persistence.criteria.CriteriaQuery, javax.persistence.criteria.CriteriaBuilder)
		 */
		@Override
		public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
			return QueryByExamplePredicateBuilderCustom.getPredicate(root, cb, example);
		}
	}
}


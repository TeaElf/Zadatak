package zadatak.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;

import zadatak.domain.Predmet;
import zadatak.domain.QPredmet;

public interface PredmetDao extends JpaRepository<Predmet, Long>, QuerydslPredicateExecutor<Predmet>  , QuerydslBinderCustomizer<QPredmet> {

	List<Predmet> findAll(Predicate predicate);
	
	@Override
	default void customize(QuerydslBindings bindings, QPredmet root) {
		bindings.bind(String.class)
				.first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
	}
}

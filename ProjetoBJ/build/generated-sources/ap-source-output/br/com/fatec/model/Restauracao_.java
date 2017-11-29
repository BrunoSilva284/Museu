package br.com.fatec.model;

import br.com.fatec.enums.StatusRestauracao;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Restauracao.class)
public abstract class Restauracao_ {

	public static volatile SingularAttribute<Restauracao, Obra> obra;
	public static volatile SingularAttribute<Restauracao, Integer> codigo;
	public static volatile SingularAttribute<Restauracao, Calendar> dataFim;
	public static volatile SingularAttribute<Restauracao, Double> valor;
	public static volatile SingularAttribute<Restauracao, Calendar> dataInicio;
	public static volatile SingularAttribute<Restauracao, Restaurador> restaurador;
	public static volatile SingularAttribute<Restauracao, StatusRestauracao> status;

}


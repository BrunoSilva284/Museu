package br.com.fatec.model;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Exposicao.class)
public abstract class Exposicao_ {

	public static volatile SingularAttribute<Exposicao, Integer> codigo;
	public static volatile SingularAttribute<Exposicao, String> tipo;
	public static volatile SingularAttribute<Exposicao, Calendar> dataFim;
	public static volatile SingularAttribute<Exposicao, String> nome;
	public static volatile SingularAttribute<Exposicao, Calendar> dataInicio;
	public static volatile SetAttribute<Exposicao, Obra> obras;

}


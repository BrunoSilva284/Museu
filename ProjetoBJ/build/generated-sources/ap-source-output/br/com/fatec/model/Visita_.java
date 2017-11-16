package br.com.fatec.model;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Visita.class)
public abstract class Visita_ {

	public static volatile SingularAttribute<Visita, Double> valorEntrada;
	public static volatile SingularAttribute<Visita, Integer> codigo;
	public static volatile SingularAttribute<Visita, Long> idCartao;
	public static volatile SingularAttribute<Visita, Calendar> dataHoraSaida;
	public static volatile SingularAttribute<Visita, Calendar> dataHoraEntrada;
	public static volatile SingularAttribute<Visita, Visitante> visitante;

}


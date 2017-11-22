package br.com.fatec.model;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Obra.class)
public abstract class Obra_ {

	public static volatile SingularAttribute<Obra, Integer> codigo;
	public static volatile SingularAttribute<Obra, String> localProducao;
	public static volatile SingularAttribute<Obra, String> nome;
	public static volatile SingularAttribute<Obra, TipoObraEnum> classificacao;
	public static volatile SingularAttribute<Obra, Calendar> dataCriacao;
	public static volatile SingularAttribute<Obra, String> caminhoImg;
	public static volatile SingularAttribute<Obra, String> autor;
	public static volatile SingularAttribute<Obra, String> descricao;
	public static volatile SingularAttribute<Obra, StatusObraEnum> status;
	public static volatile SingularAttribute<Obra, Exposicao> exposicao;

}


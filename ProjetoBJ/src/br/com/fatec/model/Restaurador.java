package br.com.fatec.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author bruno.a.da.silva
 */
public class Restaurador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cracha;
    private String nome;
}

package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity // définit une entité jpa
@Table(name = "tbl_personne") // optionnel, si pas spécifié prend le nom de l'entité
public class Person
{
	@Column(name = "nom") // si pas spécifié prend le nom du champ
	private String nom;

	@Column(name = "prenom") // si pas spécifié prend le nom du champ
	private String prenom;

	@GeneratedValue
	@Id
	private Long id;

	public Person()
	{
	}

	@Override
	public String toString()
	{
		return "Person [nom=" + nom + ", prenom=" + prenom + ", id=" + id + "]";
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getPrenom()	
	{
		return prenom;
	}

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}
}
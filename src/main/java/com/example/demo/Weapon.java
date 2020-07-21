package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name="Weapon")
public class Weapon {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String damage;
	@ManyToOne
	@JoinColumn(name="playerid")
	private PlCard plcard;
	public Weapon() {
		super();
	}
	public Weapon(String name, String damage, PlCard player) {
		this.name = name;this.damage = damage;this.plcard = player;
	}
	public Weapon(String name, String damage) {
		this.name = name;this.damage = damage;
	}
	public Weapon(String data, PlCard player) {
		this.name = data.split("-")[0];
		this.damage = data.split("-")[1];
		this.plcard = player;
	}
	public long getId() {return id;}
	public String getName() {return name;}
	public String getDamage() {return damage;}
	public PlCard getPlcard() {return plcard;}
}

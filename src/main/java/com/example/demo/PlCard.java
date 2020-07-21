package com.example.demo;

import java.util.*;

import javax.persistence.*;
@Entity// 说明这是一个和数据库表映射的实体类
@Table(name = "plcard")
public class PlCard {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private int STR;
	private int CON;
	private int SIZ;
	private int DEX;
	private int APP;
	private int INT;
	private int POW;
	private int EDU;
	private int LUC;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "plcard")
	private List<Weapon> weapons;
	public PlCard() {
		super();
	}
	public PlCard(long id, String name, int STR, int CON, int SIZ, int APP, int INT, int POW,
			int EDU, int LUC) {
		this.id = id;this.name = name;
		this.STR =STR;this.CON = CON;this.SIZ = SIZ;
		this.APP = APP;this.INT = INT;this.POW = POW;
		this.EDU = EDU;this.LUC = LUC;
	}
	public PlCard(PlCardCache plc) {
		this.STR = plc.str;this.CON = plc.con;this.SIZ = plc.siz;this.DEX = plc.dex;
		this.APP = plc.app;this.INT = plc.imt;this.POW = plc.pow;
		this.EDU = plc.edu;this.LUC = plc.luc;
	}
	public long getId() {
		return id;
	}
	public int getSTR() {
		return STR;
	}
	public int getCON() {
		return CON;
	}
	public int getSIZ() {
		return SIZ;
	}
	public int getDEX() {
		return DEX;
	}
	public int getAPP() {
		return APP;
	}
	public int getINT() {
		return INT;
	}
	public int getPOW() {
		return POW;
	}
	public int getEDU() {
		return EDU;
	}
	public int getLUC() {
		return LUC;
	}

}

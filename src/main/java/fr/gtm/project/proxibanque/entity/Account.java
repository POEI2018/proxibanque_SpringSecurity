package fr.gtm.project.proxibanque.entity;

import java.time.LocalDate;

public class Account implements Entity {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String type;
	private String number;
	private String label;
	private LocalDate openedOn;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public LocalDate getOpenedOn() {
		return openedOn;
	}

	public void setOpenedOn(LocalDate openedOn) {
		this.openedOn = openedOn;
	}

}

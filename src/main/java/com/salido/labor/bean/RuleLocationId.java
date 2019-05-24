package com.salido.labor.bean;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class RuleLocationId implements Serializable {
	private static final long serialVersionUID = 1L;
	private LaborRule laborRule;
	private LaborLocation laborLocation;

	@ManyToOne(cascade = CascadeType.ALL)
	public LaborRule getLaborRule() {
		return laborRule;
	}

	public void setLaborRule(LaborRule laborRule) {
		this.laborRule = laborRule;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	public LaborLocation getLaborLocation() {
		return laborLocation;
	}

	public void setLaborLocation(LaborLocation laborLocation) {
		this.laborLocation = laborLocation;
	}

	private void writeObject(ObjectOutputStream stream) throws IOException {
		stream.defaultWriteObject();
	}

	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
		stream.defaultReadObject();
	}
}

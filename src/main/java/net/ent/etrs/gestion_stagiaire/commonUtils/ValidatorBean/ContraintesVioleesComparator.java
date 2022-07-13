package net.ent.etrs.gestion_stagiaire.commonUtils.ValidatorBean;

import javax.validation.ConstraintViolation;
import java.util.Comparator;

public class ContraintesVioleesComparator implements Comparator<ConstraintViolation<Object>> {

	@Override
	public int compare(ConstraintViolation<Object> o1, ConstraintViolation<Object> o2) {
		return o1.getPropertyPath().toString().compareTo(o2.getPropertyPath().toString());
	}

}

package com.salido.labor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class LaborLocationCustomDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Object> getAppliedRules(final String orgId, final String brandId, final String locationId) {
		StringBuilder query = new StringBuilder();

		query.append(
				"SELECT lr.rule_id, lr.name,rule_tag, description,start_date, end_date,status from labor_rule lr ");
		query.append("inner join labor_rule_location lrl on lrl.rule_id = lr.rule_id ");
		query.append("WHERE lrl.org_id='" + orgId + "' ");

		if (StringUtils.isNotBlank(brandId)) {
			query.append("AND lrl.brand_id='" + brandId + "' ");
		}
		if (StringUtils.isNotBlank(locationId)) {
			query.append("AND lrl.location_id='" + locationId + "' ");
		}

		query.append("ORDER BY start_date ");

		Query q = em.createNativeQuery(query.toString());
		List<Object> result = q.getResultList();
		return result;
	}

	public List<Object> listAllRules(final String orgId, final String brandId, final String locationId) {
		StringBuilder query = new StringBuilder();

		query.append(" SELECT name, rule_tag, description, lr.rule_id, ll.location_id, start_date, end_date ");
		query.append(" from labor_rule lr ");
		query.append(" LEFT JOIN labor_rule_location lrl on lrl.rule_id = lr.rule_id AND lrl.org_id=? ");
		query.append(" AND lrl.brand_id=? AND lrl.location_id=? ");
		query.append(" LEFT JOIN labor_location ll on lrl.location_id = ll.location_id ");
		query.append(" ORDER BY lr.rule_id ");

		Query q = em.createNativeQuery(query.toString());
		q.setParameter(1, orgId);
		q.setParameter(2, brandId);
		q.setParameter(3, locationId);

		@SuppressWarnings("unchecked")
		List<Object> result = q.getResultList();
		return result;

	}

}

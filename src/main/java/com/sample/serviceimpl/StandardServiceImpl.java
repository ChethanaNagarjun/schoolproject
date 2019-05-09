package com.sample.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.dao.StandardDao;
import com.sample.model.Standard;
import com.sample.modelmapper.StandardDetail;
import com.sample.service.StandardService;

@Service
@Transactional

public class StandardServiceImpl implements StandardService {

	@Autowired
	private StandardDao standardDao;

	@Override
	public UUID save(StandardDetail standardDetail) throws Throwable {
		UUID id = null;
		try {
			id = standardDao.save(parseStandardDetailToStandard(standardDetail));
		} catch (Throwable throwable) {
			throw new Throwable(throwable.getMessage());
		}
		return id;

	}

	private Standard parseStandardDetailToStandard(StandardDetail standardDetail) {
		Standard standard = new Standard();
		if (standardDetail.getId() != null) {
			standard.setId(standardDetail.getId());
		}

		if (standardDetail.getName() != null) {
			standard.setName(standardDetail.getName());
		}
		return standard;
	}

	private StandardDetail parseStandardToStandardDetail(Standard standard)

	{
		StandardDetail standardDetail = new StandardDetail();
		if (standard.getId() != null) {
			standardDetail.setId(standard.getId());
		}

		if (standard.getName() != null) {
			standardDetail.setName(standard.getName());
		}
		return standardDetail;
	}

	@Override
	public void delete(UUID id) throws Throwable {
		Standard standard = standardDao.getById(id);
		standardDao.delete(standard);

	}

	@Override
	public void update(UUID id,String name) throws Throwable {
		Standard standard = standardDao.getById(id);
		standard.setName(name);
		standardDao.update(standard);

	}

	@Override
	public List<StandardDetail> getAllStandards() throws Throwable {
		List<Standard> standardList = standardDao.getAll();
		List<StandardDetail> standardDetailList = new ArrayList<StandardDetail>();

		for (Standard standard : standardList) {
			standardDetailList.add(parseStandardToStandardDetail(standard));
		}
		return standardDetailList;

	}
}

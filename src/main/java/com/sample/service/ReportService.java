package com.sample.service;

import java.util.List;
import java.util.UUID;

import com.sample.modelmapper.ReportDetail;

public interface ReportService {

	public UUID save(ReportDetail reportdetail) throws Throwable;

	public void delete(UUID reportdetail) throws Throwable;

	public void update(UUID reportdetail,String reportStatus) throws Throwable;

	public List<ReportDetail> getAllReports() throws Throwable;

}

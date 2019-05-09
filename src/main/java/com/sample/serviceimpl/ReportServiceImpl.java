package com.sample.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.dao.ReportDao;
import com.sample.model.Report;
import com.sample.model.Student;
import com.sample.modelmapper.ReportDetail;
import com.sample.service.ReportService;

@Transactional
@Service

public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportDao reportDao;

	@Override
	public UUID save(ReportDetail reportDetail) throws Throwable {
		UUID id = null;
		try {
			id = reportDao.save(parseReportDetailToReport(reportDetail));
		} catch (Throwable throwable) {
			throw new Throwable(throwable.getMessage());
		}
		return id;

	}

	private Report parseReportDetailToReport(ReportDetail reportDetail) {
		Report report = new Report();
		if (reportDetail.getId() != null) {
			report.setId(reportDetail.getId());
		}

		if (reportDetail.getReportStatus() != null) {
			report.setReportStatus(reportDetail.getReportStatus());
		}
 
		if(reportDetail.getStudentId() != null) {
			Student student = new Student(UUID.fromString(reportDetail.getStudentId()));
			report.setFkeystudentreport(student);
		}
			
		return report;
	}

	private ReportDetail parseReportToReportDetail(Report report) {
		ReportDetail reportDetail = new ReportDetail();
		if (report.getId() != null) {
			reportDetail.setId(report.getId());
		}

		if (report.getReportStatus() != null) {
			reportDetail.setReportStatus(report.getReportStatus());
		}

		return reportDetail;
	}

	@Override
	public void delete(UUID id) throws Throwable {
         Report report = reportDao.getById(id);
        		 reportDao.delete(report);
	}

	@Override
	public void update(UUID id,String reportStatus ) throws Throwable {
		Report report= reportDao.getById(id);
		report.setReportStatus(reportStatus);
		reportDao.update(report);

	}

	@Override
	public List<ReportDetail> getAllReports() throws Throwable {
		List<Report> reportList = reportDao.getAll();
		List<ReportDetail> reportDetailList = new ArrayList<ReportDetail>();

		for (Report report : reportList) {
			reportDetailList.add(parseReportToReportDetail(report));
		}
		return reportDetailList;
	}

}

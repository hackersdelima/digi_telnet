package com.docmgmt.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.docmgmt.app.entity.UserCompanyDetail;
import com.docmgmt.app.exception.ProductNotfoundException;
import com.docmgmt.app.exception.ValidationErrorException;
import com.docmgmt.app.message.HttpResponses;
import com.docmgmt.app.message.Messages;
import com.docmgmt.app.repo.UserCompanyDetailRepo;
import com.docmgmt.app.service.CrudReturnService;

@RestController
@RequestMapping("company")
public class UserCompanyDetailController {

	@Autowired
	UserCompanyDetailRepo userCompanyDetailRepo;

	@Autowired
	CrudReturnService<UserCompanyDetail> crudReturnService;

	// UI connection
	@GetMapping(path = "/create-page")
	public ModelAndView createpage() {
		ModelAndView model = new ModelAndView("company/create");
		model.addObject("pagetitle", "COMPANY");
		return model;
	}

	@GetMapping(path = "/view-page")
	public ModelAndView viewpage() {
		ModelAndView model = new ModelAndView("company/view");
		model.addObject("pagetitle", "COMPANY");
		return model;
	}

	@GetMapping(path = "/")
	public ResponseEntity<?> read() {
		List<UserCompanyDetail> list = userCompanyDetailRepo.findAll();

		ResponseEntity<?> returntype = crudReturnService.controllerReturnForList(list);
		return returntype;
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Messages> read(@PathVariable int id) {
		try {
			UserCompanyDetail userCompanyDetail = userCompanyDetailRepo.findById(id).get();
			if (userCompanyDetail != null) {
				return new ResponseEntity<Messages>(HttpResponses.fetched(userCompanyDetail), HttpStatus.OK);
			}
		} catch (Exception e) {
		}
		return new ResponseEntity<Messages>(HttpResponses.notfound(), HttpStatus.NOT_FOUND);

	}

	@PostMapping
	public ResponseEntity<Messages> create(@Validated @RequestBody UserCompanyDetail detail,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ValidationErrorException(bindingResult);
		} else {
			UserCompanyDetail userCompanyDetail = userCompanyDetailRepo.save(detail);

			ResponseEntity<Messages> returntype = crudReturnService.updateReturn(userCompanyDetail);
			return returntype;
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Messages> delete(@PathVariable int id) {
		try {
			if (id > 1) {
				UserCompanyDetail userCompanyDetail = userCompanyDetailRepo.findById(id).get();
				if (userCompanyDetail == null) {
					throw new ProductNotfoundException();
				} else {
					userCompanyDetailRepo.deleteById(id);

					return new ResponseEntity<Messages>(HttpResponses.received(), HttpStatus.ACCEPTED);
				}
			}

		} catch (Exception e) {
		}
		throw new ProductNotfoundException();

	}

	// saving excel files
	@PostMapping("/import")
	public String mapReapExcelDatatoDB(@RequestParam("file") MultipartFile reapExcelDataFile) throws IOException {

		List<UserCompanyDetail> tempCompanyList = new ArrayList<UserCompanyDetail>();

		XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
		XSSFSheet worksheet = workbook.getSheetAt(0);

		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			UserCompanyDetail tempCompany = new UserCompanyDetail();

			XSSFRow row = worksheet.getRow(i);

			tempCompany.setName(row.getCell(0).getStringCellValue());
			tempCompany.setAddress(row.getCell(1).getStringCellValue());
			tempCompany.setPoBoxNumber(row.getCell(2).getNumericCellValue());
			tempCompany.setPhoneNumber(row.getCell(3).getNumericCellValue());
			tempCompanyList.add(tempCompany);
		}
		List<UserCompanyDetail> status=userCompanyDetailRepo.saveAll(tempCompanyList);
		workbook.close();
		if(status.size()>0)
			return "Data Upload Successful!";
		
		
		return "Data Upload Failed!";
	}

}

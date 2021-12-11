/**
 * 
 */
/**
 * @author s727953
 *
 */
package com.jsfspring.curddemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsfspring.curddemo.entity.EmployeeDTO;
import com.jsfspring.curddemo.repositry.EmployeeRepo;
import com.jsfspring.curddemo.service.EmployeeService;
import com.jsfspring.curddemo.uito.EmployeeUITO;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepo employeeRepo;

	@Override
	@Transactional(readOnly = false)
	public EmployeeUITO doSaveEmp(EmployeeUITO employeeUiTO) {
		EmployeeDTO dto = UiToToDto(employeeUiTO);
		dto = employeeRepo.save(dto);
		BeanUtils.copyProperties(dto, employeeUiTO);

		return employeeUiTO;
	}

	private EmployeeDTO UiToToDto(EmployeeUITO employeeUiTO) {
		EmployeeDTO dto = new EmployeeDTO();
		BeanUtils.copyProperties(employeeUiTO, dto);
		List<EmployeeDTO> lst = new ArrayList<>();
		lst.add(dto);
		return dto;
	}

	@Override
	public List<EmployeeUITO> doFetchAllEmp() {
		List<EmployeeDTO> dtoLst = employeeRepo.findAll();
		List<EmployeeUITO> uiTOLst = new ArrayList<>();
		dtoLst.forEach(dto -> {
			EmployeeUITO tmpUiTO = new EmployeeUITO();
			BeanUtils.copyProperties(dto, tmpUiTO);

			uiTOLst.add(tmpUiTO);
		});
		return uiTOLst;
	}

	@Override
	public EmployeeUITO doGetEmp(EmployeeUITO employeeUiTO) {
		if (null != employeeUiTO.getDescription()) {
			EmployeeDTO dto = new EmployeeDTO();

			BeanUtils.copyProperties(employeeUiTO, dto);
			dto = employeeRepo.getOne(dto.getShoeId());

			BeanUtils.copyProperties(dto, employeeUiTO);
		}
		return employeeUiTO;
	}

	@Override
	@Transactional
	public void doDeleteEmp(EmployeeUITO employeeUiTO) {
		employeeRepo.deleteById(employeeUiTO.getShoeId());
	}

}
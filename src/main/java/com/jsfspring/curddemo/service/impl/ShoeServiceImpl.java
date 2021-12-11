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

import com.jsfspring.curddemo.entity.ShoeDTO;
import com.jsfspring.curddemo.uito.ShoeUITO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsfspring.curddemo.repositry.ShoeRepo;
import com.jsfspring.curddemo.service.ShoeService;

@Service
@Transactional
public class ShoeServiceImpl implements ShoeService {
	@Autowired
	ShoeRepo shoeRepo;

	@Override
	@Transactional(readOnly = false)
	public ShoeUITO doSaveShoe(ShoeUITO shoeUiTO) {
		ShoeDTO dto = UiToToDto(shoeUiTO);
		dto = shoeRepo.save(dto);
		BeanUtils.copyProperties(dto, shoeUiTO);

		return shoeUiTO;
	}

	private ShoeDTO UiToToDto(ShoeUITO shoeUiTO) {
		ShoeDTO dto = new ShoeDTO();
		BeanUtils.copyProperties(shoeUiTO, dto);
		List<ShoeDTO> lst = new ArrayList<>();
		lst.add(dto);
		return dto;
	}

	@Override
	public List<ShoeUITO> doFetchAllShoe() {
		List<ShoeDTO> dtoLst = shoeRepo.findAll();
		List<ShoeUITO> uiTOLst = new ArrayList<>();
		dtoLst.forEach(dto -> {
			ShoeUITO tmpUiTO = new ShoeUITO();
			BeanUtils.copyProperties(dto, tmpUiTO);

			uiTOLst.add(tmpUiTO);
		});
		return uiTOLst;
	}

	@Override
	public ShoeUITO doGetShoe(ShoeUITO shoeUiTO) {
		if (null != shoeUiTO.getDescription()) {
			ShoeDTO dto = new ShoeDTO();

			BeanUtils.copyProperties(shoeUiTO, dto);
			dto = shoeRepo.getOne(dto.getShoeId());

			BeanUtils.copyProperties(dto, shoeUiTO);
		}
		return shoeUiTO;
	}

	@Override
	@Transactional
	public void doDeleteShoe(ShoeUITO shoeUiTO) {
		shoeRepo.deleteById(shoeUiTO.getShoeId());
	}

}
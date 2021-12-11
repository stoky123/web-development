
package com.jsfspring.curddemo.service;

import java.util.List;

import com.jsfspring.curddemo.uito.ShoeUITO;

public interface ShoeService {
	ShoeUITO doSaveShoe(ShoeUITO shoeUiTO);

	List<ShoeUITO> doFetchAllShoe();

	ShoeUITO doGetShoe(ShoeUITO shoeUiTO);

	void doDeleteShoe(ShoeUITO shoeUiTO);
}
/**
 * 
 */
/**
 * @author s727953
 *
 */
package com.jsfspring.curddemo.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import com.jsfspring.curddemo.uito.ShoeUITO;
import org.primefaces.context.RequestContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import com.jsfspring.curddemo.service.ShoeService;

@Controller("shoeController")
@SessionScope
public class ShoeController {
	@Autowired
	private ShoeService shoeService;

	private String actionLabel;
	private ShoeUITO shoeUiTO;
	private List<ShoeUITO> shoeUiToList;


	/**
	 * add or update new Record in DB
	 * 
	 * @return
	 */
	public void doSaveInfoShoe() {
		shoeService.doSaveShoe(this.getShoeUiTO());
		getAllShoe();
		this.setShoeUiTO(new ShoeUITO());
		RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Shoe Details", "Shoe Details added/Updated Successfully."));

	}

	/**
	 * Default load all the Shoe info
	 */
	@PostConstruct
	public void getAllShoe() {
		if (!this.getShoeUiToList().isEmpty()) {
			this.getShoeUiToList().clear();
		}
		System.out.println(" >>>>>>>>>>>>> " + shoeService);
		this.getShoeUiToList().addAll(shoeService.doFetchAllShoe());
		this.setActionLabel("Add");
	}

	/**
	 * Remove selected Shoe info
	 * 
	 * @return
	 */

	public void deleteShoe(ShoeUITO shoeUiTO) {
		shoeService.doDeleteShoe(shoeUiTO);
		getAllShoe();
	}

	public void editShoe(ShoeUITO shoeUiTO) {
		this.setActionLabel("Update");
		BeanUtils.copyProperties(shoeUiTO, this.getShoeUiTO());
		System.out.println(this.getShoeUiTO());
	}

	public ShoeUITO getShoeUiTO() {
		if (shoeUiTO == null) {
			shoeUiTO = new ShoeUITO();
		}
		return shoeUiTO;
	}

	public void setShoeUiTO(ShoeUITO shoeUiTO) {
		this.shoeUiTO = shoeUiTO;
	}

	public List<ShoeUITO> getShoeUiToList() {
		if (null == shoeUiToList) {
			shoeUiToList = new ArrayList<>();
		}
		return shoeUiToList;
	}

	public String getActionLabel() {
		return actionLabel;
	}

	public void setActionLabel(String actionLabel) {
		this.actionLabel = actionLabel;
	}

}
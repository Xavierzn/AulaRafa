package PagBean;



import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@SuppressWarnings("serial")
@Named
@ApplicationScoped

public class PagiBeans implements  Serializable {
	
	private String page;

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	
	public String go_to(){
		if("a".equals(page)) {
			return "pag_a";
		}else if("b".equals(page)) {
			return "pag_b";
		}else {
			return null;
		}
			
	}
}
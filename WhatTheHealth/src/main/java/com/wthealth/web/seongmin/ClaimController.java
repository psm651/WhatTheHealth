package com.wthealth.web.seongmin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.wthealth.common.Page;
import com.wthealth.common.Search;
import com.wthealth.domain.Claim;
import com.wthealth.service.claim.ClaimService;


//==> ȸ������ Controller
@Controller
@RequestMapping("/product/*")
public class ClaimController {
	
	///Field
	@Autowired
	@Qualifier("claimServiceImpl")
	private ClaimService claimService;
	//setter Method ���� ����
		
	public ClaimController(){
		System.out.println(this.getClass());
	}
	
	//==> classpath:config/common.properties  ,  classpath:config/commonservice.xml ���� �Ұ�
	//==> �Ʒ��� �ΰ��� �ּ��� Ǯ�� �ǹ̸� Ȯ�� �Ұ�
	@Value("#{commonProperties['pageUnit']}")
	//@Value("#{commonProperties['pageUnit'] ?: 3}")
	int pageUnit;
	
	@Value("#{commonProperties['pageSize']}")
	//@Value("#{commonProperties['pageSize'] ?: 2}")
	int pageSize;
	
	
	@RequestMapping(value="addClaim", method = RequestMethod.GET)
	public String addClaim() throws Exception {

		System.out.println("/addClaim : GET");
	
		
		return "redirect:/claim/addClaim.jsp";
	}
	
	@RequestMapping(value="addClaim", method = RequestMethod.POST)
	public String addClaim( @ModelAttribute("claim") Claim claim ) throws Exception {

		
		System.out.println("/addClaim : POST");
		//Business Logic
		
		claimService.addClaim(claim);
		//���� �����ϴ°�
		return "forward:/product/addProductConform.jsp";
	}
	/*
	@RequestMapping(value="getProduct", method = RequestMethod.GET)
	public String getProduct( @RequestParam("prodNo") int prodNo ,@CookieValue(value="history", required=false) String history, HttpServletResponse response, Model model ) throws Exception {
		
		System.out.println("/product/getProduct : GET");
		//Business Logic
		Product product = productService.getProduct(prodNo);
		List<Product> map=new ArrayList<Product>();
		if (history==null || history.length()==0) {
			history = prodNo+"";
		}else {
			if (history.indexOf(prodNo+"")==-1) {
				history = prodNo+","+history;
			}			
			
		}
		
		Cookie cookie= new Cookie("history", history);
		cookie.setPath("/");
		response.addCookie(cookie);
		
		
		String[] h =history.split(",");
		
		for (int i = 0; i < h.length; i++) {
			
				
				Product cookieProduct=productService.getProduct(Integer.parseInt(h[i]));
			
				map.add(productService.getProduct(Integer.parseInt(h[i])));
			
		}
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@�̰Ը��̴�"+map);
		
		
		// Model �� View ����
		model.addAttribute("product", product);
		model.addAttribute("map", map);
		
		return "forward:/product/getProduct.jsp";
	}
	*/
	/*@RequestMapping(value="updateClaim", method=RequestMethod.GET)
	public String updateProduct( @RequestParam("claimNo") int claimNo , Model model ) throws Exception{

		System.out.println("/product/updateProduct : GET");
		//Business Logic
		Product product = productService.getProduct(prodNo);
		// Model �� View ����
		model.addAttribute("product", product);
		
		return "forward:/product/updateProductView.jsp";
	}
	
	@RequestMapping(value="updateProduct", method=RequestMethod.POST)
	public String updateProduct( @ModelAttribute("product") Product product , Model model) throws Exception{

		System.out.println("/product/updateProduct : GET");
		//Business Logic
		
		productService.updateProduct(product);
		
	
		return "redirect:/product/getProduct?prodNo="+product.getProdNo()+"&menu=manage";
	}
	
	@RequestMapping(value="listProduct")
	public String listProduct( @ModelAttribute("search") Search search ,@CookieValue(value="history") String history, Model model , HttpServletResponse response, HttpServletRequest request) throws Exception{
		
		System.out.println("/product/listProduct : GET / POST23423423432");
		
		if(search.getCurrentPage() ==0 ){
			search.setCurrentPage(1);
		}
	
		search.setPageSize(pageSize);
		search.setOrder(search.getOrder());
		List<Product> list=new ArrayList<Product>();
		// Business logic ����
		Map<String , Object> map=productService.getProductList(search);
		
		Page resultPage = new Page( search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		System.out.println(resultPage);
		
		Cookie cookie= new Cookie("history", history);
		cookie.setPath("/");
		response.addCookie(cookie);
		
	if (history!="" ) {
		
	
		String[] h =history.split(",");
		
		for (int i = 0; i < h.length; i++) {
			
				
				Product cookieProduct=productService.getProduct(Integer.parseInt(h[i]));
			
			list.add(productService.getProduct(Integer.parseInt(h[i])));
			
		}
		model.addAttribute("cookieList", list);
	}

		// Model �� View ����
		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);
		
	
		
		return "forward:/product/listProduct.jsp";
	}*/
}
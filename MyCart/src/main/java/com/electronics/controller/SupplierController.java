package com.electronics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.electronics.model.Supplier;
import com.electronics.service.SupplierService;

@Controller
public class SupplierController
{
	@Autowired
	SupplierService supplierService;

	@RequestMapping("/supplier")
	public String getSupplierPage(Model model) 
	{
		model.addAttribute("supplierList", supplierService.getAllSuppliers());
		model.addAttribute("supplier", new Supplier());
		//model.addAttribute("btnLabel", "Add");

		return "supplierPage";
	}

	@RequestMapping("/editsupplier-{supplierId}")
	public String editSupplier(@PathVariable("supplierId") int supplierId, Model model) 
	{
		model.addAttribute("supplierList", supplierService.getAllSuppliers());
		model.addAttribute("supplier", supplierService.getSupplierById(supplierId));
		//model.addAttribute("btnLabel", "Update");

		return "supplierPage";
	}

	@RequestMapping("/addsupplier")
	public String addSupplier(@ModelAttribute("supplier") Supplier supplier) 
	{
		supplierService.addSupplier(supplier);
		return "redirect:/supplier";
	}

	@RequestMapping("/deletesupplier-{supplierId}")
	public String deleteSupplier(@PathVariable("supplierId") int supplierId)
	{
		supplierService.deleteSupplier(supplierId);
		return "redirect:/supplier";
	}

	
}



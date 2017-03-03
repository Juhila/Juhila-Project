package com.electronics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.electronics.model.Supplier;
import com.electronics.service.SupplierService;

public class SupplierController
{
	@Autowired
	SupplierService supplierService;

	@RequestMapping("/supplier")
	public String getSupplier(Model model) 
	{
		model.addAttribute("supplierList", supplierService.getAllSuppliers());
		model.addAttribute("supplier", new Supplier());
		//model.addAttribute("btnLabel", "Add");

		return "supplierPage";
	}

	@RequestMapping("/editsupplier-{supplierId}")
	public String updateSupplier(@PathVariable("supplierId") int supplierId, Model model) 
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

	@RequestMapping("/supplierenabled-{supplierId}")
	public String activeToggleSupplier(@PathVariable("supplierId") int supplierId) 
	{

		Supplier supplier = supplierService.getSupplierById(supplierId);
		
		if ((supplier.getIsSupplierEnabled()).equalsIgnoreCase("yes")) 
		{
			supplier.setIsSupplierEnabled("yes");
		} 
		else 
		{
			supplier.setIsSupplierEnabled("no");
		}
		
		supplierService.addSupplier(supplier);
		
		return "redirect:/supplier";
	}
}


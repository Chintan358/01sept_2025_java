package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepo;
import com.example.demo.service.ProductService;

@Controller
public class ProductController {

    private final ProductRepo productRepo;
	
	@Autowired
	ProductService productService;

    ProductController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
	
	@GetMapping("/")
	public String index(Model model)
	{
		model.addAttribute("product", new Product());
		model.addAttribute("products",productService.products());
		return "index";
	}
	
	@PostMapping("/addproduct")
	public String addProduct(@ModelAttribute("product") Product pro)
	{	
		System.out.println(pro);
		productService.addOrUpdateProduct(pro);
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("id") int id)
	{
		productService.deleteProduct(id);
		return "redirect:/";
	}
	
	@GetMapping("/edit")
	public String editProdct(@RequestParam("id") int id,Model model)
	{
		model.addAttribute("product", productService.product(id));
		model.addAttribute("products",productService.products());
		return "index";
	}
}

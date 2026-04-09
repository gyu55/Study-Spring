package com.app.threetier.controller;

import com.app.threetier.domain.vo.ProductVO;
import com.app.threetier.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/products/*")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/product")
    public void goToList(Model model){
        model.addAttribute("products", productService.getProducts());
    }

    @GetMapping("/write")
    public void goToWrite(Model model){
        model.addAttribute("product", new ProductVO());
    }

    @PostMapping("/write-ok")
    public RedirectView writeOk(ProductVO productVO){
        productService.addProduct(productVO);
        return new RedirectView("/products/product");
    }

}

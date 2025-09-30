package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import poly.edu.model.Product;

import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {

    // ?1 → sản phẩm mặc định, tự động thêm vào model mọi request
    @ModelAttribute("p1")
    public Product defaultProduct() {
        Product p = new Product();
        p.setName("iPhone 30");
        p.setPrice(5000.0);
        return p;
    }

    // ?3 → danh sách sản phẩm
    @ModelAttribute("items")
    public List<Product> getItems() {
        return Arrays.asList(
            new Product("A", 1.0),
            new Product("B", 12.0)
        );
    }

    @GetMapping("/product/form")
    public String form(Model model) {
        // tạo p2 để bind form
        model.addAttribute("p2", new Product());
        return "poly/product_form";
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute("p2") Product p, Model model) {
        // p2 đã tự động bind với form
        return "poly/product_form";
    }
}

package vn.hoidanit.laptopshop.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.service.ProductService;
import vn.hoidanit.laptopshop.service.UploadService;

@Controller
public class ProductController {

    private final ProductService productService;
    private final UploadService uploadService;

    public ProductController(ProductService productService, UploadService uploadService) {
        this.productService = productService;
        this.uploadService = uploadService;
    }

    @GetMapping("/admin/product")
    public String getProductPage(Model model) {
        List<Product> prs = this.productService.getAllProduct();
        model.addAttribute("prs", prs);
        return "admin/product/show";
    }

    // create product
    @GetMapping("/admin/product/create")
    public String getProductCreatePage(Model model) {
        model.addAttribute("newProduct", new Product());
        return "admin/product/create";
    }

    @PostMapping("/admin/product/create")
    public String getProductCreate(Model model, @ModelAttribute("newProduct") @Valid Product pr,
            BindingResult newProductBindingResult,
            @RequestParam("hoidanitFile") MultipartFile File) {
        // xử lý valid
        if (newProductBindingResult.hasErrors()) {
            return "admin/product/create";
        }

        List<FieldError> errors = newProductBindingResult.getFieldErrors();
        for (FieldError error : errors) {
            System.out.println(">>>>>>>>>>" + error.getField() + "-" + error.getDefaultMessage());
        }
        
        String image = this.uploadService.handleSaveUploadFile(File, "product");
        pr.setImage(image);

        this.productService.handleSaveProduct(pr);
        return "redirect:/admin/product";
    }
}

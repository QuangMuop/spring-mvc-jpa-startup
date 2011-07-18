package com.springjpa.web;

import com.springjpa.domain.Product;
import com.springjpa.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Main entry point for all person related REST calls.
 *
 * @author Ceren Akkan
 */
@Controller
public class ProductController {

    @Resource(name = "productService")
    private ProductService productService;

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ModelAndView create(@RequestBody Product product) {
        Product result = productService.create(product);
        ModelAndView model = new ModelAndView("product");
        model.addObject("product", result);
        return model;
    }

    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    @ResponseBody
    public void update(@RequestBody Product product) {
        productService.update(product);
    }

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    public ModelAndView get(@PathVariable Long productId) {
        final Product product = productService.get(productId);
        ModelAndView model = new ModelAndView("product");
        model.addObject("product", product);
        return model;
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ModelAndView get() {
        final List<Product> result = productService.get();
        ModelAndView model = new ModelAndView("productList");
        model.addObject("productList", result);
        return model;
    }

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long productId) {
        productService.delete(productId);
    }

    /**
     * Sets the product service
     *
     * @param productService
     */
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

}

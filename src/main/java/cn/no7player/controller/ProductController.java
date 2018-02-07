package cn.no7player.controller;

import cn.no7player.model.Product;
import cn.no7player.model.User;
import cn.no7player.service.ProductService;
import cn.no7player.service.UserService;
import com.wordnik.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ethan on 2018/2/06.
 */
@Slf4j
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "Get product list", notes = "nothing requried")
    @RequestMapping(value="/getProductInfo/{userBalance}", method=RequestMethod.POST)
    @ResponseBody
    public List<Product> getUserInfo(@RequestParam BigDecimal userBalance) {
        List<Product> productList = productService.getProductInfo();
        List<Product> userProductList = new ArrayList<>();

        log.info("productList.size:{}", productList.size());
        if ((productList == null&&productList.size()>0) || userBalance == null) {
            return userProductList;
        } else {
            if (userBalance.compareTo(new BigDecimal("500000")) >= 0) {
                userProductList = findUserProductList(productList, new BigDecimal("500000"));
            } else if (userBalance.compareTo(new BigDecimal("200000")) >= 0) {
                userProductList = findUserProductList(productList, new BigDecimal("200000"));
            } else if (userBalance.compareTo(new BigDecimal("100000")) >= 0) {
                userProductList = findUserProductList(productList, new BigDecimal("100000"));
            } else {
                userProductList = findUserProductList(productList, new BigDecimal("2000"));
            }

        }
        return userProductList;
    }

    private List<Product> findUserProductList(List<Product> productList, BigDecimal bigDecimal) {
        List<Product> userList= new ArrayList<Product>();
        log.info("traget price:{}",bigDecimal);
        for (Product product : productList) {
            if (product.getPrice().compareTo(bigDecimal)<=0) {
                log.info(" add product.getPrice:{}",product.getPrice());
                userList.add(product);
            }
        }

        return userList;
    }
}

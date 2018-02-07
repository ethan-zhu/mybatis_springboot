package cn.no7player.service;

import cn.no7player.mapper.ProductMapper;
import cn.no7player.mapper.UserMapper;
import cn.no7player.model.Product;
import cn.no7player.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ethan on 2015/8/27.
 */
@Slf4j
@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public List<Product> getProductInfo(){
        List<Product> productList=productMapper.getProductList();
        log.info("product:{}",productList);
        //User user=null;
        return productList;
    }
}

package com.gfa.deploytoazure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  private ProductRepository repo;

  @Autowired
  public MyController(ProductRepository repo) {
    this.repo = repo;
  }

  @RequestMapping(path = "/products", method = RequestMethod.GET)
  public ResponseEntity<Iterable<Product>> displayProducts(Model model){
    return ResponseEntity.ok().body(repo.findAll());
  }

  @RequestMapping(path = "/add", method = RequestMethod.GET)
  public String addProduct(){
    repo.save(new Product("P1", 3, 500));
    return "Saved";
  }

  @RequestMapping(path = "/clear", method = RequestMethod.GET)
  public String deleteProducts(){
    repo.deleteAll();
    return "Deleted all";
  }
}

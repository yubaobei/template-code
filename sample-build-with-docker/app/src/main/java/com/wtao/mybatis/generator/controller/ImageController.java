package com.wtao.mybatis.generator.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wtao.mybatis.generator.entity.Image;
import com.wtao.mybatis.generator.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2023-06-13
 */
@RestController
@RequestMapping("/image")
public class ImageController {


    @Autowired
    private ImageService imageService;

    @GetMapping(value = "")
    public ResponseEntity<Page<Image>> list(@RequestParam(required = false) Integer current, @RequestParam(required = false) Integer pageSize) {
        if (current == null) {
            current = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        Page<Image> aPage = imageService.page(new Page<>(current, pageSize));
        return new ResponseEntity<>(aPage, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Image> getById(@PathVariable("id") String id) {
        return new ResponseEntity<>(imageService.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> create(@RequestBody Image params) {
        imageService.save(params);
        return new ResponseEntity<>("created successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        imageService.removeById(id);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Object> update(@RequestBody Image params) {
        imageService.updateById(params);
        return new ResponseEntity<>("updated successfully", HttpStatus.OK);
    }
}

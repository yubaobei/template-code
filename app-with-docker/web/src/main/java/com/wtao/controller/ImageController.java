package com.wtao.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wtao.entity.Image;
import com.wtao.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
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
    public Image getById(@PathVariable("id") String id) {
        return imageService.getById(id);
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

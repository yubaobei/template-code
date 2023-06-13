package com.wtao.mybatis.generator.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wtao.mybatis.generator.entity.Instance;
import com.wtao.mybatis.generator.service.InstanceService;
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
@RequestMapping("/instance")
public class InstanceController {


    @Autowired
    private InstanceService instanceService;

    @GetMapping(value = "")
    public ResponseEntity<Page<Instance>> list(@RequestParam(required = false) Integer current, @RequestParam(required = false) Integer pageSize) {
        if (current == null) {
            current = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        Page<Instance> aPage = instanceService.page(new Page<>(current, pageSize));
        return new ResponseEntity<>(aPage, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Instance> getById(@PathVariable("id") String id) {
        return new ResponseEntity<>(instanceService.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> create(@RequestBody Instance params) {
        instanceService.save(params);
        return new ResponseEntity<>("created successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        instanceService.removeById(id);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Object> update(@RequestBody Instance params) {
        instanceService.updateById(params);
        return new ResponseEntity<>("updated successfully", HttpStatus.OK);
    }
}

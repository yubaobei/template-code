package com.wtao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wtao.entity.Image;
import com.wtao.mapper.ImageMapper;
import com.wtao.service.ImageService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author
 * @since 2023-06-13
 */
@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image> implements ImageService {

}
package com.wtao;

import com.github.davidfantasy.mybatisplus.generatorui.GeneratorConfig;
import com.github.davidfantasy.mybatisplus.generatorui.MybatisPlusToolsApplication;
import com.github.davidfantasy.mybatisplus.generatorui.mbp.NameConverter;

public class GeneratoryUiServer {
    public static void main(String[] args) {
        GeneratorConfig config = GeneratorConfig.builder()
                .jdbcUrl("jdbc:mysql://172.19.103.2:3306/cloud_desk?serverTimeZone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=false")
                .userName("cloud_desk_dbu").password("admin312").driverClassName("com.mysql.jdbc.Driver")
                .nameConverter(new NameConverter() {
                    @Override
                    public String serviceNameConvert(String entityName) {
                        return entityName + "Service";
                    }

                    @Override
                    public String controllerNameConvert(String entityName) {
                        return entityName + "Controller";
                    }
                })
                .basePackage("com.wtao.mybatis.generator").port(8068).build();

        MybatisPlusToolsApplication.run(config);
    }
}

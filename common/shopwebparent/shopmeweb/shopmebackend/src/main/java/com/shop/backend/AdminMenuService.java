package com.shop.backend;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import tools.jackson.databind.json.JsonMapper;

@Service 
public class AdminMenuService {

        private final JsonMapper jsonMapper;

        private static final Logger logger =
        LoggerFactory.getLogger(AdminMenuService.class);

    public AdminMenuService(JsonMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    public List<MenuItem> getAdminMenu() {

        var resource = new ClassPathResource("admin-menu.json");

        try (InputStream input = resource.getInputStream()) {

            String json = new String(
                input.readAllBytes(),
                StandardCharsets.UTF_8
            );

            MenuItem[] items =
                jsonMapper.readValue(json, MenuItem[].class);

            logger.info("Admin menu loaded successfully");

            return List.of(items);

        } catch (IOException e) {
            logger.error("Cannot read admin-menu.json", e);
            return List.of();
        }
    }
}

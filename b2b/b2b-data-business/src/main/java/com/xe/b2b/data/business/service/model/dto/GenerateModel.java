package com.xe.b2b.data.business.service.model.dto;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.xe.b2b.data.access.model.BaseEntity;

public class GenerateModel {

    public static void initBaseInfo(BaseEntity entity) {
        if (entity == null) {
            return;
        }
        if (entity.getCreated() == null) {
            entity.setCreated(new Date());
        }

        if (StringUtils.isBlank(entity.getCreatedBy())) {
            entity.setCreatedBy("system");
        }

        if (StringUtils.isBlank(entity.getUpdatedBy())) {
            entity.setUpdatedBy("system");
        }
    }
}

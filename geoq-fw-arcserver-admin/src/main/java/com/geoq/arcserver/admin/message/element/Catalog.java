package com.geoq.arcserver.admin.message.element;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catalog {
    private double currentVersion;
    private List<String> folders;
    private List<Service> services;
}

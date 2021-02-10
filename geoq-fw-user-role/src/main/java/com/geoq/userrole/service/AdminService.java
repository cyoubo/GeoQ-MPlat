package com.geoq.userrole.service;

import java.util.Map;

public interface AdminService {

    Map<String,Object> query_role_right_code(String uuid);

    boolean login(String name, String password, Map<String, Object> result);
}

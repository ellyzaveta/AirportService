package com.airportService.backend.services;

import redis.clients.jedis.Response;
import com.airportService.backend.models.Role;

public interface UserService {
    public void set(Role role, String password);
    public Response<String> getPassword(Role role);
    public void delete(Role role);
}

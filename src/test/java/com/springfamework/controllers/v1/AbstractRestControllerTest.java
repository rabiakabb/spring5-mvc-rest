package com.springfamework.controllers.v1;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by RK
 */
public abstract class AbstractRestControllerTest {

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

package com.blasttask.web;

import java.util.Map;

import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

public class CustomJsonView  extends MappingJackson2JsonView{

	protected Object filterModel(Map<String, Object> model) {    
        Map<?, ?> result = (Map<?, ?>) super.filterModel(model);    
        if (result.size() == 1) {    
            return result.values().iterator().next();    
        } else {    
            return result;    
        }    
    }    
}

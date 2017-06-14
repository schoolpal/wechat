package com.github.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.db.inf.TMarketTrackingMapper;
import com.github.db.model.TMarketTracking;

@Controller
public class AdditionalController{

    protected Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private TMarketTrackingMapper mtMapper;
    
    @RequestMapping(value = "marketTracking", method = RequestMethod.GET)
    public String getUserInfo(HttpServletRequest request, HttpServletResponse response, String aId, String cId) {
    	        
        do{
            this.logger.info(request.getRequestURL().toString());
            
            if(StringUtils.isEmpty(cId) || StringUtils.isEmpty(aId)){
            	break;
            }

	        TMarketTracking record = new TMarketTracking();
	        record.setActivityId(aId);
	        record.setChannel(cId);
	        record.setRawUrl(request.getRequestURL().toString() + "?" + request.getQueryString());
	        try{
	        	mtMapper.insertSelective(record);
	        }catch(Exception e){
	            this.logger.error(e.toString());
	        }
        }while(false);
        
        return "redirect:http://www.baidu.com";
    }


}

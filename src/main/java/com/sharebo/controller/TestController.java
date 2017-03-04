package com.sharebo.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sharebo.entity.ResultInfo;
/**
 * @author Administrator
 */
@Controller
@RequestMapping("/test")
public class TestController {
	/**
	 * test/gettest.do
	 * @param
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value="gettest",method=RequestMethod.POST)
    public ResultInfo getselettest(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("parkid",1);
		map.put("parkprice",1);
		map.put("parkType",1);
		return null;
	}
}

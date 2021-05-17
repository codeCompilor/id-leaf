package com.lqy.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lqy.Result;
import com.sankuai.inf.leaf.common.Status;
import com.sankuai.inf.leaf.service.SegmentService;
import com.sankuai.inf.leaf.service.SnowflakeService;

@RestController
@RequestMapping("/leaf")
public class IdController {

	//segment号段模式ID
	@Autowired
	private SegmentService segmentService;
	
	//雪花算法ID
    @Autowired
    private SnowflakeService snowflakeService; 
	
	@RequestMapping("/snowflake")
	public Result getSnowflakeId() {
		
		//获取snowflake分布式ID
		////id  这个参数是没有意义的，只是为了和号段模式的接口统一，所以要传一个参数，自己随意定义一个
		com.sankuai.inf.leaf.common.Result r =  snowflakeService.getId("id");
		
		//判断是否成功，成功返回具体的id，不成功返回错误提示
		if(r.getStatus() == Status.SUCCESS) {
			return Result.ok(r.getId());
		}
		
		return Result.failMsg("获取snowflake分布式ID失败");
	}
	
	
	@RequestMapping("/segment/{segmentTag}")
	public Result getSegmentId(@PathVariable("segmentTag") String segmentTag) {
		
		//获取snowflake分布式ID
		com.sankuai.inf.leaf.common.Result r =  segmentService.getId(segmentTag);
		
		//判断是否成功，成功返回具体的id，不成功返回错误提示
		if(r.getStatus() == Status.SUCCESS) {
			return Result.ok(r.getId());
		}
		
		return Result.failMsg("获取snowflake分布式ID失败");
	}
	
	
	
}

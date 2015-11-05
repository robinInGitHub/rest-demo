package com.cdel.rest.web.util;

import java.util.Date;

/**
 * @ClassName: RunningTime
 * @Description: TODO(计算程序运行时间，创建类初始化开始时间，getTime方法得到运行时间)
 * @author yangzhenping
 * @date 2015年11月4日 下午3:14:37
 *
 */ 
public class RunningTime {
	
	private Date startTime = new Date();
	private Date endTime;
	
	public RunningTime(){
		if(this.startTime == null){
			this.startTime = new Date();
		}
	}
	
	/**
	 * @Title: getTime
	 * @Description: TODO(得到运行时间ms)
	 * @param @return
	 * @return long
	 * @throws
	 */ 
	public long getTime(){
		return this.getEndTime().getTime()-this.startTime.getTime();
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		if(endTime == null){
			setEndTime(new Date());
		}
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	
}

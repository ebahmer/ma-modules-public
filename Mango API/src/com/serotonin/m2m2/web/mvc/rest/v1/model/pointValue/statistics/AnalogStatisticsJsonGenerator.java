/**
 * Copyright (C) 2014 Infinite Automation Software. All rights reserved.
 * @author Terry Packer
 */
package com.serotonin.m2m2.web.mvc.rest.v1.model.pointValue.statistics;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.serotonin.m2m2.view.stats.AnalogStatistics;
import com.serotonin.m2m2.vo.DataPointVO;

/**
 * @author Terry Packer
 *
 */
public class AnalogStatisticsJsonGenerator extends StatisticsJsonGenerator{

	private AnalogStatistics statistics;
	
	/**
	 * 
	 * @param host
	 * @param port
	 * @param jgen
	 * @param vo
	 * @param useRendered
	 * @param unitConversion
	 * @param generator
	 * @param dateTimeFormat - format for String dates or null for timestamp numbers
	 * @param timezone
	 */
	public AnalogStatisticsJsonGenerator(String host, int port, JsonGenerator jgen,
			DataPointVO vo, boolean useRendered, boolean unitConversion, AnalogStatistics generator, String dateTimeFormat, String timezone) {
		super(host, port, jgen, vo, useRendered, unitConversion, generator, dateTimeFormat, timezone);
		this.statistics = generator;
	}

	/* (non-Javadoc)
	 * @see com.serotonin.m2m2.web.mvc.rest.v1.model.pointValue.statistics.StatisticsJsonGenerator#writeStatistics()
	 */
	@Override
	public void done() throws IOException {
		this.generator.done();

		if(this.statistics.getFirstValue() != null || this.statistics.getStartValue() != null){
			this.jgen.writeBooleanField("hasData", true);
			
			if(this.statistics.getFirstValue() != null) {
    			this.jgen.writeFieldName("first");
    			this.writeNonNullDouble(this.statistics.getFirstValue(), this.statistics.getFirstTime(), this.vo);
    			
    			this.jgen.writeFieldName("last");
    			this.writeNonNullDouble(this.statistics.getLastValue(), this.statistics.getLastTime(), this.vo);
    			
    			if(this.statistics.getStartValue() != null) {
    			    this.jgen.writeFieldName("start");
    			    this.writeNonNullDouble(this.statistics.getStartValue(), this.statistics.getPeriodStartTime(), this.vo);
    			} else
    			    this.jgen.writeNullField("start");
			} else { //We must have a start value
			    this.jgen.writeFieldName("start");
			    this.writeNonNullDouble(this.statistics.getStartValue(), this.statistics.getPeriodStartTime(), this.vo);
			    this.jgen.writeNullField("first");
			    this.jgen.writeNullField("last");
			}
			
			this.jgen.writeFieldName("minimum");
			this.writeNonNullDouble(this.statistics.getMinimumValue(), this.statistics.getMinimumTime(), this.vo);
			
			this.jgen.writeFieldName("maximum");
			this.writeNonNullDouble(this.statistics.getMaximumValue(), this.statistics.getMaximumTime(), this.vo);
			
			this.jgen.writeFieldName("average");
			this.writeNonNullDouble(this.statistics.getAverage(), this.statistics.getPeriodEndTime(), this.vo);
			
			this.jgen.writeFieldName("integral");
			this.writeNonNullIntegral(this.statistics.getIntegral(), this.statistics.getPeriodEndTime(), this.vo);
			
			this.jgen.writeFieldName("sum");
			this.writeNonNullDouble(this.statistics.getSum(), this.statistics.getPeriodEndTime(), this.vo);

			this.jgen.writeNumberField("count", this.statistics.getCount());
		}else{
			this.jgen.writeBooleanField("hasData", false);
			this.jgen.writeNullField("first");
			this.jgen.writeNullField("last");
			this.jgen.writeNullField("minimum");
			this.jgen.writeNullField("maximum");
			this.jgen.writeNullField("average");
			this.jgen.writeNullField("integral");
			this.jgen.writeNullField("sum");
			this.jgen.writeNullField("count");
		}
	}

}

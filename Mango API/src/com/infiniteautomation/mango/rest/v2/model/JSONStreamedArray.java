/**
 * Copyright (C) 2017 Infinite Automation Software. All rights reserved.
 */
package com.infiniteautomation.mango.rest.v2.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

/**
 * An array where the values are written out one by one as JSON using Jackson
 * 
 * @author Jared Wiltshire
 */
public interface JSONStreamedArray extends StreamedArray {
    public void writeArrayValues(JsonGenerator jgen) throws IOException;
}

/**
 * Copyright (C) 2017 Infinite Automation Software. All rights reserved.
 *
 */
package com.serotonin.m2m2.reports;

import java.util.List;

import com.serotonin.m2m2.module.PermissionDefinition;

/**
 * 
 * @author Terry Packer
 */
public class ReportPurgeActionPermissionDefinition extends PermissionDefinition{

	public static final String PERMISSION = "action.reportPurge";
	
	/* (non-Javadoc)
	 * @see com.serotonin.m2m2.module.PermissionDefinition#getPermissionKey()
	 */
	@Override
	public String getPermissionKey() {
		return "reports.permission.purge";
	}

	/* (non-Javadoc)
	 * @see com.serotonin.m2m2.module.PermissionDefinition#getPermissionTypeName()
	 */
	@Override
	public String getPermissionTypeName() {
		return PERMISSION;
	}
	
	/* (non-Javadoc)
	 * @see com.serotonin.m2m2.module.PermissionDefinition#getDefaultGroups()
	 */
	@Override
	public List<String> getDefaultGroups() {
		return null;
	}

}

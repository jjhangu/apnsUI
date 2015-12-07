/**
 * Copyright 2009 by HANWHA S&C Corp.,
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of HANWHA S&C Corp. ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with HANWHA S&C Corp.
 */
package com.apns.ui.client;

import org.apache.logging.log4j.Logger;

import com.apns.ui.PnsSender;
import com.apns.ui.log.UILogger;
import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;

/**
 * @author : ddavid
 * @version $Id: APNSNotnoopClient.java,v 1.1.4.2 2015/11/25 19:12:28 gw343 Exp $
 */
public class APNSNotnoopClient {
	
	public static ApnsService apnsService = null;
	
	public static boolean isProduction;
	public static  String certPath;
	public static  String password;
	
	public static ApnsService getInstance(boolean isProduction, String certPath, String password) {
		
		if(APNSNotnoopClient.isProduction != isProduction || APNSNotnoopClient.certPath != certPath || APNSNotnoopClient.password != password){
			System.out.println("reset APNSService");
			if(apnsService != null){
				apnsService.stop();
				apnsService = null;
			}
		}
		
		if(apnsService == null)
		{
			UILogger.getInstance().add("service init ");
			
			APNSNotnoopClient.isProduction = isProduction;
			APNSNotnoopClient.certPath = certPath;
			APNSNotnoopClient.password = password;
			
			if(isProduction){
				apnsService = APNS.newService().asQueued()
					    .withCert(certPath, password)
					    .withProductionDestination()
					    .build();
			}else{
				apnsService = APNS.newService().asQueued()
					    .withCert(certPath, password)
					    .withSandboxDestination()
					    .build();
			}
			
			UILogger.getInstance().add("service created ");
		}
		return apnsService;
	}
}

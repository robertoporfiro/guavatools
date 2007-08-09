/*
 * Copyright © Zurich Employment Services Limited 2007
 * All Rights Reserved
 *
 * Zurich eProposition programme.
 *
 * Created:  17-May-2007 11:29:30
 * Author:   GBEVVH8
 * Project:  ProtectionPostDeployTest
 *
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 */
package com.zurich.ep.protection.alsb.test;

public class NodeDoesNotExistException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NodeDoesNotExistException(String message) {
        super(message);
    }
        
}
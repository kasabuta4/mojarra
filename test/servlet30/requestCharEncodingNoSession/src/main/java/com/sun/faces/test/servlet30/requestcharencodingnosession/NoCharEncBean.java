/*
 * Copyright (c) 2010, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package com.sun.faces.test.servlet30.requestcharencodingnosession;

import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class NoCharEncBean {

    public NoCharEncBean() {
    }

    public String getMessage() {
        String result = "";
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        String extContextCharEnc = extContext.getResponseCharacterEncoding();
        boolean hasSession = null != extContext.getSession(false);
        result = "extContextCharEnc: " + extContextCharEnc + " hasSession: " + hasSession;
        if (hasSession) {
            result = result + " sessionCharEnc: " + extContext.getSessionMap().get(ViewHandler.CHARACTER_ENCODING_KEY);
        }

        if (extContext.getRequestParameterMap().containsKey("makeSession")) {
            extContext.getSession(true);
        }
        if (extContext.getRequestParameterMap().containsKey("invalidateSession")) {
            extContext.invalidateSession();
        }
        
        return result;
    }
    
}

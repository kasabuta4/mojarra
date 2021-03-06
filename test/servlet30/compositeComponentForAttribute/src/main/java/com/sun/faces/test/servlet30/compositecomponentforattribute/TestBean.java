/*
 * Copyright (c) 2017, 2018 Oracle and/or its affiliates. All rights reserved.
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

package com.sun.faces.test.servlet30.compositecomponentforattribute;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "test")
public class TestBean implements Serializable {

    private String forValue = "name";

    public String getForValue() {
        return forValue;
    }

    public void setForValue(String forValue) {
        this.forValue = forValue;
    }

    private String property;

    public void setProperty(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }
}

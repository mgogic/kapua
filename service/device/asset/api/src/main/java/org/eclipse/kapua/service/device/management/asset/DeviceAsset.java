/*******************************************************************************
 * Copyright (c) 2017 Eurotech and/or its affiliates and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.service.device.management.asset;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.eclipse.kapua.service.device.management.asset.xml.DeviceAssetChannelXmlAdapter;

/**
 * Device asset entity definition.<br>
 * This entity is used to get information about assets installed in the device.
 *
 * @since 1.0
 *
 */
@XmlRootElement(name = "deviceAsset")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {//
        "name", //
        "channels" //
}, //
        factoryClass = DeviceAssetXmlRegistry.class, //
        factoryMethod = "newDeviceAsset")
public interface DeviceAsset {

    /**
     * Get the asset name
     *
     * @return
     */
    @XmlElement(name = "name")
    public String getName();

    /**
     * Set the asset name
     *
     * @param name
     */
    public void setName(String name);

    @XmlElementWrapper(name = "channels")
    @XmlElement(name = "channel")
    @XmlJavaTypeAdapter(DeviceAssetChannelXmlAdapter.class)
    public List<DeviceAssetChannel> getChannels();

    public void setChannels(List<DeviceAssetChannel> channels);
}

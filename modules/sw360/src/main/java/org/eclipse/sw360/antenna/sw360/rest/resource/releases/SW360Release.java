/*
 * Copyright (c) Bosch Software Innovations GmbH 2018-2019.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.sw360.antenna.sw360.rest.resource.releases;

import org.eclipse.sw360.antenna.sw360.rest.resource.SW360HalResource;

import java.util.Map;
import java.util.Set;

public class SW360Release extends SW360HalResource<SW360ReleaseLinkObjects, SW360ReleaseEmbedded> {
    private String componentId;
    private String name;
    private String version;
    private String cpeid;
    private String downloadurl;
    private Set<String> mainLicenseIds;
    private Map<String, String> coordinates;
    private Set<String> declaredLicense;
    private Set<String> observedLicense;
    private String releaseTagUrl;
    private String softwareHeritageUrl;
    private Set<String> hashes;
    private String clearingState;
    private String changeStatus;

    private Map<String, String> externalIds;


    public String getComponentId() {
        return componentId;
    }

    public SW360Release setComponentId(String componentId) {
        this.componentId = componentId;
        return this;
    }

    public String getName() {
        return name;
    }

    public SW360Release setName(String name) {
        this.name = name;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public SW360Release setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getCpeid() {
        return cpeid;
    }

    public SW360Release setCpeid(String cpeid) {
        this.cpeid = cpeid;
        return this;
    }

    public Set<String> getMainLicenseIds() {
        return mainLicenseIds;
    }

    public SW360Release setMainLicenseIds(Set<String> mainLicenseIds) {
        this.mainLicenseIds = mainLicenseIds;
        return this;
    }

    public String getDownloadurl() {
        return downloadurl;
    }

    public void setDownloadurl(String downloadurl) {
        this.downloadurl = downloadurl;
    }


    public Map<String, String> getCoordinates() {
        return coordinates;
    }

    public SW360Release setCoordinates(Map<String, String> coordinates) {
        this.coordinates = coordinates;
        return this;
    }

    public Set<String> getDeclaredLicense() {
        return declaredLicense;
    }

    public SW360Release setDeclaredLicense(Set<String> declaredLicense) {
        this.declaredLicense = declaredLicense;
        return this;
    }

    public Set<String> getObservedLicense() {
        return observedLicense;
    }

    public SW360Release setObservedLicense(Set<String> observedLicense) {
        this.observedLicense = observedLicense;
        return this;
    }

    public String getReleaseTagUrl() {
        return releaseTagUrl;
    }

    public SW360Release setReleaseTagUrl(String releaseTagUrl) {
        this.releaseTagUrl = releaseTagUrl;
        return this;
    }

    public String getSoftwareHeritageUrl() {
        return softwareHeritageUrl;
    }

    public SW360Release setSoftwareHeritageUrl(String softwareHeritageUrl) {
        this.softwareHeritageUrl = softwareHeritageUrl;
        return this;
    }

    public Set<String> getHashes() {
        return hashes;
    }

    public SW360Release setHashes(Set<String> hashes) {
        this.hashes = hashes;
        return this;
    }

    public String getClearingState() {
        return clearingState;
    }

    public SW360Release setClearingState(String clearingState) {
        this.clearingState = clearingState;
        return this;
    }

    public String getChangeStatus() {
        return changeStatus;
    }

    public SW360Release setChangeStatus(String changeStatus) {
        this.changeStatus = changeStatus;
        return this;
    }

    public Map<String, String> getExternalIds() {
        return externalIds;
    }

    public SW360Release setExternalIds(Map<String, String> externalIds) {
        this.externalIds = externalIds;
        return this;
    }
}

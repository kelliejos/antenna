/*
 * Copyright (c) Bosch Software Innovations GmbH 2019.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.sw360.antenna.sw360.rest.resource;

import org.eclipse.sw360.antenna.model.artifact.ArtifactFact;
import org.eclipse.sw360.antenna.model.artifact.facts.*;
import org.eclipse.sw360.antenna.sw360.model.artifact.facts.ArtifactChangeStatus;
import org.eclipse.sw360.antenna.sw360.model.artifact.facts.ArtifactClearingState;

import java.util.HashMap;
import java.util.Map;

public class SW360KeysToAntennaClasses {
    private static Map<String, Class<? extends ArtifactFact>> sw360KeysToAntennaClasses = new HashMap<>();

    public static Map<String, Class<? extends ArtifactFact>> getSw360KeysToAntennaClasses() {
        if (sw360KeysToAntennaClasses.isEmpty()) {
            setMap();
        }
        return sw360KeysToAntennaClasses;
    }

    private SW360KeysToAntennaClasses() {
        setMap();
    }
    
    private static void setMap() {
        sw360KeysToAntennaClasses.put(SW360Attributes.RELEASE_CLEARINGSTATE, ArtifactClearingState.class);
        sw360KeysToAntennaClasses.put(SW360Attributes.RELEASE_CPE_ID, ArtifactCPE.class);
        sw360KeysToAntennaClasses.put(SW360Attributes.RELEASE_SOURCES, ArtifactSourceUrl.class);
        sw360KeysToAntennaClasses.put(SW360Attributes.RELEASE_MAIN_LICENSE_IDS, ConfiguredLicenseInformation.class);
        sw360KeysToAntennaClasses.put(SW360Attributes.RELEASE_EXTERNAL_ID_DLICENSES, DeclaredLicenseInformation.class);
        sw360KeysToAntennaClasses.put(SW360Attributes.RELEASE_EXTERNAL_ID_OLICENSES, ObservedLicenseInformation.class);
        sw360KeysToAntennaClasses.put(SW360Attributes.RELEASE_EXTERNAL_ID_OREPO, ArtifactReleaseTagURL.class);
        sw360KeysToAntennaClasses.put(SW360Attributes.RELEASE_EXTERNAL_ID_SWHREPO, ArtifactSoftwareHeritageURL.class);
        sw360KeysToAntennaClasses.put(SW360Attributes.RELEASE_EXTERNAL_ID_HASHES, ArtifactFilename.class);
        sw360KeysToAntennaClasses.put(SW360Attributes.RELEASE_EXTERNAL_ID_CHANGESTATUS, ArtifactChangeStatus.class);
    }
}

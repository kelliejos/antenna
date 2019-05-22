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

import org.eclipse.sw360.antenna.api.exceptions.AntennaExecutionException;
import org.eclipse.sw360.antenna.model.artifact.facts.ArtifactCoordinates;
import org.eclipse.sw360.antenna.model.artifact.facts.dotnet.DotNetCoordinates;
import org.eclipse.sw360.antenna.model.artifact.facts.java.BundleCoordinates;
import org.eclipse.sw360.antenna.model.artifact.facts.java.MavenCoordinates;
import org.eclipse.sw360.antenna.model.artifact.facts.javaScript.JavaScriptCoordinates;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SW360CoordinateKeysToArtifactCoordinates {
    private static Map<Class<? extends ArtifactCoordinates>, String> sw360CoordinateKeysToArtifactCoordinates = new HashMap<>();

    private static void setMap() {
        sw360CoordinateKeysToArtifactCoordinates.put(MavenCoordinates.class, "mvn");
        sw360CoordinateKeysToArtifactCoordinates.put(DotNetCoordinates.class, "dotnet");
        sw360CoordinateKeysToArtifactCoordinates.put(BundleCoordinates.class, "bundles");
        sw360CoordinateKeysToArtifactCoordinates.put(JavaScriptCoordinates.class, "javascript");
    }

    public static String get(Class<? extends ArtifactCoordinates> key) {
        if (sw360CoordinateKeysToArtifactCoordinates.isEmpty()) {
            setMap();
        }
        return sw360CoordinateKeysToArtifactCoordinates.get(key);
    }

    public static Class<? extends ArtifactCoordinates> get(String value) {
        if (sw360CoordinateKeysToArtifactCoordinates.isEmpty()) {
            setMap();
        }
        return sw360CoordinateKeysToArtifactCoordinates.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == value)
                .findFirst()
                .get()
                .getKey();
    }

    public static Set<Class<? extends ArtifactCoordinates>> getKeys() {
        return sw360CoordinateKeysToArtifactCoordinates.keySet();
    }

    public static boolean containsValue(String value) {
        return sw360CoordinateKeysToArtifactCoordinates.containsValue(value);
    }

    public static ArtifactCoordinates createArtifactCoordinates(String group, String name, String version, Class<? extends ArtifactCoordinates> coordinateClass) {
        Constructor<?>[] constructor = coordinateClass.getConstructors();

        try {
            Object object = null;
            if(coordinateClass == MavenCoordinates.class){
                object = constructor[0].newInstance(group, name, version);

            } else if (coordinateClass == DotNetCoordinates.class || coordinateClass == BundleCoordinates.class) {
                object = constructor[0].newInstance(name, version);

            } else if (coordinateClass == JavaScriptCoordinates.class) {
                object = constructor[0].newInstance(name, group, version);

            }
            return (ArtifactCoordinates) object;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new AntennaExecutionException();
        }
    }
}

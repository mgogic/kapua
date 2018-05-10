/*******************************************************************************
 * Copyright (c) 2011, 2018 Eurotech and/or its affiliates and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *     Red Hat Inc
 *******************************************************************************/
package org.eclipse.kapua.commons.util;

import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
//import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Date utilities
 */
public final class KapuaDateUtils {

    private KapuaDateUtils() {
    }

    public static final String ISO_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"; // example 24/01/2017T11:22:10.999Z
    private static final String FORMAT = "dd MMM yyyy HH:mm:ss ZZZZ";
    LocalDateTime now = LocalDateTime.now();
    private static final DateTimeFormatter LOCALTIMEFORMATTER = DateTimeFormatter
            .ofPattern(FORMAT)
            .withLocale(KapuaDateUtils.getLocale())
            .withZone(TimeZone.getDefault().toZoneId());
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter
            .ofPattern(ISO_DATE_PATTERN)
            .withLocale(KapuaDateUtils.getLocale())
            .withZone(getTimeZone());
    /**
     * Get current date
     *
     * @return current date
     */
    public static Instant getKapuaSysDate() {
        return Instant.now();
    }

    public static ZoneId getTimeZone() {
        return ZoneOffset.UTC;
    }

    public static Locale getLocale() {
        return Locale.US;
    }

    /**
     * Parse the provided String using the {@link KapuaDateUtils#ISO_DATE_PATTERN default pattern}
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date parseDate(String date) throws ParseException {
        if (date == null) {
            return null;
        } else {
            return Date.from(Instant.from(FORMATTER.parse(date)));
        }
    }

    /**
     * Format the provided Date using the {@link KapuaDateUtils#ISO_DATE_PATTERN default pattern}
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatDate(Date date) throws ParseException {
        if (date == null) {
            return null;
        } else {
            return FORMATTER.format(date.toInstant());
        }
    }

    // Format date and time in User's current Time Zone
    public static String formatDateTime(Date d) {
        if (d == null) {
            return null;
        }

        return LOCALTIMEFORMATTER.format(d.toInstant());
    }

}

/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.Log;
import com.emarte.regurgitator.core.XmlLoader;
import org.w3c.dom.Element;

import java.util.Set;

import static com.emarte.regurgitator.core.Log.getLog;

public class JsonPrintProcessorXmlLoader implements XmlLoader<JsonPrintProcessor> {
    private static final Log log = getLog(JsonPrintProcessorXmlLoader.class);

    @Override
    public JsonPrintProcessor load(Element element, Set<Object> allIds) {
        log.debug("Loaded json print processor");
        return new JsonPrintProcessor();
    }
}

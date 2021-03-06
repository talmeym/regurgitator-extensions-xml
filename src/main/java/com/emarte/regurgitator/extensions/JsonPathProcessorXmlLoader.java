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

public class JsonPathProcessorXmlLoader implements XmlLoader<JsonPathProcessor> {
    private static final Log log = getLog(JsonPathProcessor.class);

    @Override
    public JsonPathProcessor load(Element element, Set<Object> allIds) {
        log.debug("Loaded json path processor");
        return new JsonPathProcessor(element.getTextContent());
    }
}

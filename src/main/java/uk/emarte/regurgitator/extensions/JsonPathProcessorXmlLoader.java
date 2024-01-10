/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import org.w3c.dom.Element;
import uk.emarte.regurgitator.core.Log;
import uk.emarte.regurgitator.core.XmlLoader;

import java.util.Set;

import static uk.emarte.regurgitator.core.Log.getLog;

public class JsonPathProcessorXmlLoader implements XmlLoader<JsonPathProcessor> {
    private static final Log log = getLog(JsonPathProcessor.class);

    @Override
    public JsonPathProcessor load(Element element, Set<Object> allIds) {
        log.debug("Loaded json path processor");
        return new JsonPathProcessor(element.getTextContent());
    }
}

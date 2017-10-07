/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import org.w3c.dom.Element;

import java.util.Set;

import static com.emarte.regurgitator.core.CoreConfigConstants.*;
import static com.emarte.regurgitator.core.Log.getLog;
import static com.emarte.regurgitator.core.XmlConfigUtil.*;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.NAMESPACES;

public class XmlParameterXmlLoader extends XmlParameterLoader implements XmlLoader<Step> {
    private static final Log log = getLog(XmlParameter.class);
    private static final XpathProcessorXmlLoader XPATH_LOADER = new XpathProcessorXmlLoader();

    @Override
    public Step load(Element element, Set<Object> allIds) throws RegurgitatorException {
        XpathProcessor xpathProcessor = XPATH_LOADER.load(element, allIds);
        String source = getAttribute(element, SOURCE);
        String value = getAttribute(element, VALUE);
        String file = getAttribute(element, FILE);
        ValueProcessor processor = loadOptionalValueProcessor(element, getChildElement(element, NAMESPACES) != null ? 1 : 0, allIds);
        return buildXmlParameter(loadId(element, allIds), loadPrototype(element), loadContext(element), source, value, file, processor, xpathProcessor, log);
    }
}

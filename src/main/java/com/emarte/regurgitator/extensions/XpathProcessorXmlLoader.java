/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.Log;
import com.emarte.regurgitator.core.RegurgitatorException;
import com.emarte.regurgitator.core.XmlLoader;
import org.w3c.dom.Element;

import java.util.Map;
import java.util.Set;

import static com.emarte.regurgitator.core.Log.getLog;
import static com.emarte.regurgitator.core.XmlConfigUtil.getChildElement;
import static com.emarte.regurgitator.core.XmlConfigUtil.loadOptionalStr;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.NAMESPACES;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.XPATH;
import static com.emarte.regurgitator.extensions.XmlNamespaceLoader.loadNamespaces;

public class XpathProcessorXmlLoader implements XmlLoader<XpathProcessor> {
    private static final Log log = getLog(XpathProcessorXmlLoader.class);

    @Override
    public XpathProcessor load(Element element, Set<Object> allIds) throws RegurgitatorException {
        Map<String,String> namespaces = loadNamespaces(getChildElement(element, NAMESPACES), loadOptionalStr(element, NAMESPACES));

        log.debug("Loaded xpath processor");
        return new XpathProcessor(loadOptionalStr(element, XPATH), namespaces);
    }
}

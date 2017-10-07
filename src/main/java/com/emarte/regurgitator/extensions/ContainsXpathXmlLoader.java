/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import org.w3c.dom.Element;

import java.util.*;

import static com.emarte.regurgitator.core.Log.getLog;
import static com.emarte.regurgitator.core.XmlConfigUtil.getAttribute;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.NAMESPACES;
import static com.emarte.regurgitator.extensions.XmlNamespaceLoader.loadNamespaces;

public class ContainsXpathXmlLoader implements XmlLoader<ContainsXpath> {
    private static final Log log = getLog(ContainsXpathXmlLoader.class);

    @Override
    public ContainsXpath load(Element element, Set<Object> allIds) throws RegurgitatorException {
        Map<String,String> namespaces = loadNamespaces(getAttribute(element, NAMESPACES), log);
        log.debug("Loaded contains xpath");
        return new ContainsXpath(namespaces);
    }
}

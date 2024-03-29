/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import org.w3c.dom.Element;
import uk.emarte.regurgitator.core.Log;
import uk.emarte.regurgitator.core.RegurgitatorException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static uk.emarte.regurgitator.core.Log.getLog;
import static uk.emarte.regurgitator.core.XmlConfigUtil.getChildElements;
import static uk.emarte.regurgitator.core.XmlConfigUtil.loadOptionalStr;
import static uk.emarte.regurgitator.extensions.ExtensionsConfigConstants.*;

class XmlNamespaceLoader extends NamespaceLoader {
    private static final Log log = getLog(XmlNamespaceLoader.class);

    static Map<String, String> loadNamespaces(Element element, String attribute) throws RegurgitatorException {
        if(element != null && attribute != null) {
            throw new RegurgitatorException("namespaces cannot be specified twice");
        }

        if(element == null && attribute == null) {
            throw new RegurgitatorException("namespaces not specified");
        }

        return element != null ? loadNamespaces(element) : loadNamespaces(attribute, log);
    }

    private static Map<String, String> loadNamespaces(Element element) {
        Map<String, String> namespaceMap = new HashMap<>();

        List<Element> namespaces = getChildElements(element, NAMESPACE);

        for (Element namespace: namespaces) {
            String prefix = loadOptionalStr(namespace, NAMESPACE_PREFIX);
            String uri = loadOptionalStr(namespace, NAMESPACE_URI);
            namespaceMap.put(prefix, uri);
            log.debug("Loaded namespace '{}={}'", prefix, uri);
        }

        log.debug("Loaded {} namespaces", namespaceMap.size());
        return namespaceMap;
    }
}

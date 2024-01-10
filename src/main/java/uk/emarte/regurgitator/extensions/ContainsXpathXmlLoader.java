/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import org.w3c.dom.Element;
import uk.emarte.regurgitator.core.Log;
import uk.emarte.regurgitator.core.XmlLoader;

import java.util.Map;
import java.util.Set;

import static uk.emarte.regurgitator.core.Log.getLog;
import static uk.emarte.regurgitator.core.XmlConfigUtil.loadOptionalStr;
import static uk.emarte.regurgitator.extensions.ExtensionsConfigConstants.NAMESPACES;
import static uk.emarte.regurgitator.extensions.XmlNamespaceLoader.loadNamespaces;

public class ContainsXpathXmlLoader implements XmlLoader<ContainsXpath> {
    private static final Log log = getLog(ContainsXpathXmlLoader.class);

    @Override
    public ContainsXpath load(Element element, Set<Object> allIds) {
        Map<String,String> namespaces = loadNamespaces(loadOptionalStr(element, NAMESPACES), log);
        log.debug("Loaded contains xpath");
        return new ContainsXpath(namespaces);
    }
}

/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import org.w3c.dom.Element;
import uk.emarte.regurgitator.core.Log;
import uk.emarte.regurgitator.core.RegurgitatorException;
import uk.emarte.regurgitator.core.XmlLoader;

import java.util.Map;
import java.util.Set;

import static uk.emarte.regurgitator.core.Log.getLog;
import static uk.emarte.regurgitator.core.XmlConfigUtil.getOptionalChildElement;
import static uk.emarte.regurgitator.core.XmlConfigUtil.loadOptionalStr;
import static uk.emarte.regurgitator.extensions.ExtensionsConfigConstants.NAMESPACES;
import static uk.emarte.regurgitator.extensions.ExtensionsConfigConstants.XPATH;
import static uk.emarte.regurgitator.extensions.XmlNamespaceLoader.loadNamespaces;

public class XpathProcessorXmlLoader implements XmlLoader<XpathProcessor> {
    private static final Log log = getLog(XpathProcessorXmlLoader.class);

    @Override
    public XpathProcessor load(Element element, Set<Object> allIds) throws RegurgitatorException {
        Map<String,String> namespaces = loadNamespaces(getOptionalChildElement(element, NAMESPACES), loadOptionalStr(element, NAMESPACES));

        log.debug("Loaded xpath processor");
        return new XpathProcessor(loadOptionalStr(element, XPATH), namespaces);
    }
}

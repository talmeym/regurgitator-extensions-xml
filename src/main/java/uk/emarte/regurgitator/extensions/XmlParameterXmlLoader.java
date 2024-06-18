/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import org.w3c.dom.Element;
import uk.emarte.regurgitator.core.*;

import java.util.List;
import java.util.Set;

import static uk.emarte.regurgitator.core.CoreConfigConstants.*;
import static uk.emarte.regurgitator.core.Log.getLog;
import static uk.emarte.regurgitator.core.XmlConfigUtil.*;
import static uk.emarte.regurgitator.extensions.ExtensionsConfigConstants.NAMESPACES;

public class XmlParameterXmlLoader extends XmlParameterLoader implements XmlLoader<Step> {
    private static final Log log = getLog(XmlParameter.class);
    private static final XpathProcessorXmlLoader XPATH_LOADER = new XpathProcessorXmlLoader();

    @Override
    public Step load(Element element, Set<Object> allIds) throws RegurgitatorException {
        XpathProcessor xpathProcessor = XPATH_LOADER.load(element, allIds);
        String source = loadOptionalStr(element, SOURCE);
        String value = loadOptionalStr(element, VALUE);
        String file = loadOptionalStr(element, FILE);
        List<ValueProcessor> processors = loadOptionalValueProcessors(element, getOptionalChildElement(element, NAMESPACES) != null ? 1 : 0, allIds);
        return buildXmlParameter(loadId(element, allIds), loadPrototype(element), loadContext(element), source, value, file, processors, xpathProcessor, loadOptionalBool(element, OPTIONAL), log);
    }
}

/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import org.w3c.dom.Element;
import uk.emarte.regurgitator.core.Log;
import uk.emarte.regurgitator.core.RegurgitatorException;
import uk.emarte.regurgitator.core.ValueProcessor;
import uk.emarte.regurgitator.core.XmlLoader;

import java.util.Set;

import static uk.emarte.regurgitator.core.CoreConfigConstants.FILE;
import static uk.emarte.regurgitator.core.CoreConfigConstants.VALUE;
import static uk.emarte.regurgitator.core.Log.getLog;
import static uk.emarte.regurgitator.core.XmlConfigUtil.loadOptionalStr;

public class FreemarkerProcessorXmlLoader extends FreemarkerProcessorLoader implements XmlLoader<ValueProcessor> {
    private static final Log log = getLog(FreemarkerProcessorXmlLoader.class);

    @Override
    public ValueProcessor load(Element element, Set<Object> allIds) throws RegurgitatorException {
        String valueAttr = loadOptionalStr(element, VALUE);
        String valueText = element.getTextContent();

        if(valid(valueAttr) && valid(valueText)) {
            throw new RegurgitatorException("Value cannot be defined in text and attribute");
        }

        String value = valid(valueAttr) ? valueAttr : valid(valueText) ? valueText : null;
        String file = loadOptionalStr(element, FILE);
        return buildFreemarkerValueProcessor(value, file, log);
    }

    private boolean valid(String text) {
        return text != null && text.length() > 0;
    }
}

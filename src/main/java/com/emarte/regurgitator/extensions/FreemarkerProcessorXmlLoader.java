/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import org.w3c.dom.Element;

import java.util.Set;

import static com.emarte.regurgitator.core.CoreConfigConstants.FILE;
import static com.emarte.regurgitator.core.CoreConfigConstants.VALUE;
import static com.emarte.regurgitator.core.Log.getLog;
import static com.emarte.regurgitator.core.XmlConfigUtil.getAttribute;

public class FreemarkerProcessorXmlLoader extends FreemarkerProcessorLoader implements XmlLoader<ValueProcessor> {
    private static final Log log = getLog(FreemarkerProcessorXmlLoader.class);

    @Override
    public ValueProcessor load(Element element, Set<Object> allIds) throws RegurgitatorException {
        String valueAttr = getAttribute(element, VALUE);
        String valueText = element.getTextContent();

        if(valid(valueAttr) && valid(valueText)) {
            throw new RegurgitatorException("Value cannot be defined in text and attribute");
        }

        String value = valid(valueAttr) ? valueAttr : valid(valueText) ? valueText : null;
        String file = getAttribute(element, FILE);
        return buildFreemarkerValueProcessor(value, file, log);
    }

    private boolean valid(String text) {
        return text != null && text.length() > 0;
    }
}

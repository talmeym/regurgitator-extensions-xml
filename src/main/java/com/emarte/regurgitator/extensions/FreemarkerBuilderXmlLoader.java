/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.Log;
import com.emarte.regurgitator.core.RegurgitatorException;
import com.emarte.regurgitator.core.ValueBuilder;
import com.emarte.regurgitator.core.XmlLoader;
import org.w3c.dom.Element;

import java.util.Set;

import static com.emarte.regurgitator.core.CoreConfigConstants.*;
import static com.emarte.regurgitator.core.Log.getLog;
import static com.emarte.regurgitator.core.XmlConfigUtil.loadOptionalBool;
import static com.emarte.regurgitator.core.XmlConfigUtil.loadOptionalStr;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.ALL_CONTEXTS;

public class FreemarkerBuilderXmlLoader extends FreemarkerBuilderLoader implements XmlLoader<ValueBuilder> {
    private static final Log log = getLog(FreemarkerBuilderXmlLoader.class);

    @Override
    public ValueBuilder load(Element element, Set<Object> allIds) throws RegurgitatorException {
        String source = loadOptionalStr(element, SOURCE);
        String valueAttr = loadOptionalStr(element, VALUE);
        String valueText = element.getTextContent();

        if(valid(valueAttr) && valid(valueText)) {
            throw new RegurgitatorException("Value cannot be defined in text and attribute");
        }

        String value = valid(valueAttr) ? valueAttr : valid(valueText) ? valueText : null;
        String file = loadOptionalStr(element, FILE);
        return buildFreemarkerValueBuilder(source, value, file, loadOptionalBool(element, ALL_CONTEXTS), log);
    }

    private boolean valid(String text) {
        return text != null && text.length() > 0;
    }
}

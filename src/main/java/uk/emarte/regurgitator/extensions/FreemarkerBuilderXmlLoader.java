/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import org.w3c.dom.Element;
import uk.emarte.regurgitator.core.Log;
import uk.emarte.regurgitator.core.RegurgitatorException;
import uk.emarte.regurgitator.core.ValueBuilder;
import uk.emarte.regurgitator.core.XmlLoader;

import java.util.Set;

import static uk.emarte.regurgitator.core.CoreConfigConstants.*;
import static uk.emarte.regurgitator.core.Log.getLog;
import static uk.emarte.regurgitator.core.XmlConfigUtil.loadOptionalBool;
import static uk.emarte.regurgitator.core.XmlConfigUtil.loadOptionalStr;
import static uk.emarte.regurgitator.extensions.ExtensionsConfigConstants.ALL_CONTEXTS;

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

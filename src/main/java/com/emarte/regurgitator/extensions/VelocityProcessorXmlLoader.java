/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.Log;
import com.emarte.regurgitator.core.RegurgitatorException;
import com.emarte.regurgitator.core.ValueProcessor;
import com.emarte.regurgitator.core.XmlLoader;
import org.w3c.dom.Element;

import java.util.Set;

import static com.emarte.regurgitator.core.CoreConfigConstants.FILE;
import static com.emarte.regurgitator.core.Log.getLog;
import static com.emarte.regurgitator.core.XmlConfigUtil.loadOptionalStr;

public class VelocityProcessorXmlLoader extends VelocityProcessorLoader implements XmlLoader<ValueProcessor> {
    private static final Log log = getLog(VelocityProcessorXmlLoader.class);

    @Override
    public ValueProcessor load(Element element, Set<Object> allIds) throws RegurgitatorException {
        String text = element.getTextContent();
        String value = text != null && text.length() > 0 ? text : null;
        String file = loadOptionalStr(element, FILE);
        return buildVelocityValueProcessor(value, file, log);
    }
}

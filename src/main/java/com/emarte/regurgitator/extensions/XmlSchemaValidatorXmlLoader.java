/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import org.w3c.dom.Element;

import java.util.Set;

import static com.emarte.regurgitator.core.CoreConfigConstants.FILE;
import static com.emarte.regurgitator.core.Log.getLog;
import static com.emarte.regurgitator.core.XmlConfigUtil.loadOptionalStr;

public class XmlSchemaValidatorXmlLoader implements XmlLoader<XmlSchemaValidator> {
    private static final Log log = getLog(XmlSchemaValidatorXmlLoader.class);

    @Override
    public XmlSchemaValidator load(Element element, Set<Object> allIds) throws RegurgitatorException {
        log.debug("Loaded xml schema validator");
        return new XmlSchemaValidator(loadOptionalStr(element, FILE));
    }
}

/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import uk.emarte.regurgitator.core.Log;
import uk.emarte.regurgitator.core.RegurgitatorException;
import uk.emarte.regurgitator.core.XmlLoader;
import org.w3c.dom.Element;

import java.util.Set;

import static uk.emarte.regurgitator.core.CoreConfigConstants.FILE;
import static uk.emarte.regurgitator.core.Log.getLog;
import static uk.emarte.regurgitator.core.XmlConfigUtil.loadOptionalStr;

public class XmlSchemaValidatorXmlLoader implements XmlLoader<XmlSchemaValidator> {
    private static final Log log = getLog(XmlSchemaValidatorXmlLoader.class);

    @Override
    public XmlSchemaValidator load(Element element, Set<Object> allIds) throws RegurgitatorException {
        log.debug("Loaded xml schema validator");
        return new XmlSchemaValidator(loadOptionalStr(element, FILE));
    }
}

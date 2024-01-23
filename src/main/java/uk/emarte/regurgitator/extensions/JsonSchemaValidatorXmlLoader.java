/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import org.w3c.dom.Element;
import uk.emarte.regurgitator.core.Log;
import uk.emarte.regurgitator.core.RegurgitatorException;
import uk.emarte.regurgitator.core.XmlLoader;

import java.util.Set;

import static uk.emarte.regurgitator.core.CoreConfigConstants.FILE;
import static uk.emarte.regurgitator.core.Log.getLog;
import static uk.emarte.regurgitator.core.XmlConfigUtil.loadMandatoryStr;

public class JsonSchemaValidatorXmlLoader implements XmlLoader<JsonSchemaValidator> {
    private static final Log log = getLog(JsonSchemaValidatorXmlLoader.class);

    @Override
    public JsonSchemaValidator load(Element element, Set<Object> allIds) throws RegurgitatorException {
        log.debug("Loaded json schema validator");
        return new JsonSchemaValidator(loadMandatoryStr(element, FILE));
    }
}

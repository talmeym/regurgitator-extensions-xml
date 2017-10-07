/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.RegurgitatorException;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class XmlNameSpaceLoaderTest {
    @Test
    public void testThis() throws RegurgitatorException {
        assertEquals("{rge=http://extensions.regurgitator.emarte.com, rg=http://core.regurgitator.emarte.com}", XmlNamespaceLoader.loadNamespaces(null, "rg=http://core.regurgitator.emarte.com,rge=http://extensions.regurgitator.emarte.com").toString());
    }
}

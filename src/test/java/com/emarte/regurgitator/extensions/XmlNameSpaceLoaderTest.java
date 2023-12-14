/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class XmlNameSpaceLoaderTest {
    @Test
    public void testThis() throws Exception {
        assertEquals("{rge=http://extensions.regurgitator.emarte.com, rg=http://core.regurgitator.emarte.com}", XmlNamespaceLoader.loadNamespaces(null, "rg=http://core.regurgitator.emarte.com,rge=http://extensions.regurgitator.emarte.com").toString());
    }
}

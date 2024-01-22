/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class XmlNameSpaceLoaderTest {
    @Test
    public void testNamespaceLoader() throws Exception {
        assertEquals("{rge=http://extensions.regurgitator.emarte.uk, rg=http://core.regurgitator.emarte.uk}", XmlNamespaceLoader.loadNamespaces(null, "rg=http://core.regurgitator.emarte.uk,rge=http://extensions.regurgitator.emarte.uk").toString());
    }
}

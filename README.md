# regurgitator-extensions-xml

regurgitator is a lightweight, modular, extendable java framework that you configure to 'regurgitate' canned or clever responses to incoming requests; useful for quickly mocking or prototyping services without writing any code. simply configure, deploy and run.

start your reading here: [regurgitator-all](https://talmeym.github.io/regurgitator-all#regurgitator)

read more about regurgitator in xml here: [regurgitator-core-xml](https://talmeym.github.io/regurgitator-core-xml#xml-configuration-of-regurgitator)

[``apidocs``](https://regurgitator.emarte.uk/apidocs/regurgitator-extensions-xml/0.1.3/)

## extension steps in xml

### json-parameter

a json-parameter creates a parameter, extracting its value from within a json document, using json-path:

```xml
<rge:json-parameter name="book-name" source="book-catalogue" json-path="$.catalogue.book.name"/>
```

### xml-parameter

an xml-parameter creates a parameter, extracting its value from within an xml document, using xpath:

```xml
<rge:xml-parameter name="book-name" source="book-catalogue" xpath="/bk:catalogue/bk:book/bk:name">
    <rge:namespaces>
        <rge:namespace prefix="bk" uri="http://books.com"/>
    </rge:namespaces>
</rge:xml-parameter>
```

## extension constructs in xml

### freemarker-builder 

a freemarker-builder aggregates parameter values together using a freemarker template.

```xml
<rge:freemarker-builder source="template-param"/>
```

```xml
<rge:freemarker-builder file="classpath:/template.ftl"/>
```

```xml
<rge:freemarker-builder value="This is a ${descriptive} day!"/>
```

a freemarker-builder can use the same value source attributes as other steps, such as ``create-parameter``, getting its template text from a source parameter, a file or an explicit value, specified as an attribute or element text (but not both).

a freemarker-builder builds from just the ``parameters`` context by default. if the ``all-contexts`` attribute is true, all context data is made available to the builder, with dashes replaced by underscores in context names, and the colon separating context and parameter names replaced with a period, e.g. ``request-metadata:method`` becomes ``request_metadata.method`` when referenced in the template.

```xml
<rge:freemarker-builder all-contexts="true">
    <![CDATA[
        <response>
            <payload>${response_payload.text}</payload>
            <status>${response_metadata.status_code}</status>
            <content>${response_metadata.content_type}</content>
        </response>
    ]]>
</rge:freemarker-builder>
```

```xml
<rge:freemarker-builder all-contexts="true">
    {
        "payload": "${response_payload.text}",
        "status-code": ${response_metadata.status_code},
        "content-type": "${response_metadata.content_type}"
    }
</rge:freemarker-builder>
```

### json-path-processor

a json-path-processor processes a parameter value, extracting a value from it using json path.

```xml
<rg:create-parameter name="book-name" source="book-catalogue">
    <rge:json-path-processor>$.catalogue.book.name</rge:json-path-processor>
</rg:create-parameter>
```

### xpath-processor

an xpath-processor processes a parameter value, extracting a value from it using xpath.

```xml
<rg:create-parameter name="book-name" source="book-catalogue">
    <rge:xpath-processor namespaces="cat=http://catalogues.com,bk=http://books.com" xpath="/cat:catalogue/bk:book/@name"/>
</rg:create-parameter>
```

namespaces for an xpath-processor can also be declared as a child element of the processor:

```xml
<rg:create-parameter name="book-name" source="book-catalogue">
    <rge:xpath-processor xpath="/cat:catalogue/bk:book/@name">
        <rge:namespaces>
            <rge:namespace prefix="cat" uri="http://catalogues.com"/>
            <rge:namespace prefix="bk" uri="http://books.com"/>
        </rge:namespaces>
    </rge:xpath-processor>
</rg:create-parameter>
```

### freemarker-processor

a freemarker-processor processes a parameter value, formatting the value using a freemarker template.

```xml
<rg:create-response source="unformatted-response">
    <rge:freemarker-processor file="classpath:/template.ftl"/>
</rg:create-response>
```

```xml
<rg:create-response source="unformatted-response">
    <rge:freemarker-processor>The response was: ${value}</rge:freemarker-processor>
</rg:create-response>
```

the parameter value is made available to the template as simply ``value``. the template text can be specified in the element text or drawn in from a file.

### json-schema-validator

a json-schema-validator is a ``value-processor`` that validates a parameter value against a json schema file.

```xml
<rg:create-response source="response">
    <rge:json-schema-validator file="classpath:/response_schema.json"/>
</rg:create-response>
```

validating a parameter value can be useful in ensuring that your configured logic and processing always returns valid responses. if the value fails validation, an exception is thrown; if it passes, the value is passed through unchanged.

### xml-schema-validator

an xml-schema-validator is a ``value-processor`` that validates a parameter value against an xml schema file.

```xml
<rg:create-response source="response">
    <rge:xml-schema-validator file="classpath:/response_schema.xsd"/>
</rg:create-response>
```

validating a parameter value can be useful in ensuring that your configured logic and processing always returns valid responses. if the value fails validation, an exception is thrown; if it passes, the value is passed through unchanged.

### contains-json-path

a contains-json-path is a ``condition-behaviour`` that checks whether a parameter's contents contains a sub-value that can be extracted using an json-path expression. if a sub-value can be extracted from the starting value using the json-path expression provided then the condition passes.

```xml
...
    <rg:condition source="parameters:xml" contains-json-path="$.catalog.book.name"/>
...
```

```xml
...
    <rg:condition source="parameters:xml" value="$.catalog.book.name" behaviour="contains-json-path"/>
...
```

the examples above show both ways in which the contains-json-path ``condition-behaviour`` can be used, either in the short form of ``"behaviour-name" : "value"`` or with separate ``value`` and ``behaviour`` attributes.

### contains-xpath

a contains-xpath is a ``condition-behaviour`` that checks whether a parameter's contents contains a sub-value that can be extracted using an xpath expression. if a sub-value can be extracted from the starting value using the xpath expression provided then the condition passes.

```xml
...
    <rg:condition source="parameters:xml" contains-xpath="/catalog/book/@name"/>
...
```

```xml
...
    <rg:condition source="parameters:xml" value="/catalog/book/@name" behaviour="contains-xpath"/>
...
```

```xml
...
    <rg:condition source="parameters:xml">
        <rge:contains-xpath namespaces="cat=http://catalog.com,book=http://book.com">/cat:catalog/book:book/@name</rge:contains-xpath>
    </rg:condition>
...
```

the examples above shows 3 ways in which the contains-xpath ``condition-behaviour`` can be used: in the short form of ``"behaviour-name" : "value"``; with separate ``value`` and ``behaviour`` attributes; or with a child element. When using a child element, you can specify namespaces for the xpath expression using the ``namespaces`` attribute.
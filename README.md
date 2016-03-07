# regurgitator-extensions-xml

regurgitator is a modular, light-weight, extendable java-based processing framework designed to 'regurgitate' canned or clever responses to incoming requests; useful for mocking or prototyping services.

start your reading here: [regurgitator-all](http://github.com/talmeym/regurgitator-all#regurgitator)

read more about regurgitator in xml here: [regurgitator-core-xml](http://github.com/talmeym/regurgitator-core-xml#xml-configuration-of-regurgitator)

## extension steps in xml

### json-parameter

a json-parameter creates a parameter, extracting it's value from within a json document, using json-path:

```xml
<rge:json-parameter name="book-name" source="book-catalogue" json-path="$.catalogue.book.name"/>
```

### xml-parameter

an xml-parameter creates a parameter, extracting it's value from within an xml document, using xpath:

```xml
<rge:xml-parameter name="book-name" source="book-catalogue" xpath="/bk:catalogue/bk:book/bk:name">
	<rge:namespaces>
		<rge:namespace prefix="bk" uri="http://books.com"/>
	</rge:namespaces>
</rge:xml-parameter>
```

## extension constructs in xml

### freemarker-builder 

### velocity-builder

### json-path-processor

### xpath-processor

### freemarker-processor

### velocity-processor

### xml-schema-validator

# regurgitator-extensions-xml

regurgitator is a modular, light-weight, extendable java-based processing framework designed to 'regurgitate' canned or clever responses to incoming requests; useful for mocking or prototyping services.

start your reading here: [regurgitator-all](http://github.com/talmeym/regurgitator-all#regurgitator)

## extension steps in xml

### json-parameter

a json-parameter creates a parameter, extracting it's value from within a json document, using json-path:

```xml
	<rge:json-parameter name="book-name" source="book-catalogue" json-path="$.catalogue.book.name"/>
```

### xml-parameter

an xml-parameter creates a parameter, extracting it's value from within an xml document, using xpath:

```xml
	<rge:xml-parameter name="book-name" source="book-catalogue" xpath="/bk:catalogue/bk:book/bk:name" namespaces="bk=http://books.com"/>
```

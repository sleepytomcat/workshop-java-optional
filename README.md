# workshop-java-optional
Workshop materials for Java Optional workshop. 
Video language: Russian.

0. Problem statement
0. How java.util.Optional helps
0. Optional - use cases
	* return values: checking for null;
	* return values: check if value is present;
	* return values: use default values when null
	* return values: run a method when value present
	* return values: filter result
	* return values: transform result
	* pass Optional as argument - not best practice
	* local variable Optional - no
	* static field Optional - no
	* object field Optional - no
0. Let's implement our own MyOptional class to learn how stuff works:
	* holding a value;
	* get() Optional's value;
	* empty() Optional;
	* get() may return null;
	* check value presence with isPresent();
	* check isPresent() behavior when no value;
	* providing default value with orElse();
	* .orElse(), when null;
	* do something ifPresent()
	* do something ifPresent(), when null
	* filter
	* filter, value present but filtered out
	* filter, when null
	* chained filter()
	* map()
	* map(), when null
	* chained map()

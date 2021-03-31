all: run

clean:
	rm -f out/Bluck.jar out/MyClass.jar

out/Bluck.jar: out/parcs.jar src/Bluck.java src/Node.java
	@javac -cp out/parcs.jar src/Bluck.java src/Node.java
	@jar cf out/Bluck.jar -C src Bluck.class -C src Node.class
	@rm -f src/Bluck.class src/Node.class

out/MyClass.jar: out/parcs.jar src/MyClass.java src/Node.java
	@javac -cp out/parcs.jar src/MyClass.java src/Node.java
	@jar cf out/MyClass.jar -C src MyClass.class -C src Node.class
	@rm -f src/MyClass.class src/Node.class

build: out/Bluck.jar out/MyClass.jar

run: out/Bluck.jar out/MyClass.jar
	@cd out && java -cp 'parcs.jar:Bluck.jar' Bluck

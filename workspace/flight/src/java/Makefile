#
# simple Makefile for the Java Apache SSI servlet
#
# $Id: Makefile,v 1.6 1999/06/21 08:56:46 hzeller Exp $
###

JAVAC=javac -O
#JAVAC=jikes -O
JAR=jar
JARFLAGS=-0cvf

JARFILE=ApacheJSSI.jar

CLASSES= \
	org/apache/java/io/PositionReader.class  \
	org/apache/java/util/SGMLTag.class  \
	org/apache/servlet/ssi/AbstractParseContext.class  \
	org/apache/servlet/ssi/ConfigTagHandler.class  \
	org/apache/servlet/ssi/DelegateHttpServletRequest.class  \
	org/apache/servlet/ssi/EchoTagHandler.class  \
	org/apache/servlet/ssi/ExampleTagHandler.class  \
	org/apache/servlet/ssi/FLastModTagHandler.class  \
	org/apache/servlet/ssi/FSizeTagHandler.class  \
	org/apache/servlet/ssi/HREFParameterPropagator.class  \
	org/apache/servlet/ssi/IncludeTagHandler.class  \
	org/apache/servlet/ssi/OSServletOutputStream.class  \
	org/apache/servlet/ssi/PageParser.class  \
	org/apache/servlet/ssi/PageParserServlet.class  \
	org/apache/servlet/ssi/ParamPropContext.class  \
	org/apache/servlet/ssi/ParameterPropagatingSSI.class  \
	org/apache/servlet/ssi/ParseContext.class  \
	org/apache/servlet/ssi/SSI.class  \
	org/apache/servlet/ssi/SSIContext.class  \
	org/apache/servlet/ssi/SSIHttpServletResponse.class  \
	org/apache/servlet/ssi/SSIOutputStream.class  \
	org/apache/servlet/ssi/SSITagHandler.class  \
	org/apache/servlet/ssi/NoIndexException.class  \
	org/apache/servlet/ssi/ServletTagHandler.class  \
	org/apache/servlet/ssi/SpecialTagHandler.class 

# Didn't dare to write the following -- it's GNU make specific.
#CLASSES=org/apache/java/util/SGMLTag.class			\
#	org/apache/java/io/PositionReader.class			\
#	$(patsubst %.java,%.class,$(wildcard org/apache/servlet/ssi/*.java)) 

# get inner classes as well
JARCLASSES=org/apache/java/util/*.class 	\
	   org/apache/java/io/*.class		\
	   org/apache/servlet/ssi/*.class

all : $(JARFILE)

$(JARFILE) : $(CLASSES)
	$(JAR) $(JARFLAGS) $@ $(JARCLASSES)  

clean :
	rm -f $(JARCLASSES)

distclean: clean
	rm -f $(JARFILE)

# GNU-Make idiom .. anyone knows how this can be done
# in a more portable way ?
%.class : %.java
	CLASSPATH=${CLASSPATH}:. $(JAVAC) $^

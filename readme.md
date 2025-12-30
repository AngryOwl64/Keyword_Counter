# Keyword Counter (Java)

## A simple Java console application that counts how often predefined keywords appear in a given text.

### Features 
-   Manual keyword input or file-based keywords (keywords.txt)
-   Case-insensitive matching
-   Input validation (no empty keywords)
-   Reusable analysis loop
-   Clean console output

### Keyword file format

#### keywords.txt (optional):

java

python

angular

typescript

**One keyword per line. Empty lines are ignored.**

### Usage

javac Main.java

java Main

### Project structure

Main.java

KeywordCounter.java

keywords.txt (optional)

README.md

### Notes

- Falls back to manual input if the file is missing or empty
- Designed as a learning project with focus on clean structure
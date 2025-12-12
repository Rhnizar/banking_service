# Simple Makefile: compile, run, test, clean

SRC_DIR    := src
BIN_DIR    := bin

MAIN_CLASS := Main
TEST_CLASS := AccountTest

JAVA_SOURCES := $(shell find $(SRC_DIR) -name "*.java")


all:
	@echo "Compiling sources..."
	@mkdir -p $(BIN_DIR)
	@javac -d $(BIN_DIR) $(JAVA_SOURCES)

run: all
	@echo "Running $(MAIN_CLASS)..."
	@java -cp $(BIN_DIR) $(MAIN_CLASS)

test: all
	@echo "Running tests..."
	@java -cp $(BIN_DIR) $(TEST_CLASS)

clean:
	@echo "Cleaning compiled classes..."
	@rm -rf $(BIN_DIR)

.PHONY: all run test clean
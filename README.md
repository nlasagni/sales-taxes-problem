# Sales Taxes Problem

Technical assignment concerning a shopping basket which contains products with related sales taxes.

The requirements of this assignment can be found [here](https://github.com/xpeppers/sales-taxes-problem).

## Introduction

This example project has been designed by following the Clean Architecture (taking inspiration from 
[here](https://github.com/carlphilipp/clean-architecture-example))

## Project Structure

The project consists of three main packages, which reflect the layered structure of the Clean Architecture:

- `adapter`
- `domain`
- `usecase`

In addition, the `configuration` package contains the code responsible for creating the main components of the 
application, and for creating the initial data.

## Getting started

#### Prerequisites

- Java 1.8

#### Clone project

```bash
$ git clone https://github.com/nlasagni/sales-taxes-problem.git
$ cd sales-taxes-problem
```

#### Build from source code

Build the project (includes compiling and testing).
```bash
$ gradlew build
```

#### Run example

Run the application, which starts from the `SalesTaxesApplication` class.

```bash
$ gradlew run
```

#### Test

Launch all the test of this project.

```bash
$ gradlew test
```

#### Coverage report

Generate coverage report in HTML format inside the build folder.

```bash
$ gradlew jacocoTestReport
```
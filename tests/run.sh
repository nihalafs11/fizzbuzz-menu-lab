#!/bin/bash
echo "🧪 Running FizzBuzz Menu Tests..."
cd "$(dirname "$0")/.."
mvn -q test

#!/bin/sh
exec scala $0 $@
!#
// Say hello to the first argument
println("Hello, " + args(0) + "!")